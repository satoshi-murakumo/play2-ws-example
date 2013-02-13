package controllers.response;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import models.Employee;

@XmlRootElement(name = "employee")
public class EmployeeResponse {

    Long employeeId;

    String employeeName;

    Date hiredate;

    BigDecimal salary;

    Long versionNo;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Long getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    public static EmployeeResponse from(Employee employee) {
        EmployeeResponse ret = new EmployeeResponse();
        ret.employeeId = employee.employeeId;
        ret.employeeName = employee.employeeName;
        ret.hiredate = employee.hiredate;
        ret.salary = employee.salary;
        return ret;
    }

}
