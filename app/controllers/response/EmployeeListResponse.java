package controllers.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import models.Employee;

@XmlRootElement(name = "employees")
public class EmployeeListResponse {

    EmployeeResponse[] employees;

    @XmlElement(name = "employee")
    public EmployeeResponse[] getEmployees() {
        return employees;
    }

    public static EmployeeListResponse from(List<Employee> employees) {
        EmployeeListResponse ret = new EmployeeListResponse();
        ret.employees = new EmployeeResponse[employees.size()];
        for (int i = 0; i < ret.employees.length; i++) {
            ret.employees[i] = EmployeeResponse.from(employees.get(i));
        }
        return ret;
    }
}
