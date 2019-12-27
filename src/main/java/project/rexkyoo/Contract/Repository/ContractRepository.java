package project.rexkyoo.Contract.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Contract.Model.ContractModel;

import java.util.List;


@Repository
public interface ContractRepository extends JpaRepository<ContractModel, Integer>
{
    List<ContractModel> findAllByCustomerTypeEquals(String type);

    List<ContractModel> findAllByCustomerIdEquals(int id);
}
