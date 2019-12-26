package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Ambassador.Services.AmbassadorService;
import project.rexkyoo.Assignment.Model.AssignmentModel;
import project.rexkyoo.Assignment.Service.AssignmentService;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Customer.Service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AssignmentController
{
    @Autowired
    CustomerService customerService;

    @Autowired
    AmbassadorService ambassadorService;

    @Autowired
    AssignmentService assignmentService;

    @GetMapping("/assignment")
    public String createCustomer(Model model)
    {
        AssignmentModel assignment = new AssignmentModel();
        List<CustomerModel> customers =  customerService.getAll();
        List<AmbassadorModel> ambassadors = ambassadorService.getAll();

        model.addAttribute("assignment", assignment);
        model.addAttribute("customers", customers);
        model.addAttribute("ambassadors", ambassadors);

        return "dashboard/assignment/create_assignment";
    }

    @PostMapping("/assignment")
    public String createCustomer(@ModelAttribute AssignmentModel assignmentModel)
    {
        assignmentService.save(assignmentModel);

        return "redirect:/admin/home";
    }
}
