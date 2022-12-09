package Service;

import dao.DepartmentDAO;
import dao.StaffDepartmentDAO;
import model.Department;
import model.Staff;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StaffServiceImpl implements ICoreCRUDService {


    private final StaffDepartmentDAO staffDepartmentDAO;
    private final DepartmentDAO departmentDAO;

    public StaffServiceImpl() {
        this.staffDepartmentDAO = new StaffDepartmentDAO();
        this.departmentDAO = new DepartmentDAO();
    }

    @Override
    public List<Staff> findAll(HttpServletRequest request) {
        return staffDepartmentDAO.findAll();
    }

    public List<Department> findDepartment() {
        return departmentDAO.findAll();
    }

    @Override
    public Staff findById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return staffDepartmentDAO.findStaffById(id);
    }

    @Override
    public boolean save(HttpServletRequest request) {
        String staffId = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        Long departmentId = Long.parseLong(request.getParameter("department"));
        if (staffId == null) {
            return staffDepartmentDAO.createStaff(new Staff(name, email,
                    address, phonenumber, salary, departmentDAO.findDepartmentById(departmentId)));
        }
        return staffDepartmentDAO.updateStaff(new Staff(Long.parseLong(staffId),name, email,
                address, phonenumber, salary, departmentDAO.findDepartmentById(departmentId)));
    }

    @Override
    public boolean deleteById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return staffDepartmentDAO.deleteStaff(id);
    }

    public List<Staff> findByNameContaining(HttpServletRequest request) {
        String name = request.getParameter("search");
        return staffDepartmentDAO.findAllByName(name);
    }
}
