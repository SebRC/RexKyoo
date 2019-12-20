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
        List<CleaningInspectorModel> cleaningInspectors = cleaningInspectorRepository.findAll();

        return cleaningInspectors;
    }

    public CleaningInspectorModel getOne(int id)
    {
        CleaningInspectorModel cleaningInspector = cleaningInspectorRepository.getOne(id);

        return cleaningInspector;
    }

    public void save(CleaningInspectorModel cleaningInspector)
    {
        cleaningInspectorRepository.save(cleaningInspector);
    }

    public void delete(int id)
    {
        cleaningInspectorRepository.deleteById(id);
    }
}
