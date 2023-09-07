package spring.course.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.course.model.UserModel;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final Map<Integer, UserModel> userMap = new HashMap<>();

    public UserController() {

        userMap.put(1, new UserModel("user1", "John", "Doe", 1));

    }

    @GetMapping("/getUser")
    public String getUser() {
        return "Please provide an id";
    }

    @GetMapping("/getUser/{id}")
    public UserModel getUser(@PathVariable Integer id) {
        System.out.println("getUser called with id: " + id);
        return userMap.get(id);
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserModel requestBody) {
        System.out.println("addUser called with body: " + requestBody);
        userMap.put(requestBody.getId(), requestBody);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
        System.out.println("deleteUser called with id: " + id);
        // check if user id exists in map
        if (!userMap.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

        userMap.remove(id);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
