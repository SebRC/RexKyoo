package project.rexkyoo.Assignment.Business.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Assignment.Business.Repository.BusinessAssignmentRepository;
import project.rexkyoo.Assignment.Private.Model.BusinessAssignmentModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class BusinessAssignmentService
{
    @Autowired
    private BusinessAssignmentRepository businessAssignmentRepository;

    public List<BusinessAssignmentModel> getAll()
    {
        throw new NotImplementedException();
    }

    public BusinessAssignmentModel getOne(String id)
    {
        throw new NotImplementedException();
    }

    public void save(BusinessAssignmentModel customerModel)
    {
        throw new NotImplementedException();
    }

    public void delete(String id)
    {
        throw new NotImplementedException();
    }
}
