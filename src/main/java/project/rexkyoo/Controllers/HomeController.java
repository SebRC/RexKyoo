package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Economy.EconomyModel;
import project.rexkyoo.Customer.CustomerService;
import project.rexkyoo.Economy.EconomyService;

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
