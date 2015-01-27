package cl.ido.rest.component;

import java.util.Date;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import cl.ido.rest.Person;
import cl.ido.rest.config.HelloWorldProxy;
import cl.ido.rest.helloworld.wsdl.Persona;

@Component
public class PersonService implements IPersonService {

	@Override
	public Person getPerson(String name) {
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("cl.ido.rest.helloworld.wsdl");
		
		HelloWorldProxy proxy = new HelloWorldProxy();
		proxy.setDefaultUri("http://localhost:8080/WSExample/services/HelloWorld");
		proxy.setMarshaller(marshaller);
		proxy.setUnmarshaller(marshaller);
		
		Persona persona = proxy.obtenerPersona(name);
		Person person = new Person();
		person.setName(persona.getName());
		person.setLastName(persona.getLastName());
		person.setCreation(new Date());
		return person;
	}

}