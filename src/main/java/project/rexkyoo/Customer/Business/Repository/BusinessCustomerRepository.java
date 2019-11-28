package project.rexkyoo.Customer.Business.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Customer.Business.Model.BusinessCustomerModel;

@Repository
public interface BusinessCustomerRepository extends JpaRepository<BusinessCustomerModel, Integer>
{
}
