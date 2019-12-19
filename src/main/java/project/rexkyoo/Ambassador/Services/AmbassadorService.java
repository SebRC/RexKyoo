package project.rexkyoo.Ambassador.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Ambassador.Repositories.AmbassadorRepository;

import java.util.List;

@Service
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

    public void save(AmbassadorModel ambassadorModel)
    {
        ambassadorRepository.save(ambassadorModel);
    }

    public void delete(int id)
    {
        ambassadorRepository.deleteById(id);
    }

    public AmbassadorModel getNewlyCreated()
    {
        List<AmbassadorModel> ambassadors = ambassadorRepository.findAllByOrderByIdDesc();

        AmbassadorModel newAmbassador = ambassadors.get(0);

        return newAmbassador;
    }
}
