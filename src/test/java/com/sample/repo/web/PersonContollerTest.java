package com.sample.repo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
    }
    
}
