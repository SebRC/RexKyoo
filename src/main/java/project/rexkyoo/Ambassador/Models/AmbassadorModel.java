package project.rexkyoo.Ambassador.Models;

import project.rexkyoo.Assignment.Business.Model.BusinessAssignmentModel;
import project.rexkyoo.Assignment.Private.Model.PrivateAssignmentModel;
import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;

import javax.persistence.*;

@Entity
@Table(name = "Ambassador")
public class AmbassadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ambassador_id")
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cleaningInspector_id")
    private CleaningInspectorModel cleaningInspector;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessAssignment_id")
    private BusinessAssignmentModel businessAssignment;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "privateAssignment_id", referencedColumnName = "privateAssignment_id")
    private PrivateAssignmentModel privateAssignment;

    public AmbassadorModel() {
    }

    public AmbassadorModel(String firstName, String lastName, String phone, String email, String address, CleaningInspectorModel cleaningInspector) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.cleaningInspector = cleaningInspector;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public CleaningInspectorModel getCleaningInspector() {
        return cleaningInspector;
    }

    public void setCleaningInspector(CleaningInspectorModel cleaningInspector) {
        this.cleaningInspector = cleaningInspector;
    }
}
