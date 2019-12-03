package project.rexkyoo.Feedback.Model;

import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Customer.Business.Model.BusinessCustomerModel;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Customer.Private.Model.PrivateCustomerModel;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public FeedbackModel()
    {
    }

    public FeedbackModel(String comment, Date date, String category, AmbassadorModel ambassador)
    {
        this.comment = comment;
        this.date = date;
        this.category = category;
        this.ambassador = ambassador;
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

}
