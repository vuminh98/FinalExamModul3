package controller;

import Service.StaffServiceImpl;
import model.Department;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffDepartmentServlet", value = "/staffs")
public class StaffDepartmentServlet extends HttpServlet {

    private StaffServiceImpl staffService;

    public void init() {
        staffService = new StaffServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "detail":
                displayDetailStaff(request, response);
                break;
            case "create":
                createForm(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                displayListStaff(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "search":
                displaySearchStaffList(request, response);
                break;
        }
    }

    private void displayListStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/list.jsp");
        request.setAttribute("staffs", staffService.findAll(request));
        requestDispatcher.forward(request, response);
    }

    private void displayDetailStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/detail.jsp");
        request.setAttribute("staffs", staffService.findById(request));
        requestDispatcher.forward(request, response);
    }

    private void displaySearchStaffList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/list.jsp");
        request.setAttribute("staffs", staffService.findByNameContaining(request));
        requestDispatcher.forward(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = staffService.findDepartment();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/create1.jsp");
        request.setAttribute("departments", departments);
        requestDispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        staffService.save(request);
        response.sendRedirect("http://localhost:8080/staffs");
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("staff/update1.jsp");
        request.setAttribute("staffs", staffService.findById(request));
        request.setAttribute("departments", staffService.findDepartment());
        requestDispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        staffService.save(request);
        response.sendRedirect("http://localhost:8080/staffs");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        staffService.deleteById(request);
        response.sendRedirect("http://localhost:8080/staffs");
    }
}
