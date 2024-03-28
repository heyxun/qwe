package com.smart.water.controller;

import com.smart.water.domain.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Api(tags = "雇员管理")
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    static Map<Long, Employee> emps = Collections.synchronizedMap(new HashMap<Long, Employee>());
    public EmployeeController(){
        emps.put(112345678L ,new Employee(112345678L,21,"Jackson","j123456789","sdfjkl",1000.00));
        emps.put(45632189L, new Employee(45632189L,21,"黑Heyxn","h123456789","fdbxcv",2000.00));
    }
//    //处理“/employee/”的get请求，用来获取所有雇员用户组成的集合
//    @ResponseBody
//    @GetMapping("/")
//    public List<Employee> getEmployeeList(){
//        List<Employee> r = new ArrayList<>(emps.values());
//        return r;
//    }
//
//    @ResponseBody
//    @PostMapping("/")
//    public String postEmployee(Employee emp){
//        emps.put(emp.getId(), emp);
//        return "success";
//    }
//
//    //获取单个emp对象
//    @ResponseBody
//    @GetMapping("/{id}")
//    public Employee getEmployee(@PathVariable Long id){
//        return emps.get(id);
//    }
//
//    @ResponseBody
//    @PutMapping("/{id}")
//    public String putEmployee(@RequestParam Long id,@RequestBody Employee emp){
//        Employee e = emps.get(id);
//        e.setName(emp.getName());
//        e.setAge(emp.getAge());
//        emps.put(id, e);
//        return "success";
//    }
//
//    @ResponseBody
//    @GetMapping("")
//    public String addEmployee(@RequestParam Long id,@RequestParam String name,@RequestParam int age){
//        Employee e = Employee.builder()
//                .id(id)
//                .name(name)
//                .age(age)
//                .build();
//        emps.put(id, e);
//        return "success";
//    }
//
//    @ResponseBody
//    @DeleteMapping("/{id}")
//    public String delEmployee(@RequestParam Long id){
//        emps.remove(id);
//        return "success";
//    }

    @ApiOperation(value = "显示所有雇员信息", notes = "传递实体类")
    @GetMapping(value = "All")
    public String allEmployee(Model m){
        List<Employee> r = new ArrayList<>(emps.values());
        m.addAttribute("employee",r);
        System.out.println("all————————————————————————————>"+r);
        return "test/EmployeeAll";
    }

    @ApiOperation(value = "显示个人雇员信息", notes = "传递实体类")
    @GetMapping("/Info/{id}")
    public String getInfoEmployee(@PathVariable Long id, Model model) {
        Employee employee = emps.get(id);
        model.addAttribute("employee", employee);
        System.out.println("get info——————————————————————————————>"+employee);
        return "test/EmployeeInfo";
    }

    @ApiOperation(value = "添加雇员信息但get", notes = "传递实体类")
    @GetMapping("/Add")
    public String employeeAdd(Model model) {
        //绑定页面中的th：object
        model.addAttribute("employee", new Employee());
        return "test/EmployeeAdd";
    }

    @ApiOperation(value = "添加雇员信息但post", notes = "传递实体类")
    @PostMapping("/Add")
    public String addEmployee(@ModelAttribute Employee employee) {
        emps.put(employee.getId(),employee);
        System.out.println("add——————————————————————————>"+emps.values());
        return "test/EmployeeAdd"; // Redirect to all employees page after adding
    }

    @GetMapping(value = "helloEmployee")
    public String helloEmployee(Model model){
        //model.addAttribute("name","Dear");
        Employee employee = Employee.builder()
                .id(1123456789012L)
                .age(21)
                .name("Jackson")
                .build();
        model.addAttribute("employee",employee);
        model.addAttribute("html","<p>你好</p>");
        model.addAttribute("msg","扬大");
        System.out.println("------>>>>index.html accessing.......");
        return "test/helloEmployee";
    }
}
