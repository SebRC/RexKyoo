package project.rexkyoo.Economy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Contract.ContractType;
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
        double income = 0;

        for (ContractModel contract : contracts)
        {
            income += contract.getIncome();
        }

        return income;
    }

    private double assignExpenses(List<ContractModel> contracts)
    {
        double income = 0;

        for (ContractModel contract : contracts)
        {
            Set<ExpenseModel> expenses = contract.getExpenses();

            for (ExpenseModel expense : expenses)
            {
                income += expense.getPrice();
            }
        }

        return income;
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

        double percentage = 0.00;

        if(totalCustomerIncome == 0)
        {
            customer.setPercentageOfCompanyIncome(percentage);
        }
        else
        {
            percentage = (totalCustomerIncome / totalCompanyIncome) * 100;

            percentage = roundToTwoDecimal(percentage);

            customer.setPercentageOfCompanyIncome(percentage);
        }
    }

    private double roundToTwoDecimal(double percentage)
    {
        DecimalFormat twoDecimalFormat = new DecimalFormat("#.##");
        percentage = Double.valueOf(twoDecimalFormat.format(percentage));

        return percentage;
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

    public void assignAllAmbassadorsMonthlyWages(List<AmbassadorModel> ambassadors)
    {
        for (AmbassadorModel ambassador : ambassadors)
        {
            assignAmbassadorMonthlyWage(ambassador);
        }
    }


    public void assignAmbassadorMonthlyWage(AmbassadorModel ambassador)
    {
        Set<ContractModel> contracts = ambassador.getContracts();

        double monthlySalary = 0;

        if(contracts == null)
        {
            ambassador.setSalary(0.0);
        }
        else
        {
            for (ContractModel contract : contracts)
            {
                Set<ExpenseModel> expenses = contract.getExpenses();

                monthlySalary += extractMonthlySalary(expenses);
            }
        }

        ambassador.setSalary(monthlySalary);
    }

    private double extractMonthlySalary(Set<ExpenseModel> expenses)
    {
        double monthlySalary = 0.0;

        for (ExpenseModel expense : expenses)
        {
            if(expense.getName().equals("Månedsløn"))
            {
                monthlySalary += expense.getPrice();
            }
        }

        return monthlySalary;
    }

    public TypePercentagesModel calculateTypePercentages()
    {
        double cleaningPercentage;
        double babysittingPercentage;
        double homeworkPercentage;
        double miscellaneousPercentage;

        cleaningPercentage = calculateIncomePercentage(ContractType.RENGØRING);
        babysittingPercentage = calculateIncomePercentage(ContractType.BØRNEPASNING);
        homeworkPercentage = calculateIncomePercentage(ContractType.LEKTIEHJÆLP);
        miscellaneousPercentage = calculateIncomePercentage(ContractType.DIVERSE);

        cleaningPercentage = roundToTwoDecimal(cleaningPercentage);
        babysittingPercentage = roundToTwoDecimal(babysittingPercentage);
        homeworkPercentage = roundToTwoDecimal(homeworkPercentage);
        miscellaneousPercentage = roundToTwoDecimal(miscellaneousPercentage);

        TypePercentagesModel typePercentages = new TypePercentagesModel(cleaningPercentage, babysittingPercentage, homeworkPercentage, miscellaneousPercentage);

        return typePercentages;
    }

    private double calculateIncomePercentage(ContractType contractType)
    {
        double totalCompanyIncome = getEconomyForEntireCompany().getIncome();
        double totalTypeIncome = 0;

        List<ContractModel> contracts = contractRepository.findAllByTypeEquals(contractType);

        totalTypeIncome = assignIncome(contracts);

        double percentage = (totalTypeIncome / totalCompanyIncome) * 100;

        return percentage;
    }
}
