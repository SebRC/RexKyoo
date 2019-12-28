package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Ambassador.AmbassadorService;
import project.rexkyoo.CleaningInspector.CleaningInspectorModel;
import project.rexkyoo.CleaningInspector.CleaningInspectorService;
import project.rexkyoo.Contract.ContractModel;
import project.rexkyoo.Contract.ContractService;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Customer.CustomerService;
import project.rexkyoo.Economy.EconomyModel;
import project.rexkyoo.Economy.EconomyService;
import project.rexkyoo.Economy.MonthsIncomeModel;
import project.rexkyoo.Economy.TypePercentagesModel;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EconomyController
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private EconomyService economyService;

    @Autowired
    private AmbassadorService ambassadorService;

    @Autowired
    private CleaningInspectorService cleaningInspectorService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/economy")
    public String economy(Model model)
    {
        List<CustomerModel> customers = customerService.getAll();
        List<AmbassadorModel> ambassadors = ambassadorService.getAll();
        List<CleaningInspectorModel> cleaningInspectors = cleaningInspectorService.getAll();
        List<CustomerModel> assignments = customerService.getAll();

        economyService.assignCustomersPercentageOfIncome(customers);
        economyService.assignAllAmbassadorsMonthlyWages(ambassadors);

        EconomyModel entireCompanyEconomy = economyService.getEconomyForEntireCompany();
        TypePercentagesModel typePercentages = economyService.calculateTypePercentages();
        double profitPercentage = economyService.calculateProfitPercentage();

        List<ContractModel> contracts = contractService.getAll();

        economyService.assignMonthsToContracts(contracts);

        MonthsIncomeModel monthsIncome = economyService.getMonthPayments(contractService.getAll());

        model.addAttribute("customers", customers);
        model.addAttribute("ambassadors", ambassadors);
        model.addAttribute("cleaningInspectors", cleaningInspectors);
        model.addAttribute("assignments", assignments);

        model.addAttribute("entireCompanyEconomy", entireCompanyEconomy);
        model.addAttribute("typePercentages", typePercentages);
        model.addAttribute("profitPercentage", profitPercentage);
        model.addAttribute("monthsIncome", monthsIncome);

        return "dashboard/economy";
    }
}
