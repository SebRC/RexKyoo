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
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;

@Controller
@RequestMapping("/dashboard")
public class AmbassadorController
{
    @Autowired
    private AmbassadorService ambassadorService;

    //View
    @GetMapping("/ambassadorOverview")
    public String ambassadorOverview()
    {
        return "dashboard/ambassador_overview";
    }

    //Create
    @GetMapping("/ambassador")
    public String createCustomer(Model model)
    {
        model.addAttribute("ambassador", new AmbassadorModel());

        return "dashboard/create_ambassador";
    }

    @PostMapping("/ambassador")
    public String createCustomer(@ModelAttribute AmbassadorModel ambassador, @ModelAttribute CustomerPaymentDateModel customerPaymentDate)
    {
        ambassadorService.save(ambassador);

        //  should later redirect to created ambassador
        return "redirect:/dashboard/home";
    }

    //View with ID
    @GetMapping("/ambassadorID")
    public String ambassadorDetails()
    {
        return "dashboard/ambassador_details";
    }
}
