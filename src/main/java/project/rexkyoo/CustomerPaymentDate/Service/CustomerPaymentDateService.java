package project.rexkyoo.CustomerPaymentDate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Repository.CustomerPaymentDateRepository;

import java.util.List;

@Service
public class CustomerPaymentDateService
{
    @Autowired
    private CustomerPaymentDateRepository customerPaymentDateRepository;

    public List<CustomerPaymentDateModel> getAll()
    {
        return customerPaymentDateRepository.findAll();
    }

    public CustomerPaymentDateModel getOne(int id)
    {
        return customerPaymentDateRepository.getOne(id);
    }

    public void save(CustomerPaymentDateModel customerPaymentDateModel)
    {
        customerPaymentDateRepository.save(customerPaymentDateModel);
    }

    public void delete(int id)
    {
        customerPaymentDateRepository.deleteById(id);
    }
}
