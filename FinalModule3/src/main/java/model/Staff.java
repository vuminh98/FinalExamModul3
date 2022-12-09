package model;

public class Staff {
    private Long id;
    private String Name;
    private String Email;
    private String Address;
    private String PhoneNumber;
    private Double salary;
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Staff(Long id, String name, String email, String address, String phoneNumber, Double salary, Department department) {
        this.id = id;
        Name = name;
        Email = email;
        Address = address;
        PhoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }



    public Staff(String name, String email, String address, String phoneNumber, Double salary, Department department) {
        Name = name;
        Email = email;
        Address = address;
        PhoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
