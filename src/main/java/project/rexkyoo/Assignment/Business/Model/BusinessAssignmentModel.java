package project.rexkyoo.Assignment.Business.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class BusinessAssignmentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int income;
    private Date startDate;
    private Date endDate;
    private String type;

    public BusinessAssignmentModel()
    {

    }

    public BusinessAssignmentModel(int id, int income, Date startDate, Date endDate, String type)
    {
        this.id = id;
        this.income = income;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
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
}
