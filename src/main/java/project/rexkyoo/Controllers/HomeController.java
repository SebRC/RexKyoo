package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Contract.ContractModel;
import project.rexkyoo.Contract.ContractService;
import project.rexkyoo.Economy.EconomyModel;
import project.rexkyoo.Customer.CustomerService;
import project.rexkyoo.Economy.EconomyService;
import project.rexkyoo.Economy.MonthsIncomeModel;

import java.util.List;

// SRC, JV, MG, TA

@Controller
@RequestMapping("/admin")
public class HomeController
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private EconomyService economyService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/home")
    public String home(Model model)
    {
        // SRC

        int amountOfPrivateCustomers = customerService.getAllPrivateCustomers().size();
        int amountOfBusinessCustomers = customerService.getAllBusinessCustomers().size();

        EconomyModel privateCustomersEconomy = economyService.getEconomyBasedOnCustomerType("private");
        EconomyModel businessCustomersEconomy = economyService.getEconomyBasedOnCustomerType("business");

        List<ContractModel> contracts = contractService.getAll();

        economyService.assignMonthsToContracts(contracts);

        MonthsIncomeModel monthsIncome = economyService.getMonthPayments(contractService.getAll());

        model.addAttribute("amountOfPrivateCustomers", amountOfPrivateCustomers);
        model.addAttribute("amountOfBusinessCustomers", amountOfBusinessCustomers);

        model.addAttribute("privateCustomersEconomy", privateCustomersEconomy);
        model.addAttribute("businessCustomersEconomy", businessCustomersEconomy);

        model.addAttribute("monthsIncome", monthsIncome);

        return "dashboard/home";
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
