package project.rexkyoo.Assignment.Private.Model;

import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Customer.Private.Model.PrivateCustomerModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PrivateAssignment")
public class PrivateAssignmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int income;
    private Date startDate;
    private Date endDate;
    private String type;
    private CustomerModel customer;
    private AmbassadorModel ambassador;

    public PrivateAssignmentModel() {
    }

    public PrivateAssignmentModel(int id,int income, Date startDate, Date endDate, String type, CustomerModel customer, AmbassadorModel ambassador) {
        this.id = id;
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.customer = customer;
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

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public AmbassadorModel getAmbassador() {
        return ambassador;
    }

    public void setAmbassador(AmbassadorModel ambassador) {
        this.ambassador = ambassador;
    }
}
