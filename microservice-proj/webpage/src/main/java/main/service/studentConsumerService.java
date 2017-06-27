package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import main.domain.subject;
/**
 * Created by sei_s on 2017/6/25.
 */
@Service
public class studentConsumerService {
    @Autowired
    private RestTemplate restTemplate;

    public String findPasswdById(Long id) {
        return restTemplate.getForObject("http://STUDENT-SERVER/student/" + id, String.class);
    }

    public List findStudentCourseId(Long id) {
        return restTemplate.getForObject("http://STUDENT-SERVER/ss/" + id, List.class);
    }

    public subject StudentCourseDetail(Long id) {
        return restTemplate.getForObject("http://SUBJECT-SERVER/subject/findone/" + id, subject.class);
    }

    public String deleteOneCourse(Long student_id,Long course_id) {
        return restTemplate.getForObject("http://STUDENT-SERVER/ss/" + student_id +"/delete/"+course_id, String.class);
    }

    public String add(Long student_id, Long course_id) {
        return restTemplate.getForObject("http://STUDENT-SERVER/ss/" + student_id +"/add/"+course_id, String.class);
    }

    public String init_student(){
        return restTemplate.getForObject("http://STUDENT-SERVER/student/save/", String.class);
    }

    public String init_ss(){
        return restTemplate.getForObject("http://STUDENT-SERVER/ss/save/", String.class);
    }
}
