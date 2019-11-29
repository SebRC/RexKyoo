package project.rexkyoo.Expenses.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Expense")
public class ExpenseModel
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private String name;
    private Double price;

    public ExpenseModel() {
    }

    public ExpenseModel(int id, Date date, String name, Double price) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.price = price;
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
}
