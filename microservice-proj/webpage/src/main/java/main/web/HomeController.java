package main.web;

import main.service.studentConsumerService;
import main.service.subjectConsumerService;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Home page controller.
 * 
 * @author Paul Chapman
 */
@Controller
public class HomeController {
	@Autowired
	private studentConsumerService stuService;
	@Autowired
	private subjectConsumerService subService;

	@RequestMapping("/")
	public String home() {
		return "login";
	}
	@RequestMapping("/init")
	public String init() {
		stuService.init_ss();
		stuService.init_student();
		subService.init();
		return "login";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(HttpServletRequest request){
//
//        return "course";
//    }


//	@RequestMapping(value = "/student", method = RequestMethod.GET)
//	public String toStudent(HttpServletRequest request, ModelMap map){
//		/*search for courses
//		*all subjects
//		*map.addAttribute("course",subjects)
//		* */
//		return "student";
//	}

//	@RequestMapping(value = "/course", method = RequestMethod.GET)
//	public String toCourse(HttpServletRequest request){
//		return "course";
//	}
}
