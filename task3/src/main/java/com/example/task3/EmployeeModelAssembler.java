//package com.example.task3;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//
//import com.example.task3.model.Employee;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.RepresentationModelAssembler;
//import org.springframework.stereotype.Component;
//
//@Component
//class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {
//
//    @Override
//    public EntityModel<Employee> toModel(Employee employee) {
//
//        return EntityModel.of(employee, //
//                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
//                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
//    }
//}