package project.rexkyoo.User.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.User.Models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>
{}
