package com.khalibre.repo.server;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.khalibre.repo.service.GitHubService;
import com.khalibre.repo.service.GitHubServiceTest;
import com.khalibre.server.MvcConfig;
import com.khalibre.server.SkipNullObjectMapper;

@Configuration
@PropertySource(name = "application", value = { "classpath:/application.properties" })
public class TestMvcConfig extends MvcConfig {
    protected static final Logger LOG = LoggerFactory.getLogger(AbstractWebAppTest.class);

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        final SkipNullObjectMapper skipNullMapper = new SkipNullObjectMapper();

        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        skipNullMapper.setDateFormat(formatter);
        skipNullMapper.init();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(skipNullMapper);
        converters.add(converter);
    }
    
    @Override
    public GitHubService gitHubService() {
        return new GitHubServiceTest();
    }
}
