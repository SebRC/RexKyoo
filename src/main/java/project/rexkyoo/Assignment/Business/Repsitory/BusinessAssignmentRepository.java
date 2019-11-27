package project.rexkyoo.Assignment.Business.Repsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Assignment.Business.Model.BusinessAssignmentModel;

@Repository
public interface BusinessAssignmentRepository extends JpaRepository<BusinessAssignmentModel, Integer>
{
}
