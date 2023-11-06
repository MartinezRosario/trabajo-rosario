package ar.edu.unju.edm.app.data.source;

import ar.edu.unju.edm.app.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.app.domain.model.User;
import ar.edu.unju.edm.app.domain.services.AuthService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements UserDetailsService, AuthService {

    private final UserRepository USER_DATABASE;

    public AuthServiceImpl(UserRepository USER_DATABASE) {
        this.USER_DATABASE = USER_DATABASE;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = USER_DATABASE.findByEmail(email).get();
        String rol = user.getType();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(rol));
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), authorities);
    }

    @Override
    public void addUser(User user) {
        String password = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        user.setPassword(encoder.encode(password));
        USER_DATABASE.save(user);
    }

}