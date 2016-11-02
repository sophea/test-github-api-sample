package com.sample.repo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.sample.repo.server.AbstractWebAppTest;

public class SearchContollerTest extends AbstractWebAppTest {
    
    public SearchContollerTest() {
    }
    @Test
    public void testGetSearch() throws Exception {
        ResultActions result = server
                .perform(get("/search").param("q", "liferay-portal"));
        
        LOG.info("===== Test Result : {}", json(result));
        status200(result);
    }
    
}
