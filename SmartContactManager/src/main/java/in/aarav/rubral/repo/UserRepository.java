package in.aarav.rubral.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aarav.rubral.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
