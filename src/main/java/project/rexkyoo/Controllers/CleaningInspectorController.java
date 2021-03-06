package project.rexkyoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.rexkyoo.CleaningInspector.CleaningInspectorModel;
import project.rexkyoo.CleaningInspector.CleaningInspectorService;

import java.util.List;

// SRC, JV, TA, MG

@Controller
@RequestMapping("/admin")
public class CleaningInspectorController
{
    @Autowired
    private CleaningInspectorService cleaningInspectorService;

    @GetMapping("/cleaning-inspectors")
    public String cleaningInspectorOverview(Model model)
    {
        List<CleaningInspectorModel> cleaningInspectors = cleaningInspectorService.getAll();

        model.addAttribute("cleaningInspectors", cleaningInspectors);

        return "dashboard/cleaningInspector/cleaning_inspector_overview";
    }

    @GetMapping("/cleaning-inspectors/{id}")
    public String cleaningInspectorDetails(@PathVariable("id") int id, Model model)
    {
        CleaningInspectorModel cleaningInspector = cleaningInspectorService.getOne(id);

        model.addAttribute("cleaningInspector", cleaningInspector);

        return "dashboard/cleaningInspector/cleaning_inspector_details";
    }

    @GetMapping("/cleaning-inspector")
    public String createCleaningInspector(Model model)
    {
        model.addAttribute("cleaningInspector", new CleaningInspectorModel());

        return "dashboard/cleaningInspector/create_cleaning_inspector";
    }

    @PostMapping("/cleaning-inspector")
    public String createCleaningInspector(@ModelAttribute CleaningInspectorModel cleaningInspector)
    {
        cleaningInspectorService.save(cleaningInspector);

        int id = cleaningInspector.getId();

        return "redirect:/admin/cleaning-inspectors/" + id;
    }

    @PostMapping("/cleaning-inspector/{id}")
    public String deleteCleaningInspector(@PathVariable("id") int id)
    {
        cleaningInspectorService.delete(id);

        return "redirect:/admin/home";
    }

    @PostMapping("/cleaning-inspector-edit")
    public String editCleaningInspector(@ModelAttribute CleaningInspectorModel cleaningInspector)
    {
        cleaningInspectorService.save(cleaningInspector);

        int id = cleaningInspector.getId();

        return "redirect:/admin/cleaning-inspectors/" + id;
    }
}

