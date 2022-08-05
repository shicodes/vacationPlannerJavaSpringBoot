package com.springframework.springboot.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String startDate;
    private String emailID;
    private String positionTitle;
    private Long managerID;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private Set<Vacation> vacations = new HashSet<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName, String startDate, String emailID, String positionTitle, Long managerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.emailID = emailID;
        this.positionTitle = positionTitle;
        this.managerID = managerID;
    }

    public Long getEmployeeID() {
        return id;
    }

    public void setEmployeeID(Long employeeID) {
        this.id = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public Long getManagerID() {
        return managerID;
    }

    public void setManagerID(Long managerID) {
        this.managerID = managerID;
    }

    public Set<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(Set<Vacation> vacations) {
        this.vacations = vacations;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", emailID='" + emailID + '\'' +
                ", positionTitle='" + positionTitle + '\'' +
                ", managerID=" + managerID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id != null ? id.equals(employee.id) : employee.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

