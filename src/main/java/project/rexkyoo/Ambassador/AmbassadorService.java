package project.rexkyoo.Ambassador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
