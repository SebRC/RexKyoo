package project.rexkyoo.Expenses.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Contract.Model.ContractModel;
import project.rexkyoo.Expenses.Models.ExpenseModel;
import project.rexkyoo.Expenses.Repositories.ExpensesRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExpensesService
{
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

    public void assignFirstWageExpense(ExpenseModel expense, ContractModel contract)
    {
        double hourlyWage = contract.getHourlyWage();
        double workHoursPerMonth = contract.getWorkHoursPerMonth();
        String expenseDate = contract.getStartDate();

        double ambassadorMonthlyWage =  hourlyWage * workHoursPerMonth;

        String expenseName = "Månedsløn";

        expense.setPrice(ambassadorMonthlyWage);
        expense.setName(expenseName);
        expense.setDate(expenseDate);

        Set<ExpenseModel> expenses = new HashSet<>();

        contract.setExpenses(expenses);

        contract.getExpenses().add(expense);

        expense.setContract(contract);
    }
}
