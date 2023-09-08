package spring.course.services;

import spring.course.model.UserModel;

/**
 * This class is the schema for the user Service class,
 * and it is responsible for holding the methods that the service class must implement.
 * A service class contains the business logic for the application.
 */
public interface UserService {

    UserModel getUser(Integer id);

    void addUser(UserModel requestBody);

    void deleteUser(Integer id);
}
