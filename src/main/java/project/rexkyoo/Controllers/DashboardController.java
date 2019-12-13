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
@RequestMapping("/admin")
public class DashboardController
{
    @GetMapping("/home")
    public String home()
    {
        return "dashboard/home";
    }

    @GetMapping("/cleaning-inspectors")
    public String cleaningInspectorOverview()
    {
        return "dashboard/cleaningInspector/cleaning_inspector_overview";
    }
}
