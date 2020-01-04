package project.rexkyoo.Contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// SRC

@Repository
public interface ContractRepository extends JpaRepository<ContractModel, Integer>
{
    List<ContractModel> findAllByCustomerTypeEquals(String type);

    List<ContractModel> findAllByCustomerIdEquals(int id);

    List<ContractModel> findAllByTypeEquals(ContractType contractType);
}
