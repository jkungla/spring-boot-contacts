package contact.service;

import contact.entity.Contact;
import contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl {
    @Autowired
    private ContactRepository repository;

    public List<Contact> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Contact update(Long id, Contact contact) {
        Contact entity = repository.findOne(id);
        entity.setName(contact.getName());
        entity.setEmail(contact.getEmail());
        entity.setAddress(contact.getAddress());
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        Contact contact = repository.findOne(id);
        repository.delete(contact);
    }

    @Transactional
    public Contact create(Contact contact) {
        Contact entity = new Contact();
        entity.setName(contact.getName());
        entity.setEmail(contact.getEmail());
        entity.setAddress(contact.getAddress());
        return repository.saveAndFlush(entity);
    }

}
