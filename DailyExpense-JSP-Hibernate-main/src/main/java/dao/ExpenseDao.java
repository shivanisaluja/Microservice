package dao;

import java.util.Date;
import java.util.List;

import pojo.ExpenseDetails;

public interface ExpenseDao {
    
    public void saveExpense (ExpenseDetails Expense);
    public List<ExpenseDetails> showAllExpenses();
    public void updateExpense (int id, String ename, String edesc , int eprice , Date edate);
    public void deleteExpense (ExpenseDetails Expense);
	public ExpenseDetails showOneExpense(int id);
    
    
}
