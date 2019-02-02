package test.model;

import org.springframework.stereotype.Component;

@Component
public class User extends AbstractBaseEntity {
    private String name;
    private String password;
    private String email;
    private Role role;

    public User() {

    }

    public User(Integer id, String name, String password, String email, Role role) {
        super(id);
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
