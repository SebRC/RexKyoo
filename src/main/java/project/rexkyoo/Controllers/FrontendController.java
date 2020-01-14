package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.User.UserModel;
import project.rexkyoo.User.UserService;

// JV, MG

@Controller
@RequestMapping("/dk")
public class FrontendController
{
    @GetMapping("/forside")
    public String forside()
    {
        return "frontend/index";
    }

    @GetMapping("/ansatte")
    public String ansatte()
    {
        return "frontend/ansatte";
    }

    @GetMapping("/familiepakke")
    public String familiepakke()
    {
        return "frontend/familiepakke";
    }

    @GetMapping("/fitness")
    public String fitness()
    {
        return "frontend/fitness";
    }

    @GetMapping("/forretning")
    public String forretning()
    {
        return "frontend/forretning";
    }

    @GetMapping("/housekeeper")
    public String housekeeper()
    {
        return "frontend/housekeeper";
    }

    @GetMapping("/institution")
    public String institution()
    {
        return "frontend/institution";
    }

    @GetMapping("/jobs")
    public String jobs()
    {
        return "frontend/jobs";
    }

    @GetMapping("/klinik")
    public String klinik()
    {
        return "frontend/klinik";
    }

    @GetMapping("/kontor")
    public String kontor()
    {
        return "frontend/kontor";
    }

    @GetMapping("/kvalitet")
    public String kvalitet()
    {
        return "frontend/kvalitet";
    }

    @GetMapping("/minside")
    public String minside()
    {
        return "frontend/minside";
    }

    @GetMapping("/om-os")
    public String omOS()
    {
        return "frontend/omos";
    }

    @GetMapping("/privat")
    public String privat()
    {
        return "frontend/privat";
    }

    @GetMapping("/skræddersy")
    public String skreaddersy()
    {
        return "frontend/skræddersy";
    }


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("/createuser")
    public String createuser()
    {
        UserModel user = new UserModel("admin", "1234", 1);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userService.save(user);

        return "frontend/index";
    }
}
