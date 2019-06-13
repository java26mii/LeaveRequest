/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IEmployeeRoleController;
import java.util.List;
import models.Employee;
import models.EmployeeRole;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasaari
 */
public class EmployeeRoleController implements IEmployeeRoleController {

    private GeneralDAO<EmployeeRole> gdao;

    public EmployeeRoleController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, EmployeeRole.class);
    }

    @Override
    public List<EmployeeRole> getAll() {
        return gdao.getData("");
    }

    @Override
    public EmployeeRole getById(String id) {
        return gdao.getById(new Long(id));
    }

    @Override
    public List<EmployeeRole> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String role, String employee) {
        String result = "";
        EmployeeRole employeeRole = new EmployeeRole(new Long(id), new Role(new Long(role)), new Employee(new Long(employee)));
        if (gdao.saveOrDelete(employeeRole, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        EmployeeRole employeeRole = new EmployeeRole(new Long(id));
        if (gdao.saveOrDelete(employeeRole, true)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

}
