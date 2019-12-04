package project.rexkyoo.Customer.Business.Model;

import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;
import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Feedback.Model.FeedbackModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "BusinessCustomer")
public class BusinessCustomerModel extends CustomerModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "businessCustomer_id")
    private int id;


    @OneToOne (mappedBy = "businessCustomer")
    private CleaningInspectorModel cleaningInspector;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    })
    @JoinTable(name = "Businesscustomer_Feedback",
            joinColumns =
                    {
                            @JoinColumn(name = "businessCustomer_id")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "feedback_id")
                    })
    private Set<FeedbackModel> feedbacks = new HashSet<>();

    public BusinessCustomerModel()
    {

    }

    public BusinessCustomerModel(int id ,String name, String phone, String address, String email, List<Double> payments, List<Double> expenses, List<String> ambassadors, String zipCode, String city, CleaningInspectorModel cleaningInspector, Set<FeedbackModel> feedbacks)
    {
        super(name, phone, address, email, payments, expenses, ambassadors, zipCode, city);
        this.id = id;
        this.cleaningInspector = cleaningInspector;
        this.feedbacks = feedbacks;
    }

    public CleaningInspectorModel getCleaningInspectorModel()
    {
        return cleaningInspector;
    }

    public void setCleaningInspectorModel(CleaningInspectorModel cleaningInspectorModel)
    {
        this.cleaningInspector = cleaningInspector;
    }

    public int getId()
    {
        return id;
    }

    public Set<FeedbackModel> getFeedbacks()
    {
        return feedbacks;
    }

    public void setFeedbacks(Set<FeedbackModel> feedbacks)
    {
        this.feedbacks = feedbacks;
    }
}
