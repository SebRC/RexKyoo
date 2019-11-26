package project.rexkyoo.Customer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.rexkyoo.Customer.Models.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Integer>
{
}
