package project.rexkyoo.Economy;

import java.util.HashMap;
import java.util.Map;

public class MonthsIncomeModel
{
    private Map<String, Double> monthsIncome;

    public MonthsIncomeModel()
    {
        this.monthsIncome = new HashMap<>();

        this.monthsIncome.put("JAN", 0.0);
        this.monthsIncome.put("FEB", 0.0);
        this.monthsIncome.put("MAR", 0.0);
        this.monthsIncome.put("APR", 0.0);
        this.monthsIncome.put("MAY", 0.0);
        this.monthsIncome.put("JUN", 0.0);
        this.monthsIncome.put("JUL", 0.0);
        this.monthsIncome.put("AUG", 0.0);
        this.monthsIncome.put("SEP", 0.0);
        this.monthsIncome.put("OCT", 0.0);
        this.monthsIncome.put("NOV", 0.0);
        this.monthsIncome.put("DEC", 0.0);
    }

    public Map<String, Double> getMonthsIncome()
    {
        return monthsIncome;
    }

    public void setMonthsIncome(Map<String, Double> monthsIncome)
    {
        this.monthsIncome = monthsIncome;
    }
}
