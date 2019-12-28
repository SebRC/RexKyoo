package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Ambassador.AmbassadorService;
import project.rexkyoo.CleaningInspector.CleaningInspectorModel;
import project.rexkyoo.CleaningInspector.CleaningInspectorService;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Customer.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DashboardController
{

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AmbassadorService ambassadorService;

    @Autowired
    private CleaningInspectorService cleaningInspectorService;

    @GetMapping("/home")
    public String home(Model model)
    {
        int amountOfPrivateCustomers = customerService.getAllPrivateCustomers().size();
        int amountOfBusinessCustomers = customerService.getAllBusinessCustomers().size();

        model.addAttribute("amountOfPrivateCustomers", amountOfPrivateCustomers);
        model.addAttribute("amountOfBusinessCustomers", amountOfBusinessCustomers);

        return "dashboard/home";
    }

    @GetMapping("/economy")
    public String economy(Model model)
    {
        List<CustomerModel> customers = customerService.getAll();
        List<AmbassadorModel> ambassadors = ambassadorService.getAll();
        List<CleaningInspectorModel> cleaningInspectors = cleaningInspectorService.getAll();
        List<CustomerModel> assignments = customerService.getAll();

        model.addAttribute("customers", customers);
        model.addAttribute("ambassadors", ambassadors);
        model.addAttribute("cleaningInspectors", cleaningInspectors);
        model.addAttribute("assignments", assignments);


        return "dashboard/economy";
    }

    @GetMapping("/login")
    public String login()
    {
        return "dashboard/login";
    }

    @GetMapping("/denied")
    public String denied()
    {
        return "dashboard/denied";
    }
}
