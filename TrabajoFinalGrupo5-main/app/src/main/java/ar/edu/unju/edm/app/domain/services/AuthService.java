package ar.edu.unju.edm.app.domain.services;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.app.domain.model.User;

@Service
public interface AuthService {

    public void addUser(User user);

}