package project.rexkyoo.CleaningInspector.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;
import project.rexkyoo.CleaningInspector.Repositories.CleaningInspectorRepository;

import java.util.List;

@Service
public class CleaningInspectorService
{
    @Autowired
    private CleaningInspectorRepository cleaningInspectorRepository;

    public List<CleaningInspectorModel> getAll()
    {
        return cleaningInspectorRepository.findAll();
    }

    public CleaningInspectorModel getOne(int id)
    {
        return cleaningInspectorRepository.getOne(id);
    }

    public void save(CleaningInspectorModel cleaningInspectorModel)
    {
        cleaningInspectorRepository.save(cleaningInspectorModel);
    }

    public void delete(int id)
    {
        cleaningInspectorRepository.deleteById(id);
    }
}
