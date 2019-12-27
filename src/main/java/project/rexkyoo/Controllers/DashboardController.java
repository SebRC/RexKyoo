package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Ambassador.Services.AmbassadorService;
import project.rexkyoo.Economy.EconomyModel;
import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;
import project.rexkyoo.CleaningInspector.Services.CleaningInspectorService;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Service.CustomerService;
import project.rexkyoo.Economy.EconomyService;

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

    @Autowired
    private EconomyService economyService;

    @GetMapping("/home")
    public String home(Model model)
    {
        int amountOfPrivateCustomers = customerService.getAllPrivateCustomers().size();
        int amountOfBusinessCustomers = customerService.getAllBusinessCustomers().size();

        EconomyModel privateCustomersEconomy = economyService.getEconomyBasedOnCustomerType("private");
        EconomyModel businessCustomersEconomy = economyService.getEconomyBasedOnCustomerType("business");

        model.addAttribute("amountOfPrivateCustomers", amountOfPrivateCustomers);
        model.addAttribute("amountOfBusinessCustomers", amountOfBusinessCustomers);

        model.addAttribute("privateCustomersEconomy", privateCustomersEconomy);
        model.addAttribute("businessCustomersEconomy", businessCustomersEconomy);

        return "dashboard/home";
    }

    @GetMapping("/economy")
    public String economy(Model model)
    {
        List<CustomerModel> customers = customerService.getAll();
        List<AmbassadorModel> ambassadors = ambassadorService.getAll();
        List<CleaningInspectorModel> cleaningInspectors = cleaningInspectorService.getAll();
        List<CustomerModel> assignments = customerService.getAll();

        economyService.assignCustomersPercentageOfIncome(customers);

        EconomyModel entireCompanyEconomy = economyService.getEconomyForEntireCompany();

        model.addAttribute("customers", customers);
        model.addAttribute("ambassadors", ambassadors);
        model.addAttribute("cleaningInspectors", cleaningInspectors);
        model.addAttribute("assignments", assignments);

        model.addAttribute("entireCompanyEconomy", entireCompanyEconomy);


        return "dashboard/economy";
    }
}
