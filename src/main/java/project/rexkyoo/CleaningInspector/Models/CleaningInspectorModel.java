package project.rexkyoo.CleaningInspector.Models;

import project.rexkyoo.Customer.Business.Model.BusinessCustomerModel;

import javax.persistence.*;

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
    private int phone;
    private String email;
    private String address;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "businessCustomers_id", referencedColumnName = "businessCustomer_id")
    private BusinessCustomerModel businessCustomers;

    public CleaningInspectorModel()
    {}

    public CleaningInspectorModel(int id, String firstName, String lastName, int phone, String email, String address)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
