package project.rexkyoo.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// SRC

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer>
{
    List<CustomerModel> findAllByTypeEquals(String type);
}
