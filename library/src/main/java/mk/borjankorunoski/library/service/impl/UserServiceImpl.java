package mk.borjankorunoski.library.service.impl;

import mk.borjankorunoski.library.model.User;
import mk.borjankorunoski.library.model.enumerations.Role;
import mk.borjankorunoski.library.repository.UserRepository;
import mk.borjankorunoski.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public int addUser(String username, String password, Role role, String name, String surname) {
        User u = new User(username,password,name,surname,role);
        userRepository.save(u);
        return 1;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElse(new User());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password).orElse(new User());
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElse(new User());
    }
}
