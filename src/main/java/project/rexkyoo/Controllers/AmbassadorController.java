package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Ambassador.Services.AmbassadorService;

@Controller
@RequestMapping("/admin")
public class AmbassadorController
{
    @Autowired
    private AmbassadorService ambassadorService;


    @GetMapping("/ambassadors")
    public String ambassadorOverview()
    {
        return "dashboard/ambassador_overview";
    }

    @GetMapping("/ambassador")
    public String createAmbassador(Model model)
    {
        model.addAttribute("ambassador", new AmbassadorModel());

        return "dashboard/create_ambassador";
    }

    @PostMapping("/ambassador")
    public String createAmbassador(@ModelAttribute AmbassadorModel ambassador)
    {
        ambassadorService.save(ambassador);

        //  should later redirect to created ambassador
        return "redirect:/admin/home";
    }


    @GetMapping("/ambassadorID")
    public String ambassadorDetails()
    {
        return "dashboard/ambassador_details";
    }
}
