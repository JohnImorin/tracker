package dao;

import model.Expense;

import java.util.List;
import java.util.UUID;

public interface ExpenseDao {



     int insertNewExpense(UUID Expenseid, Expense expense);

     Expense getExpenseById(UUID Expenseid);

    List<Expense> selectAllExpense();

    int updateExpensebyID(UUID Expenseid, Expense expense);

    int deleteExpenseById(UUID Expenseid);

    List<Expense> deleteExpense();


}
