package com.sample.repo.service;

import java.io.ByteArrayInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.repo.service.GitHubService;

/**
 * @author Sophea <a href='mailto:sopheamak@gmail.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2016
 */
public class GitHubServiceTest extends GitHubService {
    
    private static final Logger LOG = LoggerFactory.getLogger(GitHubServiceTest.class);
    
    @Override
    public HttpResponse search(String q, String sort, String order) throws Exception {
        LOG.info("Passed the search Mock TEST Service");
        HttpResponse mockHttpResponse = null;
        mockHttpResponse = new BasicHttpResponse(
                new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK"));
        
        BasicHttpEntity entity = new BasicHttpEntity();
        byte[] message = "data".getBytes();
        entity.setContent(new ByteArrayInputStream(message));
        
        mockHttpResponse.setEntity(entity);
        
        return mockHttpResponse;
    }
    
    @org.junit.Test
    public void testSearch() throws Exception {
        search("test", "stars", "asc");
    }

}
