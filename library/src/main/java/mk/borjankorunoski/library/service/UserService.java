package mk.borjankorunoski.library.service;

import mk.borjankorunoski.library.model.User;
import mk.borjankorunoski.library.model.enumerations.Role;

import java.util.List;

public interface UserService {
    int addUser(String username, String password, Role role, String name, String surname);
    User getUser(String username);
    List<User> getAllUsers();
    User getUserByUsernameAndPassword(String username, String password);
}
