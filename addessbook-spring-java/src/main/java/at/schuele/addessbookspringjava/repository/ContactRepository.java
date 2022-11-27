package at.schuele.addessbookspringjava.repository;

import at.schuele.addessbookspringjava.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByLastName(@Param("name") String name);
    List<Contact> findByFirstName(@Param("name") String name);
    List<Contact> findByLastNameAndFirstName(@Param("lastName") String lastName,@Param("firstName") String firstName);
    List<Contact> findByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);
}