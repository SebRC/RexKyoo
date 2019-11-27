package project.rexkyoo.Customer.Private.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Customer.Private.Model.PrivateCustomerModel;

@Repository
public interface PrivateCustomerRepository extends JpaRepository<PrivateCustomerModel, Integer>
{
}
