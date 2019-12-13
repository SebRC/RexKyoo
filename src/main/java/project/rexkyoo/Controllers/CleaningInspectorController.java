package project.rexkyoo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CleaningInspectorController
{
    @GetMapping("/cleaning-inspectors")
    public String cleaningInspectorOverview()
    {
        return "dashboard/cleaningInspector/cleaning_inspector_overview";
    }
}
