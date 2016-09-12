package com.khalibre.repo.web;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khalibre.repo.service.GitHubService;



/**
 * @author sophea <a href='mailto:sopheamak@gmail.com'> sophea </a>
 * @version $id$ - $Revision$
 * @date 2016
 */
@Controller
@RequestMapping(value = "/")
public class SearchController {

    private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);
    @Autowired
    private GitHubService service;
 
    /**
     *
     * GET API http://localhost:8080/khalibre-assignment-sophea/search?q=liferay-portal
     * 
     * @param q - The search keywords, as well as any qualifiers. required
     * @param sort - The sort field. One of stars, forks, or updated. Default: stars.
     * @param order The sort order if sort parameter is provided. One of asc or desc (default).
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public void searchGitHub(HttpServletRequest request,HttpServletResponse response,
            @RequestParam String q, @RequestParam(defaultValue="stars") String sort, 
            @RequestParam(defaultValue="desc") String order) throws Exception {
        
        LOG.debug(String.format("search  q = %s, sort %s, order %s", q, sort, order));
        
        final InputStream result = service.search(q, sort, order);
        if (result == null) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        } else {
            response.setContentType("application/json; charset=utf-8");
            //copy result into response
            IOUtils.copy(result, response.getOutputStream());
        }
    }

   
}
