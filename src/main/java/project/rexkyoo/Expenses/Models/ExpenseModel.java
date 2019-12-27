package project.rexkyoo.Expenses.Models;

import project.rexkyoo.Contract.Model.ContractModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Expense")
public class ExpenseModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "expense_id")
    private int id;
    private Date date;
    private String name;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private ContractModel contract;

    public ExpenseModel() {
    }

    public ExpenseModel(Date date, String name, Double price, ContractModel contract)
    {
        this.date = date;
        this.name = name;
        this.price = price;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ContractModel getContract()
    {
        return contract;
    }

    public void setContract(ContractModel contract)
    {
        this.contract = contract;
    }
}
