package project.rexkyoo.Economy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Contract.Model.ContractModel;
import project.rexkyoo.Contract.Repository.ContractRepository;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Expenses.Models.ExpenseModel;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

@Service
public class EconomyService
{
    @Autowired
    private ContractRepository contractRepository;

    public EconomyModel getEconomyBasedOnCustomerType(String type)
    {
        double customersIncome;
        double customersExpenses;
        double customersProfit;

        List<ContractModel> assignments = contractRepository.findAllByCustomerTypeEquals(type);

        customersIncome = assignIncome(assignments);
        customersExpenses = assignExpenses(assignments);
        customersProfit = customersIncome - customersExpenses;

        EconomyModel economy = new EconomyModel(customersIncome, customersExpenses, customersProfit);

        return economy;
    }

    private double assignIncome(List<ContractModel> assignments)
    {
        double privateCustomersIncome = 0;

        for (ContractModel assignment : assignments)
        {
            privateCustomersIncome += assignment.getIncome();
        }

        return privateCustomersIncome;
    }

    private double assignExpenses(List<ContractModel> assignments)
    {
        double privateCustomersExpenses = 0;

        for (ContractModel assignment : assignments)
        {
            Set<ExpenseModel> expenses = assignment.getExpenses();

            for (ExpenseModel expense : expenses)
            {
                privateCustomersExpenses += expense.getPrice();
            }
        }

        return privateCustomersExpenses;
    }

    public EconomyModel getEconomyForEntireCompany()
    {
        double customersIncome;
        double customersExpenses;
        double customersProfit;

        List<ContractModel> assignments = contractRepository.findAll();

        customersIncome = assignIncome(assignments);
        customersExpenses = assignExpenses(assignments);
        customersProfit = customersIncome - customersExpenses;

        EconomyModel economy = new EconomyModel(customersIncome, customersExpenses, customersProfit);

        return economy;
    }

    public void assignCustomersPercentageOfIncome(List<CustomerModel> customers)
    {
        for (CustomerModel customer : customers)
        {
            assignPercentage(customer);
        }
    }

    private void assignPercentage(CustomerModel customer)
    {
        double totalCompanyIncome = getEconomyForEntireCompany().getIncome();

        Set<ContractModel> assignments = customer.getContracts();
        double totalCustomerIncome = 0;

        for (ContractModel assignment : assignments)
        {
            totalCustomerIncome += assignment.getIncome();
        }

        double percentage = (totalCustomerIncome / totalCompanyIncome) * 100;

        DecimalFormat twoDecimalFormat = new DecimalFormat("#.##");
        percentage = Double.valueOf(twoDecimalFormat.format(percentage));

        customer.setPercentageOfCompanyIncome(percentage);
    }
}
