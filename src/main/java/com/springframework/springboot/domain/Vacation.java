package com.springframework.springboot.domain;

import javax.persistence.*;

@Entity
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vacationId;

    private String vacationType;
    private String vacationStart;
    private String vacationEnd;
    private String status;

    @ManyToOne
    private Employee employee;

    public Vacation() {
    }

    public Vacation(String vacationType, String vacationStart, String vacationEnd, String status) {
        this.vacationType = vacationType;
        this.vacationStart = vacationStart;
        this.vacationEnd = vacationEnd;
        this.status = status;
    }

    public Long getVacationId() {
        return vacationId;
    }

    public void setVacationId(Long vacationId) {
        this.vacationId = vacationId;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public String getVacationStart() {
        return vacationStart;
    }

    public void setVacationStart(String vacationStart) {
        this.vacationStart = vacationStart;
    }

    public String getVacationEnd() {
        return vacationEnd;
    }

    public void setVacationEnd(String vacationEnd) {
        this.vacationEnd = vacationEnd;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "vacationId=" + vacationId +
                ", vacationType='" + vacationType + '\'' +
                ", vacationStart='" + vacationStart + '\'' +
                ", vacationEnd='" + vacationEnd + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacation vacation = (Vacation) o;

        return vacationId != null ? vacationId.equals(vacation.vacationId) : vacation.vacationId == null;
    }

    @Override
    public int hashCode() {
        return vacationId != null ? vacationId.hashCode() : 0;
    }
}

