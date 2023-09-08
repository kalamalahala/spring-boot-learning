package spring.course.services;

import spring.course.model.UserModel;

public interface UserService {

    UserModel getUser(Integer id);

    void addUser(UserModel requestBody);

    void deleteUser(Integer id);

    boolean userExists(Integer id);
}
