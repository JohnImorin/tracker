package service;

import dao.ExpenseDao;
import model.Expense;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ExpenseService {
    public java.awt.List getAllExpense;
    private ExpenseDao expensedao;

    public ExpenseService(@Qualifier("realdao") ExpenseDao expensedao) {
        this.expensedao = expensedao;
    }

    public int persistNewExpense(UUID Expenseid, Expense expense) {

        return expensedao.insertNewExpense(Expenseid, expense);
    }

    public Expense getExpenseById(UUID Expenseid) {

        return expensedao.getExpenseById(Expenseid);
    }

    public List<Expense> getAllExpense() {

        return expensedao.selectAllExpense();
    }

    public int deleteExpenseById(UUID Expenseid) {

        return expensedao.deleteExpenseById(Expenseid);
    }

   int deleteAllExpenses() {
        return 1;
   };

    public int updateExpenseById(UUID id, Expense expense) {
        return 1;
    }
    public List<Expense> getExpensesByCategory(String category) {

        // Step 1: get ALL expenses from storage
        List<Expense> allExpenses = expensedao.selectAllExpense();

        // Step 2: create an empty list to hold the matches
        List<Expense> result = new ArrayList<>();

        // Step 3: loop through every expense
        for (Expense expense : allExpenses) {

            // Step 4: does this expense's category match what we're looking for?
            if (expense.getCategory().equalsIgnoreCase(category)) {

                // Step 5: yes — add it to our result list
                result.add(expense);
            }
        }

        // Step 6: return the filtered list
        return result;
    }


}

