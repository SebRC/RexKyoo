package project.rexkyoo.Feedback.Model;

import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Customer.Model.CustomerModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Feedback")
public class FeedbackModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feedback_id")
    private int id;
    private String comment;
    private Date date;
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambassador_id")
    private AmbassadorModel ambassador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;


    public FeedbackModel()
    {
    }

    public FeedbackModel(String comment, Date date, String category, AmbassadorModel ambassador, CustomerModel customer)
    {
        this.comment = comment;
        this.date = date;
        this.category = category;
        this.ambassador = ambassador;
        this.customer = customer;
    }

    public int getId()
    {
        return id;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public AmbassadorModel getAmbassador()
    {
        return ambassador;
    }

    public void setAmbassador(AmbassadorModel ambassador)
    {
        this.ambassador = ambassador;
    }

    public CustomerModel getCustomer()
    {
        return customer;
    }

    public void setCustomer(CustomerModel customer)
    {
        this.customer = customer;
    }
}
