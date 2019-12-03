package project.rexkyoo.CleaningInspector.Models;

import project.rexkyoo.Ambassador.Models.AmbassadorModel;
import project.rexkyoo.Customer.Business.Model.BusinessCustomerModel;

import javax.persistence.*;
import java.util.HashSet;
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
    @JoinColumn (name = "businessCustomer_id", referencedColumnName = "businessCustomer_id")
    private BusinessCustomerModel businessCustomer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="cleaningInspector")
    private Set<AmbassadorModel> ambassadors;

    public CleaningInspectorModel()
    {}

    public CleaningInspectorModel(int id,String firstName, String lastName, String phone, String email, String address, BusinessCustomerModel businessCustomer, Set<AmbassadorModel> ambassadors)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.businessCustomer = businessCustomer;
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

    public BusinessCustomerModel getBusinessCustomer()
    {
        return businessCustomer;
    }

    public void setBusinessCustomer(BusinessCustomerModel businessCustomer)
    {
        this.businessCustomer = businessCustomer;
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
