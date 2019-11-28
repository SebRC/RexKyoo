package project.rexkyoo.Customer.Business.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Customer.Business.Model.BusinessCustomerModel;
import project.rexkyoo.Customer.Business.Repository.BusinessCustomerRepository;

import java.util.List;

@Service
public class BusinessCustomerService
{
    @Autowired
    private BusinessCustomerRepository businessCustomerRepository;

    public List<BusinessCustomerModel> getAll()
    {
        return businessCustomerRepository.findAll();
    }

    public BusinessCustomerModel getOne(int id)
    {
        return businessCustomerRepository.getOne(id);
    }

    public void save(BusinessCustomerModel businessCustomerModel)
    {
        businessCustomerRepository.save(businessCustomerModel);
    }

    public void delete(int id)
    {
        businessCustomerRepository.deleteById(id);
    }
}
