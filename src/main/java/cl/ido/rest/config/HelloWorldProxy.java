package cl.ido.rest.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import cl.ido.rest.helloworld.wsdl.GetPersona;
import cl.ido.rest.helloworld.wsdl.GetPersonaResponse;
import cl.ido.rest.helloworld.wsdl.ObjectFactory;
import cl.ido.rest.helloworld.wsdl.Persona;

public class HelloWorldProxy extends WebServiceGatewaySupport {
    
	@SuppressWarnings("unchecked")
    public Persona obtenerPersona(String name) {

        ObjectFactory factory = new ObjectFactory();

        GetPersona request = factory.createGetPersona();
        request.setName(name);

        GetPersonaResponse responseElement = (GetPersonaResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return responseElement.getGetPersonaReturn();

    }
}