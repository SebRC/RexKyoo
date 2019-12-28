package project.rexkyoo.Expenses;

import project.rexkyoo.Contract.ContractModel;

import javax.persistence.*;

@Entity
@Table(name = "Expense")
public class ExpenseModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "expense_id")
    private int id;
    private String date;
    private String name;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private ContractModel contract;

    public ExpenseModel()
    {}

    public ExpenseModel(String date, String name, Double price, ContractModel contract)
    {
        this.date = date;
        this.name = name;
        this.price = price;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
