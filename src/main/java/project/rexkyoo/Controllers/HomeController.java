package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Ambassador.AmbassadorService;
import project.rexkyoo.Contract.ContractService;
import project.rexkyoo.Economy.EconomyModel;
import project.rexkyoo.CleaningInspector.CleaningInspectorModel;
import project.rexkyoo.CleaningInspector.CleaningInspectorService;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Customer.CustomerService;
import project.rexkyoo.Economy.EconomyService;
import project.rexkyoo.Economy.MonthsIncomeModel;
import project.rexkyoo.Economy.TypePercentagesModel;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class HomeController
{

    @Autowired
    private CustomerService customerService;

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
}
