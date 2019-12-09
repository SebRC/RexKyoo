package project.rexkyoo.Assignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Assignment.Repository.AssignmentRepository;
import project.rexkyoo.Assignment.Model.AssignmentModel;


import java.util.List;

@Service
public class AssignmentService
{
    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<AssignmentModel> getAll()
    {
        return assignmentRepository.findAll();
    }

    public AssignmentModel getOne(int id)
    {
        return assignmentRepository.getOne(id);
    }

    public void save(AssignmentModel assignmentModel)
    {
        assignmentRepository.save(assignmentModel);
    }

    public void delete(int id)
    {
        assignmentRepository.deleteById(id);
    }
}
