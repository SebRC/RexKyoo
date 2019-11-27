package project.rexkyoo.Assignment.Business.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Assignment.Business.Repsitory.BusinessAssignmentRepository;
import project.rexkyoo.Customer.CustomerModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class BusinessAssignmentService
{
    @Autowired
    private BusinessAssignmentRepository businessAssignmentRepository;

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
