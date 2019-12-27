package project.rexkyoo.Contract;

import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Contract.ContractType;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Expenses.Models.ExpenseModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Contract")
public class ContractModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private int id;
    private double income;
    private String startDate;
    private String endDate;
    private ContractType type;
    private double hourlyWage;
    private double workHoursPerMonth;
    @Transient
    private List<String> months = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ExpenseModel> expenses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambassador_id")
    private AmbassadorModel ambassador;


    public ContractModel()
    {
    }

    public ContractModel(double income, String startDate, String endDate, ContractType type,
                         double hourlyWage, double workHoursPerMonth, CustomerModel customer,
                         Set<ExpenseModel> expenses, AmbassadorModel ambassador)
    {
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.hourlyWage = hourlyWage;
        this.workHoursPerMonth = workHoursPerMonth;
        this.customer = customer;
        this.expenses = expenses;
        this.ambassador = ambassador;
    }

    public int getId()
    {
        return id;
    }


    public double getIncome()
    {
        return income;
    }

    public void setIncome(double income)
    {
        this.income = income;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public ContractType getType()
    {
        return type;
    }

    public void setType(ContractType type)
    {
        this.type = type;
    }

    public double getHourlyWage()
    {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage)
    {
        this.hourlyWage = hourlyWage;
    }

    public double getWorkHoursPerMonth()
    {
        return workHoursPerMonth;
    }

    public void setWorkHoursPerMonth(double workHoursPerMonth)
    {
        this.workHoursPerMonth = workHoursPerMonth;
    }

    public CustomerModel getCustomer()
    {
        return customer;
    }

    public void setCustomer(CustomerModel customer)
    {
        this.customer = customer;
    }

    public Set<ExpenseModel> getExpenses()
    {
        return expenses;
    }

    public void setExpenses(Set<ExpenseModel> expenses)
    {
        this.expenses = expenses;
    }

    public AmbassadorModel getAmbassador()
    {
        return ambassador;
    }

    public void setAmbassador(AmbassadorModel ambassador)
    {
        this.ambassador = ambassador;
    }

    public List<String> getMonths()
    {
        return months;
    }

    public void setMonths(List<String> months)
    {
        this.months = months;
    }
}
