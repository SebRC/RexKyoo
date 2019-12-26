package project.rexkyoo.Assignment.Model;

import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Customer.Model.CustomerModel;
import project.rexkyoo.Expenses.Models.ExpenseModel;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Assignment")
public class AssignmentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assignment_id")
    private int id;
    private int income;
    private String startDate;
    private String endDate;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignment")
    private Set<ExpenseModel> expenses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambassador_id")
    private AmbassadorModel ambassador;


    public AssignmentModel()
    {
    }

    public AssignmentModel(int income, String startDate, String endDate, String type, CustomerModel customer, Set<ExpenseModel> expenses, AmbassadorModel ambassador)
    {
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.customer = customer;
        this.expenses = expenses;
        this.ambassador = ambassador;
    }

    public int getId()
    {
        return id;
    }


    public int getIncome()
    {
        return income;
    }

    public void setIncome(int income)
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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
}
