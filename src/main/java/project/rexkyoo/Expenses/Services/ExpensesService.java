package project.rexkyoo.Expenses.Services;

import org.springframework.beans.factory.annotation.Autowired;
import project.rexkyoo.Expenses.Models.ExpensesModel;
import project.rexkyoo.Expenses.Repositories.ExpensesRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class ExpensesService {

    @Autowired
    private ExpensesRepository cleaningInspectorRepository;

    public List<ExpensesModel> getAll()
    {
        throw new NotImplementedException();
    }

    public ExpensesModel getOne(String id)
    {
        throw new NotImplementedException();
    }

    public void save(ExpensesModel customerModel)
    {
        throw new NotImplementedException();
    }

    public void delete(String id)
    {
        throw new NotImplementedException();
    }
}
