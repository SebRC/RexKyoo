package project.rexkyoo.Assignment.Private.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Assignment.Private.Model.PrivateAssignmentModel;
import project.rexkyoo.Assignment.Private.Repository.PrivateAssignmentRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class PrivateAssignmentService {
    @Autowired
    private PrivateAssignmentRepository privateAssignmentRepository;

    public List<PrivateAssignmentModel> getAll()
    {
        throw new NotImplementedException();
    }

    public PrivateAssignmentModel getOne(String id)
    {
        throw new NotImplementedException();
    }

    public void save(PrivateAssignmentModel customerModel)
    {
        throw new NotImplementedException();
    }

    public void delete(String id)
    {
        throw new NotImplementedException();
    }
}
