package project.rexkyoo.Customer.Business.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Customer.Business.Repository.BusinessCustomerRepository;
import project.rexkyoo.Customer.CustomerModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class BusinessCustomerService
{
    @Autowired
    private BusinessCustomerRepository businessCustomerRepository;

    public List<CustomerModel> getAll()
    {
        throw new NotImplementedException();
    }

    public CustomerModel getOne(String id)
    {
        throw new NotImplementedException();
    }

    public void save(CustomerModel customerModel)
    {
        throw new NotImplementedException();
    }

    public void delete(String id)
    {
        throw new NotImplementedException();
    }
}
