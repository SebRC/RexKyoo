package project.rexkyoo.Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Assignment.Model.AssignmentModel;


@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentModel, Integer>
{}
