package project.rexkyoo.Customer.Business.Model;

import project.rexkyoo.CleaningInspector.Models.CleaningInspectorModel;
import project.rexkyoo.Customer.CustomerModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "BusinessCustomer")
public class BusinessCustomerModel extends CustomerModel
{
    private CleaningInspectorModel cleaningInspectorModel;

    public BusinessCustomerModel()
    {

    }

    public BusinessCustomerModel(int id, String name, String phone, String address, String email, List<Double> payments, List<Double> expenses, List<String> ambassadors, String zipCode, String city, CleaningInspectorModel cleaningInspectorModel)
    {
        super(id, name, phone, address, email, payments, expenses, ambassadors, zipCode, city);
        this.cleaningInspectorModel = cleaningInspectorModel;
    }

    public CleaningInspectorModel getCleaningInspectorModel()
    {
        return cleaningInspectorModel;
    }

    public void setCleaningInspectorModel(CleaningInspectorModel cleaningInspectorModel)
    {
        this.cleaningInspectorModel = cleaningInspectorModel;
    }
}
