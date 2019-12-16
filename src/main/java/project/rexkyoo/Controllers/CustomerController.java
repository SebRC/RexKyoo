package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Service.CustomerService;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.CustomerPaymentDate.Service.CustomerPaymentDateService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerPaymentDateService customerPaymentDateService;

    @GetMapping("/business-customers")
    public String businessCustomerOverview()
    {
        return "dashboard/customer/business_customer_overview";
    }

    @GetMapping("/business-customersID")
    public String businessCustomerDetails()
    {
        return "dashboard/customer/business_customer_details";
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

    @GetMapping("/private-customers")
    public String privateCustomerOverview(Model model)
    {
        List<CustomerModel> privateCustomers = customerService.getAllPrivateCustomers();

        model.addAttribute("privateCustomers", privateCustomers);

        return "dashboard/customer/private_customer_overview";
    }

    @GetMapping("/private-customersID")
    public String privateCustomerDetails()
    {
        return "dashboard/customer/private_customer_details";
    }
}
