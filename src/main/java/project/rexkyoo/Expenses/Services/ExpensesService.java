package project.rexkyoo.Expenses.Services;

import org.springframework.beans.factory.annotation.Autowired;
import project.rexkyoo.Expenses.Models.ExpenseModel;
import project.rexkyoo.Expenses.Repositories.ExpensesRepository;

import java.util.List;

public class ExpensesService {

    @Autowired
    private ExpensesRepository cleaningInspectorRepository;

    public List<ExpenseModel> getAll()
    {
        return cleaningInspectorRepository.findAll();
    }

    public ExpenseModel getOne(int id)
    {
        return cleaningInspectorRepository.getOne(id);
    }

    public void save(ExpenseModel expenseModel)
    {
        cleaningInspectorRepository.save(expenseModel);
    }

    public void delete(int id)
    {
        cleaningInspectorRepository.deleteById(id);
    }
}
