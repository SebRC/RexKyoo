package project.rexkyoo.CleaningInspector.Services;

import org.springframework.beans.factory.annotation.Autowired;
import project.rexkyoo.CleaningInspector.Repositories.CleaningInspectorRepository;
import project.rexkyoo.Customer.Models.CustomerModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class CleaningInspectorService {

    @Autowired
    private CleaningInspectorRepository cleaningInspectorRepository;

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
