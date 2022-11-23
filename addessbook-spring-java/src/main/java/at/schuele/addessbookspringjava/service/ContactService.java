package at.schuele.addessbookspringjava.service;

import at.schuele.addessbookspringjava.models.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    Contact createContact(Contact contact);
    List<Contact> getContactByLastname(String lastname);
    List<Contact> getAllContacts();

    void deleteContact(long contactId);

    Contact updateContact(long contactId,Contact contact);
}
