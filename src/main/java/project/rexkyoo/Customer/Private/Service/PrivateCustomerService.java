package project.rexkyoo.Customer.Private.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Customer.Private.Model.PrivateCustomerModel;
import project.rexkyoo.Customer.Private.Repository.PrivateCustomerRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class PrivateCustomerService
{
    @Autowired
    private PrivateCustomerRepository privateCustomerRepository;

    public List<PrivateCustomerModel> getAll()
    {
        return privateCustomerRepository.findAll();
    }

    public PrivateCustomerModel getOne(int id)
    {
        return privateCustomerRepository.getOne(id);
    }

    public void save(PrivateCustomerModel privateCustomerModel)
    {
        privateCustomerRepository.save(privateCustomerModel);
    }

    public void delete(int id)
    {
        privateCustomerRepository.deleteById(id);
    }
}
