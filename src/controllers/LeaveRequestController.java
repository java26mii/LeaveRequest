/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.ILeaveRequestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Employee;
import models.LeaveRequest;
import models.LeaveType;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class LeaveRequestController implements ILeaveRequestController {

    private GeneralDAO<LeaveRequest> gdao;
    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public LeaveRequestController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, LeaveRequest.class);
    }

    @Override
    public List<LeaveRequest> getAll() {
        return gdao.getData("");
    }

    @Override
    public LeaveRequest getById(String id) {
        return gdao.getById(new Long(id));
    }

    @Override
    public List<LeaveRequest> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String startDate, String endDate, String notes, String requester, String type) {
        String result = "Failed";
        try {
            if (gdao.saveOrDelete(new LeaveRequest(new Long (id), new java.sql.Date(formatter.parse(startDate).getTime()), new java.sql.Date(formatter.parse(endDate).getTime()), notes, new Employee(new Long (requester)) , new LeaveType(new Long (type)), new Character('0')), false)) {
                result = "Success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    @Override
    public String saveLr(String startDate, String endDate, String notes, String requester, String type) {
        String result = "Failed";
        try {
            if (gdao.saveOrDelete(new LeaveRequest(new java.sql.Date(formatter.parse(startDate).getTime()), new java.sql.Date(formatter.parse(endDate).getTime()), notes, new Employee(new Long (requester)) , new LeaveType(new Long (type)), new Character('0')), false)) {
                result = "Success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    @Override
    public String delete(String id) {
        String result = "";
        LeaveRequest leaveRequest = new LeaveRequest(new Long(id));
        if (gdao.saveOrDelete(leaveRequest, true)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }
}
