package spring.course.services;

import org.springframework.stereotype.Service;
import spring.course.data.UserEntity;
import spring.course.data.UserRepository;
import spring.course.mappers.EntityMapper;
import spring.course.mappers.UserEntityMapper;
import spring.course.model.UserModel;

/**
 * This class is the implementation of the user Service interface.
 * This class is responsible for implementing the methods that the service interface requires.
 * A service class contains the business logic for the application and
 * acts as a middleman between the controller and the repository.
 */
@Service
public class UserServiceImpl implements UserService {

    private final TimeService timeService;
    private final UserRepository userRepository;
    private final EntityMapper<UserEntity, UserModel> entityMapper;

    public UserServiceImpl(TimeService timeService, UserRepository userRepository, EntityMapper<UserEntity, UserModel> entityMapper) {
        this.timeService = timeService;
        this.userRepository = userRepository;
        this.entityMapper = entityMapper;
    }

    public UserModel getUser(Integer id) {
        return entityMapper.entityToModel(userRepository.findById(id));
    }

    public void addUser(UserModel user) {
        user.setDateTimeCreated(timeService.getCurrentTime("America/New_York"));
        userRepository.save(entityMapper.modelToEntity(user));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id.toString());
    }


}
