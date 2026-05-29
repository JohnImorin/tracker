package dao;

import model.Expense;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("realdao")

public class ExpenseRealdao implements ExpenseDao {


    private final Map<UUID, Expense> Expensedao;

    public ExpenseRealdao() {
        this.Expensedao = new HashMap<>();
    }

    @Override
    public int insertNewExpense(UUID Expenseid, Expense expense) {
        Expensedao.put(Expenseid, expense);
        return 1;
    }

    @Override
    public Expense getExpenseById(UUID Expenseid) {

        return Expensedao.get(Expenseid);
    }

    @Override
    public List<Expense> selectAllExpense() {

        return new ArrayList<>(Expensedao.values());
    }


    @Override
    public int updateExpensebyID(UUID Expenseid, Expense expense) {
       Expensedao.put(Expenseid,expense);
        return 1;
    }


    @Override
    public int deleteExpenseById(UUID Expenseid) {
        Expensedao.remove(Expenseid);
        return 1;
    }

    @Override
    public List<Expense> deleteExpense() {
        return new ArrayList<>(Expensedao.values());
    }
}
