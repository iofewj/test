package main.db;

import main.db.subjectRepository;
import main.db.subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by CarrieSong on 2017/6/24.
 */

@RestController
public class subjectController {

    @Autowired
    private subjectRepository subjectRepository;


    @RequestMapping("/subject/delete")
    public void delete(){
        subjectRepository.deleteAll();
    }

    /**保存数据**/
    @RequestMapping("/subject/save")
    public String save(){
        subjectRepository.deleteAll();
        subjectRepository.save(new subject(1L, "C++", "王丽萍","周二上午一二节"));
        subjectRepository.save(new subject(2L, "操作系统", "钱卫宁","周一上午三四节"));
        subjectRepository.save(new subject(3L, "离散数学", "朱惠彪","周四下午五六节"));
        subjectRepository.save(new subject(4L, "高等数学", "温玉亮","周二上午三四节"));
        subjectRepository.save(new subject(5L, "海量数据挖掘", "金澈清","周一下午五到七节"));
        subjectRepository.save(new subject(6L, "大规模分布式系统", "宫学庆","周一上午二到四节"));
        return "done";
    }

    /**获取数据**/
    @RequestMapping("/subject/findAll")
    public List<subject> findAll(){
        return subjectRepository.findAll();
    }

    @RequestMapping("/subject/findone/{id}")
    public subject findOne(@PathVariable Long id){
        return subjectRepository.findOne(id);
    }
}