package project.rexkyoo.Expenses.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.rexkyoo.Expenses.Models.ExpenseModel;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpenseModel, Integer> {

}
