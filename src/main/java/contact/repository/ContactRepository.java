package contact.repository;

import contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jarmodev on 11.10.2017.
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
