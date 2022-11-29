package at.schuele.addessbookspringjava.controller;

import at.schuele.addessbookspringjava.errors.NoContactFoundException;
import at.schuele.addessbookspringjava.models.Contact;
import at.schuele.addessbookspringjava.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contacts")
public class ContactController {
    @Autowired
    ContactService contactService;
    @GetMapping
    @Operation(summary = "Get all contacts.")
    public List<Contact> getContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping("/{contact_id}")
    @Operation(summary = "Get contact by id. If the contact not exist NoContactFoundException exception will be thrown")
    public Contact getContactById(@PathVariable("contact_id") long contactId) {
        Optional<Contact> result = contactService.getContactById(contactId);
        if (result.isPresent()){
            return result.get();
        }
        throw new NoContactFoundException("No user found with " + String.valueOf(contactId));
    }

    @ExceptionHandler(NoContactFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(
            NoContactFoundException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    //creating post mapping that post the book detail in the database
    @PostMapping
    @Operation(summary = "Creates a contact with the passed details.")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Object> saveContact(@RequestBody Contact contact)
    {
        Contact newContact = contactService.createContact(contact);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newContact.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{contact_id}")
    @Operation(summary = "Delete Contact by contact id.")
    private void deleteContact(@PathVariable("contact_id") long contactId) {
        if(contactService.getContactById(contactId).isPresent()) {
            contactService.deleteContact(contactId);
        } else {
            throw new NoContactFoundException(String.format("No user found with id: %s",String.valueOf(contactId)));
        }

    }

    @PutMapping("/{contact_id}")
    @Operation(summary = "Update Contact by contact id.")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<Object> updateContact(@PathVariable("contact_id") long contactId, @RequestBody Contact contact) {

        Optional<Contact> contactToUpdate = contactService.getContactById(contactId);
        if (contactToUpdate.isEmpty()){
            throw new NoContactFoundException(String.format("No user found with id: %s",String.valueOf(contactId)));
        }
        contact.setId(contactToUpdate.get().getId());
        contactService.save(contact);
        return ResponseEntity.noContent().build();
    }
}
