package main.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import main.db.student;
/**
 * Created by CarrieSong on 2017/6/24.
 */
public interface studentRepository extends MongoRepository<student, Long> {

}
