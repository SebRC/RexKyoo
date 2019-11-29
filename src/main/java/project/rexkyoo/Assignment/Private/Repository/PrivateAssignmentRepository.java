package project.rexkyoo.Assignment.Private.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Assignment.Private.Model.PrivateAssignmentModel;

@Repository
public interface PrivateAssignmentRepository extends JpaRepository<PrivateAssignmentModel, Integer>
{}
