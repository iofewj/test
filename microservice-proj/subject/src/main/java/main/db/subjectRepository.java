package main.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import main.db.subject;


/**
 * Created by CarrieSong on 2017/6/24.
 */
public interface subjectRepository extends MongoRepository<subject, Long> {
}
