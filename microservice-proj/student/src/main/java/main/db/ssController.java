package main.db;
import main.db.ssRepository;
import main.db.ss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by CarrieSong on 2017/6/24.
 */

@RestController

public class ssController {
    @Autowired
    private ssRepository Repository;
    @Autowired
    private ssService ssService;


    @RequestMapping("/ss/delete")
    public void delete(){
        Repository.deleteAll();
    }

    /**保存数据**/
    @RequestMapping("/ss/save")
    public String save(){
        Repository.deleteAll();
        Repository.save(new ss(1L, 1L));
        Repository.save(new ss(1L, 2L));
        Repository.save(new ss(1L, 3L));
        Repository.save(new ss(1L, 4L));
        Repository.save(new ss(2L, 1L));
        Repository.save(new ss(2L, 2L));
        return "done";
    }

    /**获取数据**/
    @RequestMapping("/ss/findAll")
    public Iterable<ss> findAll(){
        return Repository.findAll();
    }

    @GetMapping("/ss/{id}")
    private List findStudentCourse(@PathVariable Long id) {

        List<ss> all = Repository.findAll();
        List<Long> result =new ArrayList<Long>();

        for (Object each:all){
            ss temp = (ss)each;
            if (temp.getStuid() == id){
                result.add(temp.getSubid());
            }
        }
        return result;
    }

    @GetMapping("/ss/{student_id}/delete/{course_id}")
    private String deleteOneCourse(@PathVariable Long student_id,@PathVariable Long course_id) {

        List all = Repository.findAll();
        Repository.deleteAll();
        for (Object each:all){
            ss temp = (ss)each;
            if (temp.getStuid() == student_id && temp.getSubid() == course_id){
                continue;
            }
            Repository.save(temp);
        }

        return "done";
    }

    @GetMapping("/ss/{student_id}/add/{course_id}")
    private String add(@PathVariable Long student_id,@PathVariable Long course_id) {
        Repository.save(new ss(student_id,course_id));

        return "done";
    }
}