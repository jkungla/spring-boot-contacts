package contact.controller;

import contact.entity.Contact;
import contact.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
@RequestMapping("/contacts")
public class ContactsController extends WebMvcConfigurerAdapter {
    @Autowired
    private ContactServiceImpl service;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("contacts", service.findAll());
        model.addAttribute("newContact", new Contact());
        return "contacts";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestParam Long id, Contact contact) {
        service.update(id, contact);
        return "redirect:/contacts";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/contacts";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(@Valid @ModelAttribute("newContact") Contact contact, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("newContact", contact);
            model.addAttribute("contacts", service.findAll());
            return "contacts";
        } else {
            service.create(contact);
            return "redirect:/contacts";
        }
    }
}
