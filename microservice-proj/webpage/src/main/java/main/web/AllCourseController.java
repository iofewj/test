package main.web;

import com.mongodb.util.JSON;
import main.service.subjectConsumerService;
import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import main.domain.subject;


import java.io.IOException;
import java.util.List;

/**
 * Created by sei_s on 2017/6/25.
 */
@Controller
public class AllCourseController {
    @Autowired
    private subjectConsumerService consumerService;

    /**
     * 采用缺省配置
     * */
    static {
        BasicConfigurator.configure();
    }

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String AllCourse(HttpServletRequest request,Model map) {

        List<subject> subjects = consumerService.findAll();
        map.addAttribute("subjects",subjects);

        return "course";
    }

}
