package com.sample.repo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.sample.repo.server.AbstractWebAppTest;

public class PersonContollerTest extends AbstractWebAppTest {
   
    
    public PersonContollerTest() {
      
    }
    @Test
    public void testGetPersons() throws Exception {
        ResultActions result = server
                .perform(get("/persons/json"));
        LOG.info("===== Test Result : {}", json(result));
        status200(result);
        
        result = server.perform(get("/persons"));
    }
    
    @Test
    public void testPerson() throws Exception {
        ResultActions result = server
                .perform(post("/person/add").param("name", "myname").param("country", "myCountry"));
        status302(result);
        
        result = server
                .perform(post("/person/add").param("name", "myname").param("country", "myCountry").param("id", "1"));
        
        
        result = server
                .perform(post("/person/edit/1").param("name", "myname").param("country", "myCountry"));
        
        
        result = server
                .perform(post("/person/remove/1"));
    }
    
}
