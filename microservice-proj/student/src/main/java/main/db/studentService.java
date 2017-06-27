package main.db;

/**
 * Created by sei_s on 2017/6/25.
 */
import main.db.student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class studentService {

    public String findUserPasswdById(Long id,studentRepository stuRepository) {
        return stuRepository.findOne(id).getPwd();
    }
}
