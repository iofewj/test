package main.db;

import main.db.ss;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Service
public class ssService {

    public List findStudentCourseId(Long id,ssRepository repository) {
        List return_list = repository.findAll();
        return return_list;
    }
}
