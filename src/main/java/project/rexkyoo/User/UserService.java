package project.rexkyoo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
