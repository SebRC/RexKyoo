package project.rexkyoo.User.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.User.Models.UserModel;
import project.rexkyoo.User.Repositories.UserRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public UserModel getOne(int id)
    {
        return userRepository.getOne(id);
    }

}
