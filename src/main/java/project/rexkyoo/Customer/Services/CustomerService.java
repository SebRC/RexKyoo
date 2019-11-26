package project.rexkyoo.Customer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Customer.Models.CustomerModel;
import project.rexkyoo.Customer.Repositories.CustomerRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

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
