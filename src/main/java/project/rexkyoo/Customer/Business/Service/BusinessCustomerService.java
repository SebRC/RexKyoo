package project.rexkyoo.Customer.Business.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Customer.Business.Model.BusinessCustomerModel;
import project.rexkyoo.Customer.Business.Repository.BusinessCustomerRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class BusinessCustomerService
{
    @Autowired
    private BusinessCustomerRepository businessCustomerRepository;

    public List<BusinessCustomerModel> getAll()
    {
        throw new NotImplementedException();
    }

    public BusinessCustomerModel getOne(String id)
    {
        throw new NotImplementedException();
    }

    public void save(BusinessCustomerModel businessCustomerModel)
    {
        throw new NotImplementedException();
    }

    public void delete(String id)
    {
        throw new NotImplementedException();
    }
}
