/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IEmployeeController;
import java.util.List;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class EmployeeController implements IEmployeeController {

    private GeneralDAO<Employee> gdao;

    public EmployeeController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        return gdao.getData("");
    }

    @Override
    public Employee getById(String id) {
        return gdao.getById(new Long(id));
    }

    @Override
    public List<Employee> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String firstName, String lastName, String email, String phoneNumber, String manager) {
        String result = "";
        Employee employee = new Employee(new Long(id), firstName, lastName, email, new Long(phoneNumber), new Employee(new Long(manager)));
        if (gdao.saveOrDelete(employee, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Employee employee = new Employee(new Long(id));
        if (gdao.saveOrDelete(employee, true)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

}
