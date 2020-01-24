package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.EmployeeDto;
import com.happytravel.happytravel.api.model.Employee;
import com.happytravel.happytravel.api.service.EmployeeService;
import com.happytravel.happytravel.api.transformer.EmployeeTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class EmployeeController {

    private final EmployeeService employeeService;
    //Builder raportu o ilości pracowników w danym biurze
    interface Builder{
        public void create();
        public void setAttributes(String type, Long quantity);
        public EmployeeByType returnProduct(String type, Long quantity);
    }
    class EmployeeByType{
        private String type;
        private Long quantity;
        public void set(String type, Long quantity){
            this.type = type;
            this.quantity = quantity;
        }
        @Override
        public String toString(){
            return "\""+type+"\": "+quantity;
        }
    }
    class BuilderImpl implements Builder{
        private EmployeeByType count;
        public void create(){
            this.count = new EmployeeByType();
        }
        public void setAttributes(String type, Long quantity){
            count.set(type, quantity);
        }
        public EmployeeByType returnProduct(String type, Long quantity){
            this.create();
            this.setAttributes(type, quantity);
            return count;
        }
    }
    //Koniec buildera
    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> getEmployees() {
        List<Employee> employee = employeeService.getEmployees();
        return employee.stream().map(EmployeeTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/getEmployee")
    public EmployeeDto getEmployee(@RequestParam Long id){
        Employee employee = employeeService.getEmployee(id);
        return EmployeeTransformer.convertToDto(employee);
    }
    @GetMapping("/countEmployees")
    public String countEmployees(@RequestParam Long officeID){
        BuilderImpl b = new BuilderImpl();
        String json = "{"+b.returnProduct("salesmen", employeeService.countEmployeesOnPosition("Sprzedawca", officeID)).toString() + ", " +
                        b.returnProduct("guides", employeeService.countEmployeesOnPosition("Sprzedawca", officeID)).toString() + ", " +
                        b.returnProduct("managers", employeeService.countEmployeesOnPosition("Kierownik", officeID)).toString()+"}";
        return json;
    }
}