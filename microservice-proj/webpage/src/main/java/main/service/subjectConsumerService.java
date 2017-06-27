package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import main.domain.subject;

import java.util.List;

/**
 * Created by sei_s on 2017/6/25.
 */
@Service
public class subjectConsumerService {
    @Autowired
    private RestTemplate restTemplate;

    public List findAll() {
        return restTemplate.getForObject("http://SUBJECT-SERVER/subject/findAll", List.class);
    }
    public String init(){
        return restTemplate.getForObject("http://SUBJECT-SERVER/subject/save", String.class);
    }
}



