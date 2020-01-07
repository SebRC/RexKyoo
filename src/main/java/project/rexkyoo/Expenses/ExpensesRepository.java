package project.rexkyoo.Expenses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TA

@Repository
public interface ExpensesRepository extends JpaRepository<ExpenseModel, Integer>
{}
