package project.rexkyoo.CleaningInspector;

import project.rexkyoo.Ambassador.AmbassadorModel;
import project.rexkyoo.Customer.CustomerModel;

import javax.persistence.*;
import java.util.Set;

// JV, TA

@Entity
@Table(name = "CleaningInspector")
public class CleaningInspectorModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "cleaningInspector_id")
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String zipCode;
    private String incomeMethod;
    private String note = "";
    @Transient
    private Double salary = 0.0;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "customer_id", referencedColumnName = "customer_id")
    private CustomerModel customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="cleaningInspector")
    private Set<AmbassadorModel> ambassadors;

    public CleaningInspectorModel()
    {}

    public CleaningInspectorModel(String firstName, String lastName, String phone, String email, String address, String city, String zipCode, String incomeMethod, String note, CustomerModel customer, Set<AmbassadorModel> ambassadors)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.incomeMethod = incomeMethod;
        this.note = note;
        this.customer = customer;
        this.ambassadors = ambassadors;
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

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public CustomerModel getCustomer()
    {
        return customer;
    }

    public void setCustomer(CustomerModel customer)
    {
        this.customer = customer;
    }

    public Set<AmbassadorModel> getAmbassadors()
    {
        return ambassadors;
    }

    public void setAmbassadors(Set<AmbassadorModel> ambassadors)
    {
        this.ambassadors = ambassadors;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    public String getIncomeMethod()
    {
        return incomeMethod;
    }

    public void setIncomeMethod(String incomeMethod)
    {
        this.incomeMethod = incomeMethod;
    }
}
