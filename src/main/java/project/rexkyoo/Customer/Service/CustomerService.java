package project.rexkyoo.Customer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerModel> getAllPrivateCustomers()
    {
        String type = "private";

        List<CustomerModel> privateCustomers = customerRepository.findAllByTypeEquals(type);

        for (CustomerModel privateCustomer : privateCustomers)
        {
            privateCustomer.assignDates();
        }

        return privateCustomers;
    }

    public CustomerModel getOne(int id)
    {
        return customerRepository.getOne(id);
    }

    public void save(CustomerModel customerModel)
    {
        customerRepository.save(customerModel);
    }

    public void delete(int id)
    {
        customerRepository.deleteById(id);
    }
}
