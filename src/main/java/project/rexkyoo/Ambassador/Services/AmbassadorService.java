package project.rexkyoo.Ambassador.Services;

import org.springframework.beans.factory.annotation.Autowired;
import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Ambassador.Repositories.AmbassadorRepository;

import java.util.List;

public class AmbassadorService {

    @Autowired
    private AmbassadorRepository ambassadorRepository;

    public List<AmbassadorModel> getAll()
    {
        return ambassadorRepository.findAll();
    }

    public AmbassadorModel getOne(int id)
    {
        return ambassadorRepository.getOne(id);
    }

    public void save(AmbassadorModel cleaningInspectorModel)
    {
        ambassadorRepository.save(cleaningInspectorModel);
    }

    public void delete(int id)
    {
        ambassadorRepository.deleteById(id);
    }
}
