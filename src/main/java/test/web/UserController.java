package test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.model.User;
import test.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(UserController.REST_URL)
public class UserController {
    static final String REST_URL = "/rest/admin/users";

    @Autowired
    private UserRepository repository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User create(User user) {
        return repository.save(user);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return repository.getAll();
    }
}
