package project.rexkyoo.Assignment.Private.Model;

import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Customer.Private.Model.PrivateCustomerModel;
import project.rexkyoo.Expenses.Models.ExpenseModel;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PrivateAssignment")
public class PrivateAssignmentModel
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "privateAssignment_id")
    private int id;
    private int income;
    private Date startDate;
    private Date endDate;
    private String type;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    })
    @JoinTable(name = "Privateassignment_Privatecustomers",
            joinColumns =
                    {
                            @JoinColumn(name = "privateAssignment_id")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "privateCustomers_id")
                    })
    private Set<PrivateCustomerModel> privateCustomers = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    })
    @JoinTable(name = "Privateassignment_Expense",
            joinColumns =
                    {
                            @JoinColumn(name = "privateAssignment_id")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "expense_id")
                    })
    private Set<ExpenseModel> expenses = new HashSet<>();

    @OneToOne (mappedBy = "privateAssignment")
    private AmbassadorModel ambassador;

    public PrivateAssignmentModel()
    {}

    public PrivateAssignmentModel(int id,int income, Date startDate, Date endDate, String type, Set<PrivateCustomerModel> privateCustomers, Set<ExpenseModel> expenses, AmbassadorModel ambassador)
    {
        this.id = id;
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.privateCustomers = privateCustomers;
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

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
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

    public Set<PrivateCustomerModel> getPrivateCustomers()
    {
        return privateCustomers;
    }

    public void setPrivateCustomers(Set<PrivateCustomerModel> privateCustomers)
    {
        this.privateCustomers = privateCustomers;
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
