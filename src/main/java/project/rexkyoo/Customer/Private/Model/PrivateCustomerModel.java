package project.rexkyoo.Customer.Private.Model;

import project.rexkyoo.Customer.CustomerModel;
import project.rexkyoo.Feedback.Model.FeedbackModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PrivateCustomer")
public class PrivateCustomerModel extends CustomerModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "privateCustomer_id")
    private int id;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    })
    @JoinTable(name = "Privatecustomer_Feedback",
            joinColumns =
                    {
                            @JoinColumn(name = "privateCustomer_id")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "feedback_id")
                    })
    private Set<FeedbackModel> feedbacks = new HashSet<>();

    public PrivateCustomerModel()
    {}

    public PrivateCustomerModel(int id,String name, String phone, String address, String email, List<Double> payments, List<Double> expenses, List<String> ambassadors, String zipCode, String city, String lastName, Set<FeedbackModel> feedbacks)
    {
        super(name, phone, address, email, payments, expenses, ambassadors, zipCode, city);
        this.id = id;
        this.lastName = lastName;
        this.feedbacks = feedbacks;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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
