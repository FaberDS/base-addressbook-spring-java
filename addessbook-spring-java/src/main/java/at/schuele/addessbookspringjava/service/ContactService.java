package at.schuele.addessbookspringjava.service;

import at.schuele.addessbookspringjava.models.Contact;
import at.schuele.addessbookspringjava.models.enums.ContactSearchFields;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ContactService {
    Contact createContact(Contact contact);
    List<Contact> getContactByLastname(String lastname);

    Optional<Contact> getContactById(long contactId);

    List<Contact> getContactBy(ContactSearchFields[] searchFields, String[] searchValue);

    List<Contact> getAllContacts();

    void deleteContact(long contactId);

    Contact save(Contact contact);
}
