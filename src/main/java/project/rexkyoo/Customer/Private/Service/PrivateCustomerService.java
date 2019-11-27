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
        throw new NotImplementedException();
    }

    public PrivateCustomerModel getOne(String id)
    {
        throw new NotImplementedException();
    }

    public void save(PrivateCustomerModel privateCustomerModel)
    {
        throw new NotImplementedException();
    }

    public void delete(String id)
    {
        throw new NotImplementedException();
    }
}
