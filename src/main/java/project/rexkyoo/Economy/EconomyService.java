package project.rexkyoo.Economy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Contract.ContractType;
import project.rexkyoo.Contract.ContractModel;
import project.rexkyoo.Contract.ContractRepository;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Expenses.ExpenseModel;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Set;

// SRC

@Service
public class EconomyService
{
    @Autowired
    private ContractRepository contractRepository;

    public EconomyModel getEconomyBasedOnCustomerType(String type)
    {
        // SRC

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
        // SRC

        double income = 0;

        for (ContractModel contract : contracts)
        {
            income += contract.getIncome();
        }

        return income;
    }

    private double assignExpenses(List<ContractModel> contracts)
    {
        // SRC

        double companyExpensese = 0;

        for (ContractModel contract : contracts)
        {
            Set<ExpenseModel> expenses = contract.getExpenses();

            for (ExpenseModel expense : expenses)
            {
                companyExpensese += expense.getPrice();
            }
        }

        return companyExpensese;
    }

    public EconomyModel getEconomyForEntireCompany()
    {
        // SRC

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
        // SRC

        for (CustomerModel customer : customers)
        {
            assignPercentage(customer);
        }
    }

    private void assignPercentage(CustomerModel customer)
    {
        // SRC

        double totalCompanyIncome = getEconomyForEntireCompany().getIncome();

        Set<ContractModel> contracts = customer.getContracts();
        double totalCustomerIncome = 0;

        for (ContractModel contract : contracts)
        {
            totalCustomerIncome += contract.getIncome();
        }

        double percentage = 0.00;

        if (totalCustomerIncome == 0)
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
        // SRC

        DecimalFormat twoDecimalFormat = new DecimalFormat("#.##");
        percentage = Double.valueOf(twoDecimalFormat.format(percentage));

        return percentage;
    }

    public void assignEconomyForCustomers(List<CustomerModel> customers)
    {
        // SRC

        for (CustomerModel customer : customers)
        {
            assignEconomyForSingleCustomer(customer);
        }
    }

    public void assignEconomyForSingleCustomer(CustomerModel customer)
    {
        // SRC

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
        // SRC

        for (AmbassadorModel ambassador : ambassadors)
        {
            assignAmbassadorMonthlyWage(ambassador);
        }
    }

    public void assignAmbassadorMonthlyWage(AmbassadorModel ambassador)
    {
        // SRC

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
        // SRC

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
        // SRC

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
        // SRC

        double totalCompanyIncome = getEconomyForEntireCompany().getIncome();
        double totalTypeIncome;

        List<ContractModel> contracts = contractRepository.findAllByTypeEquals(contractType);

        totalTypeIncome = assignIncome(contracts);

        double percentage;

        if(totalTypeIncome == 0)
        {
            percentage = 0.0;
        }
        else
        {
            percentage = (totalTypeIncome / totalCompanyIncome) * 100;

            percentage = roundToTwoDecimal(percentage);
        }

        return percentage;
    }

    public double calculateProfitPercentage()
    {
        // SRC

        double profitPercentage;
        double profit;
        double totalCompanyIncome = getEconomyForEntireCompany().getIncome();

        List<ContractModel> contracts = contractRepository.findAll();

        double totalCompanyExpenses = assignExpenses(contracts);

        profit = totalCompanyIncome - totalCompanyExpenses;

        if (profit == 0)
        {
            profitPercentage = 0.0;
        }
        else
        {
            profitPercentage = (profit / totalCompanyIncome) * 100;

            profitPercentage = roundToTwoDecimal(profitPercentage);
        }

        return profitPercentage;
    }

    public void assignMonthsToContracts(List<ContractModel> contracts)
    {
        // SRC

        for (ContractModel contract : contracts)
        {
            SimpleDateFormat yearMonthDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date startDate;
            Date endDate;

            try
            {
                startDate = yearMonthDateFormat.parse(contract.getStartDate());
                endDate = yearMonthDateFormat.parse(contract.getEndDate());
            }
            catch (ParseException parseException)
            {
                contract.getMonths().add("NOT FOUND");
                return;
            }

            int startMonthIndex = startDate.getMonth() + 1;
            int endMonthIndex = endDate.getMonth() + 1;

            if(endMonthIndex < startMonthIndex)
            {
                String startYear = contract.getStartDate().substring(0,4);
                String endYear = contract.getEndDate().substring(0,4);

                int start = Integer.parseInt(startYear);
                int end = Integer.parseInt(endYear);

                int numberOfYearsBetweenStartAndEnd = end - start - 1;

                addMonthsFromInBetweenYears(contract, numberOfYearsBetweenStartAndEnd);

                addMonthsFromStartMonth(contract, startMonthIndex);

                addMonthsFromEndMonth(contract, endMonthIndex);
            }
            else
            {
                addCalendarYearContract(contract, startMonthIndex, endMonthIndex);
            }
        }
    }

    private void addMonthsFromInBetweenYears(ContractModel contract, int numberOfYearsBetweenStartAndEnd)
    {
        // SRC

        for(int i = 0; i <= numberOfYearsBetweenStartAndEnd; i++)
        {
            for (int j = 1; j <= 12; j++)
            {
                addMonthToContract(contract, j);
            }
        }
    }

    private void addMonthsFromStartMonth(ContractModel contract, int startMonthIndex)
    {
        // SRC

        for (int i = startMonthIndex; i <= 12; i++)
        {
            addMonthToContract(contract, i);
        }
    }

    private void addMonthsFromEndMonth(ContractModel contract, int endMonthIndex)
    {
        // SRC

        for (int i = 1; i <= endMonthIndex; i++)
        {
            addMonthToContract(contract, i);
        }
    }

    private void addCalendarYearContract(ContractModel contract,int startMonthIndex, int endMonthIndex)
    {
        // SRC

        for (int i = startMonthIndex; i <= endMonthIndex; i++)
        {
            addMonthToContract(contract, i);
        }
    }

    private void addMonthToContract(ContractModel contract, int index)
    {
        // SRC

        Month currentEvaluatedMonth = Month.of(index);

        String formattedMonth = currentEvaluatedMonth.toString().substring(0, 3);

        contract.getMonths().add(formattedMonth);
    }

    public MonthsIncomeModel getMonthPayments(List<ContractModel> contracts)
    {
        // SRC

        MonthsIncomeModel monthsIncome = new MonthsIncomeModel();

        for (ContractModel contract : contracts)
        {
            for (String month : contract.getMonths())
            {
                double income = monthsIncome.getMonthToIncome().get(month);

                income += contract.getIncome();

                monthsIncome.getMonthToIncome().put(month, income);
            }
        }

        return monthsIncome;
    }
}

