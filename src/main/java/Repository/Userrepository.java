package Repository;

import Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends MongoRepository<Users, Integer> {
}
