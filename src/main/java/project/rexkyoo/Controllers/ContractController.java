package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Ambassador.AmbassadorService;
import project.rexkyoo.Contract.ContractType;
import project.rexkyoo.Contract.ContractModel;
import project.rexkyoo.Contract.ContractService;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Customer.CustomerService;
import project.rexkyoo.Expenses.ExpenseModel;
import project.rexkyoo.Expenses.ExpensesService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ContractController
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AmbassadorService ambassadorService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private ExpensesService expensesService;

    @GetMapping("/contract")
    public String createContract(Model model)
    {
        ContractModel contract = new ContractModel();
        ContractType[] contractTypes = contractService.getContractTypes();

        List<CustomerModel> customers =  customerService.getAll();
        List<AmbassadorModel> ambassadors = ambassadorService.getAll();

        model.addAttribute("contract", contract);
        model.addAttribute("contractTypes", contractTypes);

        model.addAttribute("customers", customers);
        model.addAttribute("ambassadors", ambassadors);

        return "dashboard/contract/create_contract";
    }

    @PostMapping("/contract")
    public String createContract(@ModelAttribute ContractModel contract)
    {
        ExpenseModel expense = new ExpenseModel();

        expensesService.assignFirstWageExpense(expense, contract);

        contractService.save(contract);

        expensesService.save(expense);

        return "redirect:/admin/home";
    }
}
