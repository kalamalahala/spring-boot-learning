package spring.course.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

    <S extends UserEntity> S save(S entity);
    UserEntity findById(Integer id);
    void deleteById(Integer id);
}
