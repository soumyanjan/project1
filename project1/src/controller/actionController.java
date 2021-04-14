package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.User;
import project1.connectorClass;

@WebServlet("/actionController")
public class actionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		case "listusers":
			listUsers(request, response);
			break;
		case "adduser":
			addUserFormLoader(request, response);
			break;
		case "updateuser":
			UpdateUserFormLoader(request, response);
			break;
		case "deleteuser":	
			 int j =Integer.parseInt(request.getParameter("regId"));
		     deleteuser(j);
		     listUsers(request, response);
		     break;
		default:
			errorPage(request, response);
		}

	}

	private void deleteuser(int Id) {
		new connectorClass().deleteUser(Id);
		return;
	}

	private void UpdateUserFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update User");
		try {
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		switch (operation) {
		case "adduseroperation":
			User newUser = new User(request.getParameter("name"), request.getParameter("subject"));
			addUserOperation(newUser);
			listUsers(request, response);
			break;
		case "updateuseroperation":
			User updatedUser = new User(Integer.parseInt(request.getParameter("regId")),
					request.getParameter("name"), request.getParameter("subject"));
			updateUserOperation( updatedUser);
			listUsers(request, response);
			break;
		default:
			errorPage(request, response);
			break;
		}
	}

	private void updateUserOperation( User updateduser) {
		new connectorClass().updateUser(updateduser);
		return;
		
	}

	private void addUserOperation(User newUser) {
		new connectorClass().addUser(newUser);
		return;
		}

	public void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUsers = new ArrayList<>();
		listUsers = new connectorClass().listUsers();
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("title", "List of users");
		request.getRequestDispatcher("listUser.jsp").forward(request, response);

	}

	public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Add User");
		request.getRequestDispatcher("addUser.jsp").forward(request, response);

	}

	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);

	}
}

	
	
	
	
	

