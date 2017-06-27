package main.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.db.student;
import main.db.studentRepository;

import java.util.List;

/**
 * Created by CarrieSong on 2017/6/24.
 */

@RestController
@RequestMapping(value="/student")     // 通过这里配置使下面的映射都在/student，可去除
public class studentController {
    @Autowired
    private studentRepository stuRepository;
    @Autowired
    private studentService stuService;


    @RequestMapping("/delete")
    public void delete(){
        stuRepository.deleteAll();
    }

    /**保存数据**/
    @RequestMapping("/save")
    public String save(){
        stuRepository.deleteAll();
        stuRepository.save(new student(1L, "51164500111", "123456789"));
        stuRepository.save(new student(2L, "51164500112", "123456789"));
        stuRepository.save(new student(3L, "10122510102", "123456789"));
        stuRepository.save(new student(4L, "10122510111", "123456789"));
        stuRepository.save(new student(5L, "10122110142", "123456789"));
        stuRepository.save(new student(6L, "10122510129", "123456789"));
        return "done";
    }

    /**获取数据**/
    @RequestMapping("/findAll")
    public Iterable<student> findAll(){
        return stuRepository.findAll();
    }

    @GetMapping("/{id}")
    private String findById(@PathVariable Long id) {
//        String result = new String();
//        student a =  stuRepository.findOne(id);
//
//        if(a == null)
//            result = "false";
//        else
//            result = a.getPwd();
//        return result;
        String name = Long.toString(id);
        List all = stuRepository.findAll();
        for(Object each:all){
            student temp = (student)each;
            if(temp.getName().equals(name)){
                return temp.getPwd();
            }
        }
        return "false";
    }

}
