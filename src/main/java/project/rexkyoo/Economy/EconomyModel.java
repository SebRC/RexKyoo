package project.rexkyoo.Economy;

public class EconomyModel
{
    private double income;
    private double expenses;
    private double profit;

    public EconomyModel()
    {
        this.income = 0;
        this.expenses = 0;
        this.profit = 0;
    }

    public EconomyModel(double income, double expenses, double profit)
    {
        this.income = income;
        this.expenses = expenses;
        this.profit = profit;
    }

    public double getIncome()
    {
        return income;
    }

    public void setIncome(double income)
    {
        this.income = income;
    }

    public double getExpenses()
    {
        return expenses;
    }

    public void setExpenses(double expenses)
    {
        this.expenses = expenses;
    }

    public double getProfit()
    {
        return profit;
    }

    public void setProfit(double profit)
    {
        this.profit = profit;
    }
}
