package ar.edu.unju.edm.app.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.app.domain.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findAllByState(Boolean state);
    public Optional<User> findByEmail(String email);

}