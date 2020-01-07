package project.rexkyoo.Ambassador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TA

@Repository
public interface AmbassadorRepository extends JpaRepository<AmbassadorModel, Integer>
{}
