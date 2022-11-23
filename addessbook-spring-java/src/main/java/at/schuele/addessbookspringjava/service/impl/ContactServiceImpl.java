package at.schuele.addessbookspringjava.service.impl;

import at.schuele.addessbookspringjava.models.Contact;
import at.schuele.addessbookspringjava.repository.ContactRepository;
import at.schuele.addessbookspringjava.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository repository;

    @Override
    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public List<Contact> getContactByLastname(String lastname) {
        return (List<Contact>) repository.findByLastName(lastname);
    }

    @Override
    public List<Contact> getAllContacts() {
        return (List<Contact>) repository.findAll();
    }

    @Override
    public void deleteContact(long contactId) {
        repository.deleteById(contactId);
    }

    @Override
    public Contact updateContact(long contactId,Contact contact){
        Optional<Contact> contactToUpdate = repository.findById(contactId);
        if(contactToUpdate.isPresent()) {
            contact.setId(contactToUpdate.get().getId());
        }
        return repository.save(contact);
    }


}
