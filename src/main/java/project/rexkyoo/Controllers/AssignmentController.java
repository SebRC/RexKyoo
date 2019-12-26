package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.Assignment.Model.AssignmentModel;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AssignmentController
{
    @Autowired
    CustomerService customerService;

    @GetMapping("/assignment")
    public String createCustomer(Model model)
    {
        AssignmentModel assignment = new AssignmentModel();
        List<CustomerModel> customers =  customerService.getAll();
        int connectedCustomerId = 0;

        model.addAttribute("assignment", assignment);
        model.addAttribute("customers", customers);
        model.addAttribute("customerId", connectedCustomerId);

        return "dashboard/assignment/create_assignment";
    }
}
