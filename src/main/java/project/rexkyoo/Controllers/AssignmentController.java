package project.rexkyoo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.rexkyoo.Assignment.Model.AssignmentModel;

@Controller
@RequestMapping("/admin")
public class AssignmentController
{
    @GetMapping("/assignment")
    public String createCustomer(Model model)
    {
        model.addAttribute("assignment", new AssignmentModel());

        return "dashboard/assignment/create_assignment";
    }
}
