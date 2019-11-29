package project.rexkyoo.Assignment.Business.Model;

import project.rexkyoo.Customer.Business.Model.BusinessCustomerModel;
import project.rexkyoo.Expenses.Models.ExpenseModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BusinessAssignment")
public class BusinessAssignmentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int income;
    private Date startDate;
    private Date endDate;
    private String type;
    private BusinessCustomerModel businessCustomers;
    private String ambassador;
    private ExpenseModel expenses;


    public BusinessAssignmentModel()
    {

    }

    public BusinessAssignmentModel(int income, Date startDate, Date endDate, String type, BusinessCustomerModel businessCustomers, String ambassador, ExpenseModel expenses) {
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.businessCustomers = businessCustomers;
        this.ambassador = ambassador;
        this.expenses = expenses;
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

    public BusinessCustomerModel getBusinessCustomers() {
        return businessCustomers;
    }

    public void setBusinessCustomers(BusinessCustomerModel businessCustomers) {
        this.businessCustomers = businessCustomers;
    }

    public String getAmbassador() {
        return ambassador;
    }

    public void setAmbassador(String ambassador) {
        this.ambassador = ambassador;
    }

    public ExpenseModel getExpenses() {
        return expenses;
    }

    public void setExpenses(ExpenseModel expenses) {
        this.expenses = expenses;
    }
}
