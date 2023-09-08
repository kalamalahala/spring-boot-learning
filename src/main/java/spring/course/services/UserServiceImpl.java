package spring.course.services;

import org.springframework.stereotype.Service;
import spring.course.model.UserModel;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, UserModel> userMap = new HashMap<>();
    private final TimeService timeService;

    public UserServiceImpl(TimeService timeService) {
        this.timeService = timeService;
        String currentTime = timeService.getCurrentTime("America/New_York");
        userMap.put(1, new UserModel("user1", "John", "Doe", 1, currentTime));
    }

    public UserModel getUser(Integer id) {
        return userMap.get(id);
    }

    public void addUser(UserModel user) {
        user.setDateTimeCreated(timeService.getCurrentTime("America/New_York"));
        userMap.put(user.getId(), user);
    }

    public void deleteUser(Integer id) {
        userMap.remove(id);
    }

    public boolean userExists(Integer id) {
        return userMap.containsKey(id);
    }


}
