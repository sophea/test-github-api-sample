package com.sample.repo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.repo.domain.Person;
import com.sample.repo.service.PersonService;

@Controller
public class PersonController {
	
    @Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	/**return as json REST-API*/
	@RequestMapping(value = "/persons/json", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> listPersons() {
        return new ResponseEntity<>(personService.listPersons(), HttpStatus.OK);
    }
	
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == null || p.getId() == 0L){
			//new person, add it
			this.personService.create(p);
		}else{
			//existing person, call update
			this.personService.update(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/person/remove/{id}")
    public String removePerson(@PathVariable("id") long id){
		
	    Person domain = personService.getPersonById(id);
        if ( domain == null) {
            System.out.println(String.format("id [%s] is not found", id));
            
        } else {
            this.personService.removePerson(id);
        }
        return "redirect:/persons";
    }
 
    @RequestMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
}
