package Controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExpenseDao;
import daoImpl.ExpenseDaoImpl;
import pojo.ExpenseDetails;

public class ExpenseController extends HttpServlet {

		ExpenseDetails Expense = new ExpenseDetails();
        ExpenseDaoImpl ExpenseDaoImpl = new ExpenseDaoImpl();
        ExpenseDao edao;
       
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addExpense")!=null){
            String ename = request.getParameter("ename");
            String edesc = request.getParameter("edesc");
            int eprice = Integer.parseInt(request.getParameter("eprice"));
            Expense.setEname(ename);
            Expense.setEdesc(edesc);
            Expense.setEprice(eprice);
            Date edate = new Date();
            Expense.setEdate(edate);
            ExpenseDaoImpl.saveExpense(Expense);
            List<ExpenseDetails> ExpenseList = new ArrayList();
            ExpenseList = ExpenseDaoImpl.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
        }
          
        if(request.getParameter("showInfo")!=null){
        	 int id1 = Integer.parseInt(request.getParameter("id"));
           ExpenseDetails expense = ExpenseDaoImpl.showOneExpense(id1);
           request.setAttribute("record", expense);
            List<ExpenseDetails> ExpenseList = new ArrayList();
            ExpenseList = ExpenseDaoImpl.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("showExpense")!=null){
            List<ExpenseDetails> ExpenseList = new ArrayList();
            ExpenseList = ExpenseDaoImpl.showAllExpenses();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
        }
         
          if(request.getParameter("updateExpense")!=null){
             int id1 = Integer.parseInt(request.getParameter("id"));
//             ExpenseDetails expense = ExpenseDaoImpl.showOneExpense(id1);
//             request.setAttribute("record", expense);
//             String enameupdate = request.getParameter("enameupdate");
             String enameupdate = request.getParameter("enameupdate");
             String edescupdate = request.getParameter("edescupdate");
             int epriceupdate = Integer.parseInt(request.getParameter("epriceupdate"));
             Date edateupdate = new Date();
             ExpenseDaoImpl.updateExpense(id1, enameupdate, edescupdate, epriceupdate , edateupdate);
             List<ExpenseDetails> ExpenseList = new ArrayList();
             ExpenseList = ExpenseDaoImpl.showAllExpenses();
             request.setAttribute("ExpenseList", ExpenseList);
             RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
             rd.forward(request, response);
             
         }
          
         if(request.getParameter("deleteExpense")!=null){
             int id2 = Integer.parseInt(request.getParameter("id"));
             Expense.setId(id2);
             ExpenseDaoImpl.deleteExpense(Expense);
             List<ExpenseDetails> ExpenseList = new ArrayList();
             ExpenseList = ExpenseDaoImpl.showAllExpenses();
             request.setAttribute("ExpenseList", ExpenseList);
             RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
         }
         
      
      
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
