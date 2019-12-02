package project.rexkyoo.Ambassador.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Ambassador.Models.AmbassadorModel;

@Repository
public interface AmbassadorRepository extends JpaRepository<AmbassadorModel, Integer>
{}