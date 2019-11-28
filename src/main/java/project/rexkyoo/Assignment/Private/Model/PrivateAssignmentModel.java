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
    private PrivateCustomerModel privateCustomerModel;
    private String ambassador;

    public PrivateAssignmentModel()
    {}

    public PrivateAssignmentModel(int income, Date startDate, Date endDate, String type, PrivateCustomerModel privateCustomerModel, String ambassador)
    {
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.privateCustomerModel = privateCustomerModel;
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

    public PrivateCustomerModel getPrivateCustomerModel()
    {
        return privateCustomerModel;
    }

    public void setPrivateCustomerModel(PrivateCustomerModel privateCustomerModel)
    {
        this.privateCustomerModel = privateCustomerModel;
    }

    public String getAmbassador()
    {
        return ambassador;
    }

    public void setAmbassador(String ambassador)
    {
        this.ambassador = ambassador;
    }
}
