package at.schuele.addessbookspringjava.service.impl;

import at.schuele.addessbookspringjava.errors.NoContactFoundException;
import at.schuele.addessbookspringjava.models.Contact;
import at.schuele.addessbookspringjava.models.enums.ContactSearchFields;
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
    public Optional<Contact> getContactById(long contactId) {
        return repository.findById(contactId);
    }

    @Override
    public List<Contact> getContactBy(ContactSearchFields[] searchFields, String[] searchValue){
        if (searchFields.length == 0 ) {
            return null;
        }
        if ( searchFields.length == 1 ){
            if (searchFields[0] == ContactSearchFields.lastName) {
                String searchString = searchValue.length > 0 ? searchValue[0] : "";
                return repository.findByLastName(searchString);
            } else if (searchFields[0] == ContactSearchFields.firstName) {
                String searchString = searchValue.length > 0 ? searchValue[0] : "";
                return repository.findByFirstName(searchString);
            }
        } else if (searchFields.length == 2){
            if (searchFields[0] == ContactSearchFields.lastName) {
                String searchString1 = searchValue.length > 0 ? searchValue[0] : "";
                String searchString2 = searchValue.length > 1 ? searchValue[1] : "";
                return repository.findByLastNameAndFirstName(searchString1, searchString2);
            } else if (searchFields[0] == ContactSearchFields.firstName) {
                String searchString1 = searchValue.length > 0 ? searchValue[0] : "";
                String searchString2 = searchValue.length > 1 ? searchValue[1] : "";
                return repository.findByFirstNameAndLastName(searchString1, searchString2);
            }
        }
        return null;
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
    public Contact save(Contact contact) {
        return repository.save(contact);
    }

}
