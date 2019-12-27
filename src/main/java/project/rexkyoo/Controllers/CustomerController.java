package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Contract.ContractModel;
import project.rexkyoo.Contract.ContractService;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Service.CustomerService;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Service.CustomerPaymentDateService;
import project.rexkyoo.Economy.EconomyService;
import project.rexkyoo.Economy.MonthsIncomeModel;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerPaymentDateService customerPaymentDateService;

    @Autowired
    private EconomyService economyService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/business-customers")
    public String businessCustomerOverview(Model model)
    {
        List<CustomerModel> businessCustomers = customerService.getAllBusinessCustomers();

        economyService.assignEconomyForCustomers(businessCustomers);

        model.addAttribute("businessCustomers", businessCustomers);

        return "dashboard/customer/business_customer_overview";
    }

    @GetMapping("/private-customers")
    public String privateCustomerOverview(Model model)
    {
        List<CustomerModel> privateCustomers = customerService.getAllPrivateCustomers();

        economyService.assignEconomyForCustomers(privateCustomers);

        model.addAttribute("privateCustomers", privateCustomers);

        return "dashboard/customer/private_customer_overview";
    }

    @GetMapping("/business-customers/{id}")
    public String businessCustomerDetails(@PathVariable("id") int id, Model model)
    {
        CustomerModel businessCustomer = customerService.getOne(id);

        economyService.assignEconomyForSingleCustomer(businessCustomer);

        Set<CustomerPaymentDateModel> paymentDates = businessCustomer.getCustomerPaymentDates();

        List<ContractModel> contracts = contractService.findAllByCustomerId(id);

        economyService.assignMonthsToContracts(contracts);

        MonthsIncomeModel monthsIncome = economyService.getMonthPayments(contracts);

        model.addAttribute("businessCustomer", businessCustomer);
        model.addAttribute("businessCustomerPaymentDates", paymentDates);

        model.addAttribute("monthsIncome", monthsIncome);

        return "dashboard/customer/business_customer_details";
    }

    @GetMapping("/private-customers/{id}")
    public String privateCustomerDetails(@PathVariable("id") int id, Model model)
    {
        CustomerModel privateCustomer = customerService.getOne(id);

        economyService.assignEconomyForSingleCustomer(privateCustomer);

        Set<CustomerPaymentDateModel> paymentDates = privateCustomer.getCustomerPaymentDates();

        List<ContractModel> contracts = contractService.findAllByCustomerId(id);

        economyService.assignMonthsToContracts(contracts);

        MonthsIncomeModel monthsIncome = economyService.getMonthPayments(contracts);

        model.addAttribute("privateCustomer", privateCustomer);
        model.addAttribute("privateCustomerPaymentDates", paymentDates);

        model.addAttribute("customerPaymentDate", new CustomerPaymentDateModel());

        model.addAttribute("monthsIncome", monthsIncome);

        return "dashboard/customer/private_customer_details";
    }

    @GetMapping("/customer")
    public String createCustomer(Model model)
    {
        model.addAttribute("customer", new CustomerModel());
        model.addAttribute("customerPaymentDate", new CustomerPaymentDateModel());

        return "dashboard/customer/create_customer";
    }

    @PostMapping("/customer")
    public String createCustomer(@ModelAttribute CustomerModel customer, @ModelAttribute CustomerPaymentDateModel customerPaymentDate)
    {
        customerService.save(customer);

        customerPaymentDate.setCustomer(customer);

        customerPaymentDateService.save(customerPaymentDate);

        int id = customer.getId();

        String customerType = customer.getType();

        return "redirect:/admin/" + customerType + "-customers/" + id;
    }

    @PostMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable("id") int id)
    {
        customerService.delete(id);

        return "redirect:/admin/home";
    }

    @PostMapping("/customer-edit/{id}")
    public String editCustomer(@PathVariable("id") int id, @ModelAttribute CustomerModel customer, @ModelAttribute CustomerPaymentDateModel customerPaymentDate)
    {
        customerService.delete(customer.getId());
        customer.setId(id);
        customerService.save(customer);

        return "redirect:/admin/" + customer.getType() + "-customers/" + id;
    }
}
