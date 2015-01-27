package cl.ido.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.ido.rest.component.IPersonService;

@RestController
@RequestMapping("/controller")
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	
	@RequestMapping("/person")
	public Person getPersonDetail(@RequestParam(value = "name", required = false, defaultValue = "John") String name) {
		Person p = personService.getPerson(name);
		return p;
	}
}
