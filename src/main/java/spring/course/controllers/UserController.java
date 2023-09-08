package spring.course.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.course.model.UserModel;
import spring.course.services.UserService;

import java.util.Optional;

/**
 * This class is the controller for the user model.
 * This class is responsible for handling the requests and responses for the
 * user model class, and it is the only class that can access the service class.
 */
@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getUser")
    public String getUser() {
        return "Please provide an id";
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Optional<UserModel>> getUser(@PathVariable Integer id) {
        System.out.println("service.getUser called with id: " + id);
        return ResponseEntity.ofNullable(Optional.ofNullable(service.getUser(id)));

    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserModel requestBody) {
        System.out.println("addUser called with body: " + requestBody);
        // check if user id exists in map
        service.addUser(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
        System.out.println("deleteUser called with id: " + id);
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
