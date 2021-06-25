package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Approval;
import com.revature.models.Author;
import com.revature.models.Employee;
import com.revature.models.Status;
import com.revature.models.Story;
import com.revature.services.ApprovalService;
import com.revature.services.ApprovalServiceImpl;
import com.revature.services.AuthorService;
import com.revature.services.AuthorServiceImpl;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.StoryService;
import com.revature.services.StoryServiceImpl;
import com.revature.services.StoryStatusService;
import com.revature.services.StoryStatusServiceImpl;

public class FrontControllerServlet extends HttpServlet {

	class AuthorCred {
		public String user;
		public String pass;
	}

	class EmployeeCred {
		public String user;
		public String pass;

	}

	class tempApp {
		public String approval_status;
		public Integer number_of_approves;
		public Integer status_id;

		public tempApp(String approval_status, Integer number_of_approves, Integer status_id) {
			super();
			this.approval_status = approval_status;
			this.number_of_approves = number_of_approves;
			this.status_id = status_id;
		}

		@Override
		public String toString() {
			return "tempApp [approval_status=" + approval_status + ", number_of_approves=" + number_of_approves
					+ ", story_status_id=" + status_id + "]";
		}

	}

	private AuthorService auths = new AuthorServiceImpl();
	private ApprovalService apps = new ApprovalServiceImpl();
	private EmployeeService emps = new EmployeeServiceImpl();
	private StoryStatusService stats = new StoryStatusServiceImpl();
	private StoryService storys = new StoryServiceImpl();
	private Gson gson = new Gson();
	public static HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, IllegalStateException, JsonSyntaxException {

		String uri = request.getRequestURI();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");

		session = request.getSession();

		uri = uri.substring("/Project1/controller/".length());

		switch (uri) {

		case "author-screen": {
			System.out.println("Author Screen loading");
			Author alogg = (Author) session.getAttribute("logged_in");
			Author loggedAuthor = auths.getAuthorById(alogg.getId());
			System.out.println(loggedAuthor + "poop");
			response.getWriter().append(gson.toJson(loggedAuthor));
			System.out.println("Sent author object to front end");
			break;
		}

		case "employee-screen": {
			Employee emlog = (Employee) session.getAttribute("logged_in");
			Employee loggedEmployee = emps.getEmployee(emlog.getId());
			System.out.println(loggedEmployee);
			response.getWriter().append(gson.toJson(loggedEmployee));
			System.out.println("Sent employee object to front end");
			break;
		}

		case "all-employees": {
			response.getWriter().append(gson.toJson(emps.getAllEmployees()));
			System.out.println("Sending all the employees");
			break;
		}

		case "home": {
			response.getWriter().append("AuthorLogin.html");
			break;
		}

		case "logout": {
			System.out.println("Logging out");
			session.invalidate();
			break;
		}

		default: {
			System.out.println("Reached the default case...");
			response.sendError(418, "BRB MAKING TEA");
			break;
		}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String uri = req.getRequestURI();

		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Content-Type", "application/json");

		session = req.getSession();

		uri = uri.substring("/Project1/controller/".length());

		switch (uri) {

		case "author-login": {
			System.out.println("Recieved author login!");
			System.out.println(req.getReader());
			AuthorCred ac = gson.fromJson(req.getReader(), AuthorCred.class);
			System.out.println(ac);
			Author a = auths.getAuthor(ac.user, ac.pass);
			if (a != null) {
				session.setAttribute("logged_in", a);
				res.getWriter().append("AuthorScreen.html");
				System.out.println("Author log-in good");
			} else {
				System.out.println("Failed to login");
			}
			break;
		}

		case "employee-login": {
			EmployeeCred ec = gson.fromJson(req.getReader(), EmployeeCred.class);
			System.out.println(ec);
			Employee em = emps.getEmployee(ec.user, ec.pass);
			if (em != null) {
				session.setAttribute("logged_in", em);
				res.getWriter().append("EmployeeScreen.html");
				System.out.println("Employee log in good");
			} else {
				System.out.println("Failed to login");
			}
			break;
		}

		case "add-story": {
			Story story = gson.fromJson(req.getReader(), Story.class);
			Author authlogg = (Author) session.getAttribute("logged_in");
			System.out.println(story + "stuff");
			Story addedStory = storys.add(story, authlogg.getId());
			emps.addEmployeeToStory(addedStory);
			break;
		}

		case "update-author": {
			Author author = gson.fromJson(req.getReader(), Author.class);
			System.out.println(author);
			auths.updateAuthor(author);
			break;
		}

		case "update-employee": {
			Employee emp = gson.fromJson(req.getReader(), Employee.class);
			System.out.println(emp);
			emps.updateEmployee(emp);
			break;
		}

		case "update-story": {
			Story story = gson.fromJson(req.getReader(), Story.class);
			System.out.println(story);
			storys.updateStory(story);
			break;
		}

		case "update-status": {
			Status status = gson.fromJson(req.getReader(), Status.class);
			System.out.println(status);
			stats.updateStatus(status);
			break;
		}

		case "add-approval": {
			tempApp tApp = gson.fromJson(req.getReader(), tempApp.class);
			System.out.println(tApp + "hi");
			Approval zApp = new Approval();
			zApp.setApproval_status("committee");
			zApp.setNumber_of_approves(1);
			apps.addApproval(zApp, tApp.status_id);
			break;
		}

		case "update-approval": {
			Approval app = gson.fromJson(req.getReader(), Approval.class);
			System.out.println(app);
			apps.updateApproval(app);
			break;
		}
		default: {
			System.out.println("Reached the default case in post...");
			res.sendError(418, "BRB MAKING TEA");
			break;
		}

		}
	}
}
