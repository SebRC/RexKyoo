package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Ambassador.AmbassadorService;
import project.rexkyoo.Contract.ContractType;
import project.rexkyoo.Contract.ContractModel;
import project.rexkyoo.Contract.ContractService;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Customer.CustomerService;
import project.rexkyoo.CustomerPaymentDate.CustomerPaymentDateModel;
import project.rexkyoo.Economy.MonthsIncomeModel;
import project.rexkyoo.Expenses.ExpenseModel;
import project.rexkyoo.Expenses.ExpensesService;

import java.util.List;
import java.util.Set;

// SRC, JV

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
        // SRC

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
        // SRC

        ExpenseModel expense = new ExpenseModel();

        expensesService.assignFirstWageExpense(expense, contract);

        contractService.save(contract);

        expensesService.save(expense);

        return "redirect:/admin/home";
    }

    @GetMapping("/contract/{id}")
    public String contractDetails(@PathVariable("id") int id, Model model)
    {
        //JV

        ContractModel contract = contractService.getOne(id);
        ContractType[] contractTypes = contractService.getContractTypes();
        List<AmbassadorModel> ambassadors = ambassadorService.getAll();

        model.addAttribute("contract", contract);
        model.addAttribute("contractTypes", contractTypes);
        model.addAttribute("ambassadors", ambassadors);

        return "dashboard/contract/contract_details";
    }

    @PostMapping("/contract-edit")
    public String editContract(@ModelAttribute ContractModel contract)
    {
        //JV

        contractService.save(contract);

        int id = contract.getId();

        return "redirect:/admin/contract/" + id;
    }


}
