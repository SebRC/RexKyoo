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
        return privateAssignmentRepository.findAll();
    }

    public PrivateAssignmentModel getOne(int id)
    {
        return privateAssignmentRepository.getOne(id);
    }

    public void save(PrivateAssignmentModel privateAssignmentModel)
    {
        privateAssignmentRepository.save(privateAssignmentModel);
    }

    public void delete(int id)
    {
        privateAssignmentRepository.deleteById(id);
    }
}
