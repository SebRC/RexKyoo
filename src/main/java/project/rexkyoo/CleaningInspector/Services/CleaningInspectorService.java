package project.rexkyoo.CleaningInspector.Services;

import org.springframework.beans.factory.annotation.Autowired;
import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;
import project.rexkyoo.CleaningInspector.Repositories.CleaningInspectorRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class CleaningInspectorService {

    @Autowired
    private CleaningInspectorRepository cleaningInspectorRepository;

    public List<CleaningInspectorModel> getAll()
    {
        throw new NotImplementedException();
    }

    public CleaningInspectorModel getOne(String id)
    {
        throw new NotImplementedException();
    }

    public void save(CleaningInspectorModel customerModel)
    {
        throw new NotImplementedException();
    }

    public void delete(String id)
    {
        throw new NotImplementedException();
    }
}
