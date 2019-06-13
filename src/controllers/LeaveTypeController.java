/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.ILeaveTypeController;
import java.util.List;
import models.LeaveType;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class LeaveTypeController implements ILeaveTypeController {

    private GeneralDAO<LeaveType> gdao;

    public LeaveTypeController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, LeaveType.class);
    }

    @Override
    public List<LeaveType> getAll() {
        return gdao.getData("");
    }

    @Override
    public LeaveType getById(String id) {
        return gdao.getById(new Long(id));
    }

    @Override
    public List<LeaveType> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String name) {
        String result = "";
        LeaveType leaveType = new LeaveType(new Long(id), name);
        if (gdao.saveOrDelete(leaveType, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        LeaveType leaveType = new LeaveType(new Long(id));
        if (gdao.saveOrDelete(leaveType, true)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

}
