package project.rexkyoo.Assignment.Business.Model;

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
    @Column (name = "businessAssignment_id")
    private int id;
    private int income;
    private Date startDate;
    private Date endDate;
    private String type;
    private String ambassador;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    })
    @JoinTable(name = "BusinessAssignment_BusinessCustomer",
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
    @JoinTable(name = "BusinessAssignment_Expense",
            joinColumns =
                    {
                            @JoinColumn(name = "businessAssignment_id")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "expense_id")
                    })
    private Set<ExpenseModel> expenses = new HashSet<>();

    public BusinessAssignmentModel()
    {}

    public BusinessAssignmentModel(int income, Date startDate, Date endDate, String type, BusinessCustomerModel businessCustomers, String ambassador, ExpenseModel expenses)
    {
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.ambassador = ambassador;
    }

    public int getId() {
        return id;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getAmbassador() {
        return ambassador;
    }

    public void setAmbassador(String ambassador) {
        this.ambassador = ambassador;
    }

    public Set<BusinessCustomerModel> getBusinessCustomers() {
        return businessCustomers;
    }

    public void setBusinessCustomers(Set<BusinessCustomerModel> businessCustomers) {
        this.businessCustomers = businessCustomers;
    }

    public Set<ExpenseModel> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<ExpenseModel> expenses) {
        this.expenses = expenses;
    }
}
