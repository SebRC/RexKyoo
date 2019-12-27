package project.rexkyoo.Assignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Assignment.AssignmentType;
import project.rexkyoo.Assignment.Model.EconomyModel;
import project.rexkyoo.Assignment.Repository.AssignmentRepository;
import project.rexkyoo.Assignment.Model.AssignmentModel;
import project.rexkyoo.Expenses.Models.ExpenseModel;


import java.util.List;
import java.util.Set;

@Service
public class AssignmentService
{
    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<AssignmentModel> getAll()
    {
        return assignmentRepository.findAll();
    }

    public AssignmentModel getOne(int id)
    {
        return assignmentRepository.getOne(id);
    }

    public void save(AssignmentModel assignmentModel)
    {
        assignmentRepository.save(assignmentModel);
    }

    public void delete(int id)
    {
        assignmentRepository.deleteById(id);
    }

    public AssignmentType[] getAssignmentTypes()
    {
        AssignmentType[] assignmentTypes = AssignmentType.values();

        return assignmentTypes;
    }

    public EconomyModel getEconomyBasedOnCustomerType(String type)
    {
        double customersIncome;
        double customersExpenses;
        double customersProfit;

        List<AssignmentModel> assignments = assignmentRepository.findAllByCustomerTypeEquals(type);

        customersIncome = assignIncome(assignments);
        customersExpenses = assignExpenses(assignments);
        customersProfit = customersIncome - customersExpenses;

        EconomyModel economy = new EconomyModel(customersIncome, customersExpenses, customersProfit);

        return economy;
    }

    private double assignIncome(List<AssignmentModel> assignments)
    {
        double privateCustomersIncome = 0;

        for (AssignmentModel assignment : assignments)
        {
            privateCustomersIncome += assignment.getIncome();
        }

        return privateCustomersIncome;
    }

    private double assignExpenses(List<AssignmentModel> assignments)
    {
        double privateCustomersExpenses = 0;

        for (AssignmentModel assignment : assignments)
        {
            Set<ExpenseModel> expenses = assignment.getExpenses();

            for (ExpenseModel expense : expenses)
            {
                privateCustomersExpenses += expense.getPrice();
            }
        }

        return privateCustomersExpenses;
    }

    public EconomyModel getEconoymForEntireCompany()
    {
        double customersIncome;
        double customersExpenses;
        double customersProfit;

        List<AssignmentModel> assignments = assignmentRepository.findAll();

        customersIncome = assignIncome(assignments);
        customersExpenses = assignExpenses(assignments);
        customersProfit = customersIncome - customersExpenses;

        EconomyModel economy = new EconomyModel(customersIncome, customersExpenses, customersProfit);

        return economy;
    }
}
