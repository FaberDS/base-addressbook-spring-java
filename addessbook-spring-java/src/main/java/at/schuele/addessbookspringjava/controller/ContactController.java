package at.schuele.addessbookspringjava.controller;

import at.schuele.addessbookspringjava.models.Contact;
import at.schuele.addessbookspringjava.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactController {
    @Autowired
    ContactService contactService;
    @GetMapping
    public List<Contact> getContacts(){
        return contactService.getAllContacts();
    }

    //creating post mapping that post the book detail in the database
    @PostMapping
    private long saveContact(@RequestBody Contact contact)
    {
        contactService.createContact(contact);
        return contact.getId();
    }

    @DeleteMapping("/{contact_id}")
    private void deleteContact(@PathVariable("contact_id") long contactId) {
        contactService.deleteContact(contactId);
    }

    @PutMapping("/{contact_id}")
    private Contact updateContact(@PathVariable("contact_id") long contactId, @RequestBody Contact contact) {
        return contactService.updateContact(contactId,contact);
    }
}
