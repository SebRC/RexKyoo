package project.rexkyoo.Expenses.Models;

import project.rexkyoo.Assignment.Model.AssignmentModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    @JoinColumn(name = "assignment_id")
    private AssignmentModel assignment;

    public ExpenseModel() {
    }

    public ExpenseModel(Date date, String name, Double price, AssignmentModel assignment)
    {
        this.date = date;
        this.name = name;
        this.price = price;
        this.assignment = assignment;
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

    public AssignmentModel getAssignment()
    {
        return assignment;
    }

    public void setAssignment(AssignmentModel assignment)
    {
        this.assignment = assignment;
    }
}
