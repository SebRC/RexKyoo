package project.rexkyoo.CleaningInspector.Models;

import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Customer.Model.CustomerModel;

import javax.persistence.*;
import java.util.Set;

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

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "customer_id", referencedColumnName = "customer_id")
    private CustomerModel customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="cleaningInspector")
    private Set<AmbassadorModel> ambassadors;

    public CleaningInspectorModel()
    {}

    public CleaningInspectorModel(String firstName, String lastName, String phone, String email, String address, CustomerModel customer, Set<AmbassadorModel> ambassadors)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
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
}
