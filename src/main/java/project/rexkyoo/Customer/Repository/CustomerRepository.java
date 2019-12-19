package project.rexkyoo.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Customer.Model.CustomerModel;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer>
{
    List<CustomerModel> findAllByTypeEquals(String type);

    List<CustomerModel>findAllByOrderByIdDesc();
}
