package com.mendixweb.mendix.repos;
import com.mendixweb.mendix.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
