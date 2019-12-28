package project.rexkyoo.Contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService
{
    @Autowired
    private ContractRepository contractRepository;

    public List<ContractModel> getAll()
    {
        return contractRepository.findAll();
    }

    public ContractModel getOne(int id)
    {
        return contractRepository.getOne(id);
    }

    public void save(ContractModel contractModel)
    {
        contractRepository.save(contractModel);
    }

    public void delete(int id)
    {
        contractRepository.deleteById(id);
    }

    public ContractType[] getContractTypes()
    {
        ContractType[] contractTypes = ContractType.values();

        return contractTypes;
    }

    public List<ContractModel> findAllByCustomerId(int id)
    {
        List<ContractModel> contracts = contractRepository.findAllByCustomerIdEquals(id);

        return contracts;
    }
}
