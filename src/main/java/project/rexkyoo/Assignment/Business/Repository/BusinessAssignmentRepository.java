package project.rexkyoo.Assignment.Business.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Assignment.Private.Model.BusinessAssignmentModel;


@Repository
public interface BusinessAssignmentRepository extends JpaRepository<BusinessAssignmentModel, Integer> {

}
