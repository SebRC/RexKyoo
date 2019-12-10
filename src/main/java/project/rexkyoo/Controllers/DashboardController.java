package project.rexkyoo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.Customer.Model.CustomerModel;

@Controller
@RequestMapping("/dashboard")
public class DashboardController
{
    @GetMapping("/home")
    public String home()
    {
        return "dashboard/home";
    }

    @GetMapping("/businessCustomer")
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
        model.addAttribute("customerModel", new CustomerModel());

        return "dashboard/create_customer";
    }
}
