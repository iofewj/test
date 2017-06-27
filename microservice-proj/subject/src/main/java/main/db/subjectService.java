package main.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.db.subjectRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.db.subject;

/**
 * Created by sei_s on 2017/6/25.
 */
@Service
public class subjectService {

    @Autowired
    private subjectRepository subRepository;

    public List<subject> findAll(){
        return subRepository.findAll();
    }

    public subject allStudentCourseDetail(Long id) {
//        List<subject> course = subRepository.findAll();
        return subRepository.findOne(id);
    }
}
