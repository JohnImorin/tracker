package controller;

import model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.ExpenseService;
import java.util.List; //
import java.util.UUID;


@RestController
@RequestMapping("api/v1/expense")

public class ExpenseController {


    public final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpense() {
        return expenseService.getAllExpense();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable UUID id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping
    public String addExpense(@RequestBody Expense expense) {
        UUID id = UUID.randomUUID();
        int result = expenseService.persistNewExpense(id, expense);
        if (result == 1) return "Expense added successfully";
        return "Failed to add expense";
    }

    @PutMapping("/{id}")
    public String updateExpense(@PathVariable UUID id,
                                @RequestBody Expense expense) {
        int result = expenseService.updateExpenseById(id, expense);
        if (result == 1) return "Expense updated successfully";
        return "Expense not found";
    }
    @DeleteMapping("/{id}")
    public String deleteExpenseById(@PathVariable UUID id) {
        int result = expenseService.deleteExpenseById(id);
        if (result == 1) return "Expense deleted successfully";
        return "Expense not found";
    }

    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category) {
        return expenseService.getExpensesByCategory(category);
    }


}
