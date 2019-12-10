package project.rexkyoo.CustomerPaymentDate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;

@Repository
public interface CustomerPaymentDateRepository extends JpaRepository<CustomerPaymentDateModel, Integer>
{

}
