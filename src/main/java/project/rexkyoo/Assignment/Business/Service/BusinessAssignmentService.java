package project.rexkyoo.Assignment.Business.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Assignment.Business.Repository.BusinessAssignmentRepository;
import project.rexkyoo.Assignment.Business.Model.BusinessAssignmentModel;


import java.util.List;

@Service
public class BusinessAssignmentService
{
    @Autowired
    private BusinessAssignmentRepository businessAssignmentRepository;

    public List<BusinessAssignmentModel> getAll()
    {
        return businessAssignmentRepository.findAll();
    }

    public BusinessAssignmentModel getOne(int id)
    {
        return businessAssignmentRepository.getOne(id);
    }

    public void save(BusinessAssignmentModel businessAssignmentModel)
    {
        businessAssignmentRepository.save(businessAssignmentModel);
    }

    public void delete(int id)
    {
        businessAssignmentRepository.deleteById(id);
    }
}
