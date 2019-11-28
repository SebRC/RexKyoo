package project.rexkyoo.Expenses.Services;

import org.springframework.beans.factory.annotation.Autowired;
import project.rexkyoo.Expenses.Models.ExpensesModel;
import project.rexkyoo.Expenses.Repositories.ExpensesRepository;

import java.util.List;

public class ExpensesService {

    @Autowired
    private ExpensesRepository cleaningInspectorRepository;

    public List<ExpensesModel> getAll()
    {
        return cleaningInspectorRepository.findAll();
    }

    public ExpensesModel getOne(int id)
    {
        return cleaningInspectorRepository.getOne(id);
    }

    public void save(ExpensesModel expensesModel)
    {
        cleaningInspectorRepository.save(expensesModel);
    }

    public void delete(int id)
    {
        cleaningInspectorRepository.deleteById(id);
    }
}
