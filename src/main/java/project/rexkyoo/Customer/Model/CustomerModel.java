package project.rexkyoo.Customer.Model;

import project.rexkyoo.Assignment.Model.AssignmentModel;
import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;
import project.rexkyoo.CustomerPaymentDate.Model.CustomerPaymentDateModel;
import project.rexkyoo.Feedback.Model.FeedbackModel;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;


@Entity
@Table(name = "Customer")
public class CustomerModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "customer_id")
    private int id;
    private String name;
    private String email;
    private String address;
    private String city;
    private String zipCode;
    private String phone;
    private String type;
    private String note = "";
    @Transient
    private String expectedPaymentDate;
    @Transient
    private String actualPaymentDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<AssignmentModel> assignments;

    @OneToOne (mappedBy = "customer")
    private CleaningInspectorModel cleaningInspector;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<FeedbackModel> feedbacks;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerPaymentDateModel> customerPaymentDates;

    public CustomerModel()
    {

    }


    public CustomerModel(String name, String email, String address, String city, String zipCode, String phone, String type, String note, Set<AssignmentModel> assignments, CleaningInspectorModel cleaningInspector, Set<FeedbackModel> feedbacks, Set<CustomerPaymentDateModel> customerPaymentDates)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phone = phone;
        this.type = type;
        this.note = note;
        this.assignments = assignments;
        this.cleaningInspector = cleaningInspector;
        this.feedbacks = feedbacks;
        this.customerPaymentDates = customerPaymentDates;
    }

    public void assignDates() throws Exception
    {
        CustomerPaymentDateModel relevantPaymentDates = new CustomerPaymentDateModel();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

        Date mostRecentDate = new Date(1);

        for (CustomerPaymentDateModel paymentDates : customerPaymentDates)
        {
            Date currentEvaluatedDate = simpleDateFormat.parse(paymentDates.getExpectedPaymentDate());

            if(currentEvaluatedDate.compareTo(mostRecentDate) >= 1)
            {
                relevantPaymentDates = paymentDates;
            }
        }

        this.expectedPaymentDate = relevantPaymentDates.getExpectedPaymentDate();

        this.actualPaymentDate = relevantPaymentDates.getActualPaymentDate();
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public Set<CustomerPaymentDateModel> getCustomerPaymentDates()
    {
        return customerPaymentDates;
    }

    public void setCustomerPaymentDateModels(Set<CustomerPaymentDateModel> customerPaymentDates)
    {
        this.customerPaymentDates = customerPaymentDates;
    }

    public String getExpectedPaymentDate()
    {
        return expectedPaymentDate;
    }

    public void setExpectedPaymentDate(String expectedPaymentDate)
    {
        this.expectedPaymentDate = expectedPaymentDate;
    }

    public String getActualPaymentDate()
    {
        return actualPaymentDate;
    }

    public void setActualPaymentDate(String actualPaymentDate)
    {
        this.actualPaymentDate = actualPaymentDate;
    }
}
