package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Service.CustomerService;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Service.CustomerPaymentDateService;

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

    @GetMapping("/business-customers")
    public String businessCustomerOverview(Model model)
    {
        List<CustomerModel> businessCustomers = customerService.getAllBusinessCustomers();

        model.addAttribute("businessCustomers", businessCustomers);

        return "dashboard/customer/business_customer_overview";
    }

    @GetMapping("/private-customers")
    public String privateCustomerOverview(Model model)
    {
        List<CustomerModel> privateCustomers = customerService.getAllPrivateCustomers();

        model.addAttribute("privateCustomers", privateCustomers);

        return "dashboard/customer/private_customer_overview";
    }

    @GetMapping("/business-customers/{id}")
    public String businessCustomerDetails(@PathVariable("id") int id, Model model)
    {
        CustomerModel businessCustomer = customerService.getOne(id);

        Set<CustomerPaymentDateModel> paymentDates = businessCustomer.getCustomerPaymentDates();

        model.addAttribute("businessCustomer", businessCustomer);
        model.addAttribute("businessCustomerPaymentDates", paymentDates);

        return "dashboard/customer/business_customer_details";
    }

    @GetMapping("/private-customers/{id}")
    public String privateCustomerDetails(@PathVariable("id") int id, Model model)
    {
        CustomerModel privateCustomer = customerService.getOne(id);

        Set<CustomerPaymentDateModel> paymentDates = privateCustomer.getCustomerPaymentDates();

        model.addAttribute("privateCustomer", privateCustomer);
        model.addAttribute("privateCustomerPaymentDates", paymentDates);

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

        //  TODO: should later redirect to created customer
        return "redirect:/admin/home";
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable("id") int id)
    {
        customerService.delete(id);
        return "redirect:/admin/home";
    }
}
