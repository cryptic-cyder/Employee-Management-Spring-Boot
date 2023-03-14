package com.example.employee.controller;


import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

   @Autowired
   private EmployeeService employeeService;

   //Show portion
   @GetMapping("/showEmployee")
   public ModelAndView showEmployee(){
       ModelAndView modelAndView = new ModelAndView("show-list-html");
       List<Employee> employeeList = employeeService.showEmployee();
       modelAndView.addObject("showEmployee", employeeList);
       return modelAndView;
   }

   //Add portion
   @GetMapping("/addEmployeeForm")
   public ModelAndView AddEmployeeForm(){
       ModelAndView modelAndView = new ModelAndView("add-employee-form");

       Employee employee = new Employee();
       modelAndView.addObject("addEmployee", employee);
       return modelAndView;
   }

   @PostMapping("/saveEmployee")
   public String saveEmployee(@ModelAttribute Employee employee){
       employeeService.saveEmployee(employee);
       return "redirect:/showEmployee";
   }

   //Update portion
   @GetMapping("/employee/{id}")
   public ModelAndView fetchEmployeeById(@PathVariable Long id){
       Employee existEmployee = employeeService.getEmployeeById(id);
       ModelAndView modelAndView = new ModelAndView("add-employee-form");
       modelAndView.addObject("addEmployee", existEmployee);
       return modelAndView;
   }

   //Delete portion
    @GetMapping("/employeeDelete/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
       employeeService.deleteEmployeeById(id);
        return "redirect:/showEmployee";
    }



}
