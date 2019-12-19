package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Ambassador.Services.AmbassadorService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AmbassadorController
{
    @Autowired
    private AmbassadorService ambassadorService;

    @GetMapping("/ambassadors")
    public String ambassadorOverview(Model model)
    {
        List<AmbassadorModel> ambassadors = ambassadorService.getAll();

        model.addAttribute("ambassadors", ambassadors);

        return "dashboard/ambassador/ambassador_overview";
    }

    @GetMapping("/ambassadors/{id}")
    public String ambassadorDetails(@PathVariable("id") int id, Model model)
    {
        AmbassadorModel ambassador = ambassadorService.getOne(id);

        model.addAttribute("ambassador", ambassador);

        return "dashboard/ambassador/ambassador_details";
    }

    @GetMapping("/ambassador")
    public String createAmbassador(Model model)
    {
        model.addAttribute("ambassador", new AmbassadorModel());

        return "dashboard/ambassador/create_ambassador";
    }

    @PostMapping("/ambassador")
    public String createAmbassador(@ModelAttribute AmbassadorModel ambassador)
    {
        ambassadorService.save(ambassador);

        AmbassadorModel newAmbassador = ambassadorService.getNewlyCreated();

        int id = newAmbassador.getId();

        return "redirect:/admin/ambassadors/" + id;
    }

}
