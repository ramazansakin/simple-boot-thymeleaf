package com.sakinramazan.thymeleaf.controller;

import com.sakinramazan.thymeleaf.domain.Employee;
import com.sakinramazan.thymeleaf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.sakinramazan.thymeleaf.constants.Constants.*;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public String savePage(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("allEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee,
                               final RedirectAttributes redirectAttributes) {
        if (employeeService.saveEmployee(employee) != null) {
            redirectAttributes.addFlashAttribute("saveEmployee", SUCCESS);
        } else {
            redirectAttributes.addFlashAttribute("saveEmployee", FAILED);
        }
        return REDIRECT;
    }

    @GetMapping("/new-employee")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee) {
        return "addEmployee";
    }

    @GetMapping("/employee/{operation}/{empId}")
    public String editRemoveEmployee(@PathVariable("operation") String operation,
                                     @PathVariable("empId") Long empId,
                                     final RedirectAttributes redirectAttributes,
                                     Model model) {
        if (operation.equals("delete")) {
            if (employeeService.deleteEmployee(empId)) {
                redirectAttributes.addFlashAttribute("deletion", SUCCESS);
            } else {
                redirectAttributes.addFlashAttribute("deletion", FAILED);
            }
        } else if (operation.equals("edit")) {
            Employee editEmployee = employeeService.findEmployee(empId);
            if (editEmployee != null) {
                model.addAttribute("editEmployee", editEmployee);
                return "editPage";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return REDIRECT;
    }

    @PostMapping("/employee/update")
    public String updateEmployee(@ModelAttribute("editEmployee") Employee editEmployee,
                                 final RedirectAttributes redirectAttributes) {
        if (employeeService.editEmployee(editEmployee) != null) {
            redirectAttributes.addFlashAttribute("edit", SUCCESS);
        } else {
            redirectAttributes.addFlashAttribute("edit", FAILED);
        }
        return REDIRECT;
    }
}