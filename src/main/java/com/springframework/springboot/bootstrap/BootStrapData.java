package com.springframework.springboot.bootstrap;

import com.springframework.springboot.domain.Employee;
import com.springframework.springboot.domain.Vacation;
import com.springframework.springboot.repositories.EmployeeRepository;
import com.springframework.springboot.repositories.VacationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final VacationRepository vacationRepository;

    public BootStrapData(EmployeeRepository employeeRepository, VacationRepository vacationRepository) {
        this.employeeRepository = employeeRepository;
        this.vacationRepository = vacationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Employee jane = new Employee();
        jane.setFirstName("Jane");
        jane.setLastName("Doe");
        jane.setStartDate("2021-07-21 00:00:00");
        jane.setEmailID("Jane.Doe@rci.rogers.com");
        jane.setPositionTitle("OSS Technical Expert");
        jane.setManagerID((long)2);

        Employee john = new Employee();
        john.setFirstName("John");
        john.setLastName("Smith");
        john.setStartDate("2022-07-13 00:00:00");
        john.setEmailID("John.Smith@rci.rogers.com");
        john.setPositionTitle("Software Developer");
        john.setManagerID((long)2);

        employeeRepository.save(jane);
        employeeRepository.save(john);

        System.out.println("Created Employee Jane");
        System.out.println("Created Employee John");


        //Employee jane = new Employee("Jane", "Doe", "2021-07-21 00:00:00", "Jane.Doe@rci.rogers.com", "OSS Technical Expert", (long) 2);
        Vacation jane_v1 = new Vacation("Floater", "2022-07-25 00:00:00", "2022-07-25 23:59:59", "Approved");
        Vacation john_v1 = new Vacation("Floater", "2022-07-25 00:00:00", "2022-07-29 23:59:59", "Pending");

        vacationRepository.save(jane_v1);
        vacationRepository.save(john_v1);

        jane_v1.setEmployee(jane);
        jane.getVacations().add(jane_v1);

        john_v1.setEmployee(john);
        john.getVacations().add(john_v1);

        employeeRepository.save(jane);
        vacationRepository.save(jane_v1);

        employeeRepository.save(john);
        vacationRepository.save(john_v1);

        System.out.println("Number of Employees: "+ employeeRepository.count());
        //System.out.println("Employee Number of Vacations: "+ jane.getVacations().size());

    }
}