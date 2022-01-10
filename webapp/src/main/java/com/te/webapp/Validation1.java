package com.te.webapp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Validation1")
public class Validation1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parameter = request.getParameter("uname");
		String parameter2 = request.getParameter("pass");
		PrintWriter writer = response.getWriter();
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("team");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		//String query = "select uname from crud where uname=:uname and pass=:pass";
		Query createQuery = createEntityManager.createQuery("select uname from Crud where uname=:uname and pass=:pass");
		createQuery.setParameter("uname", parameter);
		createQuery.setParameter("pass", parameter2);
		Object singleResult;
		// request.getRequestDispatcher("/Invalid");// add then another class here
		try {
			singleResult = createQuery.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			singleResult = null;
		}
		if (singleResult == null) {
			writer.println("invalid");
		} else {
			writer.println("<h1>Welcome user<h1>");
		}
		transaction.commit();
	}

}
