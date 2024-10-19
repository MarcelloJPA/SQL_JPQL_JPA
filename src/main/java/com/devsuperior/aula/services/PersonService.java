package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public PersonDepartmentDTO insert(PersonDepartmentDTO personDepartmentDTO){
           Person personEntity = new Person();
           personEntity.setName(personDepartmentDTO.getName());
           personEntity.setSalary(personDepartmentDTO.getSalary());

           Department dept = departmentRepository.getReferenceById(personDepartmentDTO.getDepartmentDTO().getId());
           //Department department = new Department();
           //department.setId(personDepartmentDTO.getDepartmentDTO().getId());

           personEntity.setDepartment(dept);

           personEntity =  personRepository.save(personEntity);

            /*Agora reconverter para DTO*/
           return new PersonDepartmentDTO(personEntity);
    }

    public PersonDTO insert(PersonDTO personDTO){
        Person personEntity = new Person();
        personEntity.setName(personDTO.getName());
        personEntity.setSalary(personDTO.getSalary());

        Department dept = departmentRepository.getReferenceById(personDTO.getDepartmentId());
        //Department department = new Department();
        //department.setId(personDepartmentDTO.getDepartmentDTO().getId());

        personEntity.setDepartment(dept);

        personEntity =  personRepository.save(personEntity);

        /*Agora reconverter para DTO*/
        return new PersonDTO(personEntity);
    }


}
