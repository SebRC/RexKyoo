package project.rexkyoo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class AmbassadorController
{
    //Ambassador part
    @GetMapping("/ambassador")
    public String ambassadorOverview()
    {
        return "dashboard/ambassador_overview";
    }
}
