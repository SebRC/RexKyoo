package project.rexkyoo.CustomerPaymentDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPaymentDateRepository extends JpaRepository<CustomerPaymentDateModel, Integer>
{
}
