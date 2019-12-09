package project.rexkyoo.Customer.Model;

import project.rexkyoo.Assignment.Model.AssignmentModel;
import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;
import project.rexkyoo.Feedback.Model.FeedbackModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Customer")
public class CustomerModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "customer_id")
    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private Double payments;
    private String zipCode;
    private String city;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<AssignmentModel> assignments;

    @OneToOne (mappedBy = "customer")
    private CleaningInspectorModel cleaningInspector;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<FeedbackModel> feedbacks;


    public CustomerModel()
    {

    }


    public CustomerModel(String name, String phone, String address, String email, Double payments, String zipCode, String city, Set<AssignmentModel> assignments, CleaningInspectorModel cleaningInspector, Set<FeedbackModel> feedbacks)
    {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.payments = payments;
        this.zipCode = zipCode;
        this.city = city;
        this.assignments = assignments;
        this.cleaningInspector = cleaningInspector;
        this.feedbacks = feedbacks;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Double getPayments()
    {
        return payments;
    }

    public void setPayments(Double payments)
    {
        this.payments = payments;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public CleaningInspectorModel getCleaningInspector()
    {
        return cleaningInspector;
    }

    public void setCleaningInspector(CleaningInspectorModel cleaningInspector)
    {
        this.cleaningInspector = cleaningInspector;
    }

    public Set<FeedbackModel> getFeedbacks()
    {
        return feedbacks;
    }

    public void setFeedbacks(Set<FeedbackModel> feedbacks)
    {
        this.feedbacks = feedbacks;
    }

    public Set<AssignmentModel> getAssignments()
    {
        return assignments;
    }

    public void setAssignments(Set<AssignmentModel> assignments)
    {
        this.assignments = assignments;
    }
}
