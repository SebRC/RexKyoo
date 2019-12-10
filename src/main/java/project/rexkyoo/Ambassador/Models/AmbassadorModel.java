package project.rexkyoo.Ambassador.Models;

import project.rexkyoo.Assignment.Model.AssignmentModel;
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
    private String incomeMethod;
    private Double salary;
    private String note;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cleaningInspector_id")
    private CleaningInspectorModel cleaningInspector;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ambassador")
    private Set<AssignmentModel> assignments;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ambassador")
    private Set<FeedbackModel> feedbacks;

    public AmbassadorModel()
    {
    }

    public AmbassadorModel(String firstName, String lastName, String phone, String email, String address, String incomeMethod, Double salary, String note, CleaningInspectorModel cleaningInspector, Set<AssignmentModel> assignments, Set<FeedbackModel> feedbacks)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.incomeMethod = incomeMethod;
        this.salary = salary;
        this.note = note;
        this.cleaningInspector = cleaningInspector;
        this.assignments = assignments;
        this.feedbacks = feedbacks;
    }

    public int getId()
    {
        return id;
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

    public CleaningInspectorModel getCleaningInspector()
    {
        return cleaningInspector;
    }

    public void setCleaningInspector(CleaningInspectorModel cleaningInspector)
    {
        this.cleaningInspector = cleaningInspector;
    }

    public Set<AssignmentModel> getAssignments()
    {
        return assignments;
    }

    public void setAssignments(Set<AssignmentModel> assignments)
    {
        this.assignments = assignments;
    }

    public Set<FeedbackModel> getFeedbacks()
    {
        return feedbacks;
    }

    public void setFeedbacks(Set<FeedbackModel> feedbacks)
    {
        this.feedbacks = feedbacks;
    }

    public String getIncomeMethod() {
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
