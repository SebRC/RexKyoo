package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Ambassador.AmbassadorService;
import project.rexkyoo.Economy.EconomyService;

import java.util.List;

// SRC - TA

@Controller
@RequestMapping("/admin")
public class AmbassadorController
{
    @Autowired
    private AmbassadorService ambassadorService;

    @Autowired
    private EconomyService economyService;

    @GetMapping("/ambassadors")
    public String ambassadorOverview(Model model)
    {
        List<AmbassadorModel> ambassadors = ambassadorService.getAll();

        economyService.assignAllAmbassadorsMonthlyWages(ambassadors);

        model.addAttribute("ambassadors", ambassadors);

        return "dashboard/ambassador/ambassador_overview";
    }

    @GetMapping("/ambassadors/{id}")
    public String ambassadorDetails(@PathVariable("id") int id, Model model)
    {
        AmbassadorModel ambassador = ambassadorService.getOne(id);

        economyService.assignAmbassadorMonthlyWage(ambassador);

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

        int id = ambassador.getId();

        return "redirect:/admin/ambassadors/" + id;
    }

    @PostMapping("/ambassador/{id}")
    public String deleteAmbassador(@PathVariable("id") int id)
    {
        ambassadorService.delete(id);

        return "redirect:/admin/home";
    }


    @PostMapping("/ambassador-edit")
    public String editAmbassador(@ModelAttribute AmbassadorModel ambassador)
    {
        ambassadorService.save(ambassador);

        int id = ambassador.getId();

        return "redirect:/admin/ambassadors/" + id;
    }
}
