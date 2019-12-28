package project.rexkyoo.Economy;

import java.util.HashMap;
import java.util.Map;

public class MonthsIncomeModel
{
    private Map<String, Double> monthToIncome;

    MonthsIncomeModel()
    {
        this.monthToIncome = new HashMap<>();

        this.monthToIncome.put("JAN", 0.0);
        this.monthToIncome.put("FEB", 0.0);
        this.monthToIncome.put("MAR", 0.0);
        this.monthToIncome.put("APR", 0.0);
        this.monthToIncome.put("MAY", 0.0);
        this.monthToIncome.put("JUN", 0.0);
        this.monthToIncome.put("JUL", 0.0);
        this.monthToIncome.put("AUG", 0.0);
        this.monthToIncome.put("SEP", 0.0);
        this.monthToIncome.put("OCT", 0.0);
        this.monthToIncome.put("NOV", 0.0);
        this.monthToIncome.put("DEC", 0.0);
    }

    public Map<String, Double> getMonthToIncome()
    {
        return monthToIncome;
    }

    public void setMonthToIncome(Map<String, Double> monthToIncome)
    {
        this.monthToIncome = monthToIncome;
    }
}
