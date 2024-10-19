package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Person;

public class PersonDepartmentDTO {

    private Long id;
    private String name;
    private Double salary;
    private DepartmentDTO department;

    public PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public PersonDepartmentDTO(Person entityPerson) {
        this.id = entityPerson.getId();
        this.name = entityPerson.getName();
        this.salary = entityPerson.getSalary();
        this.department = new DepartmentDTO(entityPerson.getDepartment());
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public DepartmentDTO getDepartmentDTO() {
        return department;
    }
}
