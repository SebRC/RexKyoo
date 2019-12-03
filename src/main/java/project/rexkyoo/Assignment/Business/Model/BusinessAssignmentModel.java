package project.rexkyoo.Assignment.Business.Model;

import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Customer.Business.Model.BusinessCustomerModel;
import project.rexkyoo.Expenses.Models.ExpenseModel;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BusinessAssignment")
public class BusinessAssignmentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "businessAssignment_id")
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
    @JoinTable(name = "Businessassignment_Businesscustomer",
            joinColumns =
                    {
                            @JoinColumn(name = "businessAssignment_id")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "businessCustomer_id")
                    })
    private Set<BusinessCustomerModel> businessCustomers = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    })
    @JoinTable(name = "Businessassignment_Expense",
            joinColumns =
                    {
                            @JoinColumn(name = "businessAssignment_id")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "expense_id")
                    })
    private Set<ExpenseModel> expenses = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessAssignment")
    private Set<AmbassadorModel> ambassadors;

    public BusinessAssignmentModel()
    {
    }

    public BusinessAssignmentModel(int income, Date startDate, Date endDate, String type, Set<BusinessCustomerModel> businessCustomers, Set<ExpenseModel> expenses, Set<AmbassadorModel> ambassadors)
    {
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.businessCustomers = businessCustomers;
        this.expenses = expenses;
        this.ambassadors = ambassadors;
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

    public Set<BusinessCustomerModel> getBusinessCustomers()
    {
        return businessCustomers;
    }

    public void setBusinessCustomers(Set<BusinessCustomerModel> businessCustomers)
    {
        this.businessCustomers = businessCustomers;
    }

    public Set<ExpenseModel> getExpenses()
    {
        return expenses;
    }

    public void setExpenses(Set<ExpenseModel> expenses)
    {
        this.expenses = expenses;
    }

    public Set<AmbassadorModel> getAmbassadors()
    {
        return ambassadors;
    }

    public void setAmbassadors(Set<AmbassadorModel> ambassadors)
    {
        this.ambassadors = ambassadors;
    }
}
