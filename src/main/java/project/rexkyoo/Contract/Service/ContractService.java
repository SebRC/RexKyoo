package project.rexkyoo.Contract.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Contract.ContractType;
import project.rexkyoo.Contract.Repository.ContractRepository;
import project.rexkyoo.Contract.Model.ContractModel;


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
}
