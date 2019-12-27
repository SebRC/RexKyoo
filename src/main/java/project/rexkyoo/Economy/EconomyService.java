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

        List<ContractModel> contracts = contractRepository.findAllByCustomerTypeEquals(type);

        customersIncome = assignIncome(contracts);
        customersExpenses = assignExpenses(contracts);
        customersProfit = customersIncome - customersExpenses;

        EconomyModel economy = new EconomyModel(customersIncome, customersExpenses, customersProfit);

        return economy;
    }

    private double assignIncome(List<ContractModel> contracts)
    {
        double customersIncome = 0;

        for (ContractModel contract : contracts)
        {
            customersIncome += contract.getIncome();
        }

        return customersIncome;
    }

    private double assignExpenses(List<ContractModel> contracts)
    {
        double customersIncome = 0;

        for (ContractModel contract : contracts)
        {
            Set<ExpenseModel> expenses = contract.getExpenses();

            for (ExpenseModel expense : expenses)
            {
                customersIncome += expense.getPrice();
            }
        }

        return customersIncome;
    }

    public EconomyModel getEconomyForEntireCompany()
    {
        double customersIncome;
        double customersExpenses;
        double customersProfit;

        List<ContractModel> contracts = contractRepository.findAll();

        customersIncome = assignIncome(contracts);
        customersExpenses = assignExpenses(contracts);
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

        Set<ContractModel> contracts = customer.getContracts();
        double totalCustomerIncome = 0;

        for (ContractModel contract : contracts)
        {
            totalCustomerIncome += contract.getIncome();
        }

        double percentage = (totalCustomerIncome / totalCompanyIncome) * 100;

        DecimalFormat twoDecimalFormat = new DecimalFormat("#.##");
        percentage = Double.valueOf(twoDecimalFormat.format(percentage));

        customer.setPercentageOfCompanyIncome(percentage);
    }

    public void assignEconomyForCustomers(List<CustomerModel> customers)
    {
        for (CustomerModel customer : customers)
        {
            assignEconomyForSingleCustomer(customer);
        }
    }

    public void assignEconomyForSingleCustomer(CustomerModel customer)
    {
        double customersIncome;
        double customersExpenses;
        double customersProfit;

        int id = customer.getId();

        List<ContractModel> contracts = contractRepository.findAllByCustomerIdEquals(id);

        customersIncome = assignIncome(contracts);
        customersExpenses = assignExpenses(contracts);
        customersProfit = customersIncome - customersExpenses;

        EconomyModel economy = new EconomyModel(customersIncome, customersExpenses, customersProfit);

        customer.setEconomy(economy);
    }
}
