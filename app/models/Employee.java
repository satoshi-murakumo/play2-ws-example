package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import play.db.ebean.Model;

/**
 * 社員エンティティ。
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Employee extends Model {

    @Id
    public Long employeeId;

    public String employeeName;

    public Date hiredate;

    public BigDecimal salary;

    @Version
    public Long versionNo;

    // -- Queries
    public static Model.Finder<Long, Employee> find = new Model.Finder<Long, Employee>(Long.class, Employee.class);

    public String toString() {
        return "Employee ["
            + "employeeId=" + employeeId
            + ", employeeName=" + employeeName
            + ", hiredate=" + hiredate
            + ", salary=" + salary
            + ", versionNo=" + versionNo + "]";
    }
}
