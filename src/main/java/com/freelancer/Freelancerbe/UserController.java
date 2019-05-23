package com.freelancer.Freelancerbe;

import com.freelancer.Freelancerbe.model.entities.User;
import com.freelancer.Freelancerbe.model.repositories.UserRepository;
import com.freelancer.Freelancerbe.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin
    @RequestMapping(value = "/signup", method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<Map> signupUser(@RequestBody HashMap<String, Object> requestBody) {
        try {
            userService.addUser(
                    (String) requestBody.get("email"),
                    passwordEncoder.encode((String) requestBody.get("password"))
            );
            return  ResponseEntity.status(HttpStatus.CREATED).body(
                    new HashMap<String, Object>(){{
                        put("status", "created");
                        put("message", "User successfully created!");
                    }}
            );
        }catch (Exception e) {
            String message = "Server error. Please try again later!";
            if (e instanceof DataIntegrityViolationException) {
                message = "Email is already used";
            }

            String finalMessage = message;
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new HashMap<String, Object>(){{
                    put("status", "duplicate");
                    put("message", finalMessage);
                }}
            );
        }
    }

    @RequestMapping(value = "/get/{email:.+}", method = RequestMethod.GET)
    public ResponseEntity<Map> getUser(@PathVariable("email") String email) {
        User u = (User)userRepository.findFirstByEmail(email);
        if (u == null) {
            return ResponseEntity.ok().body(
                    new HashMap() {{
                        put("warning", "empty result set");
                    }}
            );
        }
        return ResponseEntity.ok().body(
            new HashMap() {{
                put("email", u.getEmail());
                put("password", u.getPassword());
                put("first_name", u.getFirstName());
                put("last_name", u.getLastName());
            }}
        );
    }

    @RequestMapping(value = "/get/{email:.+}", method = RequestMethod.DELETE)
    public ResponseEntity<Map> deleteUser(@PathVariable("email") String email) {
        User u = (User)userRepository.findFirstByEmail(email);
        try {
            userRepository.delete(u);
            return ResponseEntity.ok().body(
                new HashMap() {{
                    put("message", "User has been successfully deleted");
                }}
            );
        } catch (Exception e) {
            return ResponseEntity.ok().body(
                new HashMap() {{
                    put("message", "Error occured");
                }}
            );
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/edit/{email:.+}", method = RequestMethod.PUT, consumes="application/json")
    public ResponseEntity<Map> editUser(@PathVariable("email") String email, @RequestBody HashMap<String, Object> requestBody) {
        User u = (User)userRepository.findFirstByEmail(email);
        try {
            u.setFirstName((String) requestBody.get("first_name"));
            u.setLastName((String) requestBody.get("last_name"));
            userRepository.save(u);
            return ResponseEntity.ok().body(
                    new HashMap() {{
                        put("message", "User has been successfully edited");
                    }}
            );
        } catch (Exception e) {
            return ResponseEntity.ok().body(
                    new HashMap() {{
                        put("message", "Error occured");
                    }}
            );
        }
    }
}