package com.sample.repo.service;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.server.Tracer;

public class GitHubService {
    private static final String HOST ="https://api.github.com/search/repositories";
    private static final Logger LOG = LoggerFactory.getLogger(GitHubService.class);
    
    public HttpResponse search(String q, String sort, String order) throws Exception {
        
        final RequestBuilder requestBuilder =  RequestBuilder.create("GET")
                .setUri(new URI(HOST));
        
        //build parameters
        requestBuilder.addParameter("q", q);
        requestBuilder.addParameter("sort", sort);
        requestBuilder.addParameter("order", order);
        
        final HttpUriRequest request = requestBuilder.build();
        
        Tracer.mark(String.format("start:%s", HOST));
        HttpResponse result = null;
        try {
            result = getHttpClient().execute(request);
            int statusCode = result.getStatusLine().getStatusCode();
            LOG.info(String.format("accessing to url %s , status %s", HOST, statusCode));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        Tracer.markAndOutput(String.format("end:%s", HOST));
        return result;
    }
    /**
     * get httpClient object
     * */
    private CloseableHttpClient getHttpClient() throws Exception {
        return  HttpClients.custom()
                //.setDefaultRequestConfig(config)
                //.setConnectionReuseStrategy(ConnectionReuseStrategy)
           //.setRedirectStrategy(new LaxRedirectStrategy())
         //  .setSSLSocketFactory(ignoreSSLConnectionSocketFactory())
          //.setMaxConnPerRoute(100)
          // .setMaxConnTotal(100)
           .build();
    }
    
    //ignore ssl certificate for some reason java7 
//    private SSLConnectionSocketFactory ignoreSSLConnectionSocketFactory() throws Exception {
//
//        final SSLContextBuilder builder = new SSLContextBuilder();
//        builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
//        final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build(),
//                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//        return sslsf;
//    }
}
