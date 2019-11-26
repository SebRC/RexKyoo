package project.rexkyoo.Customer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Customer.Models.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer>
{
}
