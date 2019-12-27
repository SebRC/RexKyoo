package project.rexkyoo.Ambassador.Models;

import project.rexkyoo.Contract.Model.ContractModel;
import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;
import project.rexkyoo.Feedback.Model.FeedbackModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Ambassador")
public class AmbassadorModel
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ambassador_id")
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String zipCode;
    private String incomeMethod;
    private Double salary = 0.0;
    private String note = "";


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cleaningInspector_id")
    private CleaningInspectorModel cleaningInspector;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ambassador")
    private Set<ContractModel> contracts;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ambassador")
    private Set<FeedbackModel> feedbacks;

    public AmbassadorModel()
    {
    }

    public AmbassadorModel(String firstName, String lastName, String phone, String email, String address, String city, String zipCode, String incomeMethod, Double salary, String note, CleaningInspectorModel cleaningInspector, Set<ContractModel> contracts, Set<FeedbackModel> feedbacks)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.incomeMethod = incomeMethod;
        this.salary = salary;
        this.note = note;
        this.cleaningInspector = cleaningInspector;
        this.contracts = contracts;
        this.feedbacks = feedbacks;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipcode)
    {
        this.zipCode = zipcode;
    }

    public CleaningInspectorModel getCleaningInspector()
    {
        return cleaningInspector;
    }

    public void setCleaningInspector(CleaningInspectorModel cleaningInspector)
    {
        this.cleaningInspector = cleaningInspector;
    }

    public Set<ContractModel> getContracts()
    {
        return contracts;
    }

    public void setContracts(Set<ContractModel> contracts)
    {
        this.contracts = contracts;
    }

    public Set<FeedbackModel> getFeedbacks()
    {
        return feedbacks;
    }

    public void setFeedbacks(Set<FeedbackModel> feedbacks)
    {
        this.feedbacks = feedbacks;
    }

    public String getIncomeMethod()
    {
        return incomeMethod;
    }

    public void setIncomeMethod(String incomeMethod) {
        this.incomeMethod = incomeMethod;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
