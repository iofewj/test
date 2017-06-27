package main.web;

import main.domain.subject;
import main.service.studentConsumerService;
import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by sei_s on 2017/6/25.
 */
@Controller
//@RequestMapping("/loginid")
public class passwdController {
    @Autowired
    private studentConsumerService consumerService;

    String username;
    String password;

    /**
     * 采用缺省配置
     * */
    static {
        BasicConfigurator.configure();
    }

//    @GetMapping("/")
//    public String findById(@PathVariable Long id) {
//        String passwd = consumerService.findPasswdById(id);
//        return passwd;
//    }

    @GetMapping("/loginid")
    public String findById(HttpServletRequest request,Model map) {
        username = request.getParameter("username");
        password = request.getParameter("password");
        Long id = Long.parseLong(username);
        String true_passwd = consumerService.findPasswdById(id);
        if( true_passwd.equals(password))
        {
            List all_course_id = consumerService.findStudentCourseId(id);
            List<subject> result =new ArrayList<subject>();

            for(Object each:all_course_id){
                Long course_id = Long.parseLong((String)each);
                result.add(consumerService.StudentCourseDetail(course_id));
            }

            map.addAttribute("stu_course",result);
            return "/student";
        }
        else
            return "login";
    }

    @GetMapping("/student")
    private String findStudentCourse(Model map) {
        Long id = Long.parseLong(username);
        List all_course_id = consumerService.findStudentCourseId(id);
        List<subject> result =new ArrayList<subject>();

        for(Object each:all_course_id){
            Long course_id = Long.parseLong((String)each);
            result.add(consumerService.StudentCourseDetail(course_id));
        }

        map.addAttribute("stu_course",result);

        return "/student";
    }

    @GetMapping("/student/delete")
    private String deleteStudentCourse(HttpServletRequest request, Model map) {
        Long deleteCourseId = Long.parseLong(request.getParameter("id"));
        Long student_id = Long.parseLong(username);
        String delete_result = consumerService.deleteOneCourse(student_id,deleteCourseId);

        if(delete_result.equals("done")){
        List all_course_id = consumerService.findStudentCourseId(student_id);
        List<subject> result =new ArrayList<subject>();

        for(Object each:all_course_id){
            Long course_id = Long.parseLong((String)each);
            result.add(consumerService.StudentCourseDetail(course_id));
        }
        map.addAttribute("stu_course",result);
        }
        else{
        }
        return "/student";
    }

    @RequestMapping(value = "/course/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request,Model map) {
        Long student_id = Long.parseLong(username);
        Long addCourseId = Long.parseLong(request.getParameter("id"));
        String add_result = consumerService.add(student_id, addCourseId);
        this.findStudentCourse(map);
//        if(add_result.equals("done")){
//            List all_course_id = consumerService.findStudentCourseId(student_id);
//            List<subject> result =new ArrayList<subject>();
//
//            for(Object each:all_course_id){
//                Long course_id = Long.parseLong((String)each);
//                result.add(consumerService.StudentCourseDetail(course_id));
//            }
//            map.addAttribute("stu_course",result);
//        }
//        else{
//        }
        return "student";
    }
}
