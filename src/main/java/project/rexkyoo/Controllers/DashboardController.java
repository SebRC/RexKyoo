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

@Controller
@RequestMapping("/dashboard")
public class DashboardController
{

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerPaymentDateService customerPaymentDateService;


    @GetMapping("/home")
    public String home()
    {
        return "dashboard/home";
    }

    @GetMapping("/businessCustomers")
    public String businessCustomerOverview()
    {
        return "dashboard/business_customer_overview";
    }

    @GetMapping("/businessCustomerID")
    public String businessCustomerDetails()
    {
        return "dashboard/business_customer_details";
    }

    @GetMapping("/customer")
    public String createCustomer(Model model)
    {
        model.addAttribute("customer", new CustomerModel());
        model.addAttribute("customerPaymentDate", new CustomerPaymentDateModel());

        return "dashboard/create_customer";
    }

    @PostMapping("/customer")
    public String createCustomer(@ModelAttribute CustomerModel customer, @ModelAttribute CustomerPaymentDateModel customerPaymentDate)
    {
        customerService.save(customer);

        customerPaymentDate.setCustomer(customer);

        customerPaymentDateService.save(customerPaymentDate);

        //  TODO: should later redirect to created customer
        return "redirect:/dashboard/home";
    }

    @GetMapping("/privateCustomers")
    public String privateCustomerOverview() { return "dashboard/private_customer_overview";}

    @GetMapping("/privateCustomerID")
    public String privateCustomerDetails()
    {
        return "dashboard/private_customer_details";
    }
}
