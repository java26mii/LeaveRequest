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
import models.LeaveRequest;
import models.LeaveType;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class LeaveRequestController implements ILeaveRequestController {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    private GeneralDAO<LeaveRequest> gdao;

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
    public String save(String id, String startDate, String endDate, String type, String notes, String requester, String manager, String status) {
        String result = "";
//        LeaveRequest leaveRequest = new LeaveRequest(new Long(id), date, date, new LeaveType(new Long(type)) , detail, requester, 0, status) ;
//        if (gdao.saveOrDelete(leaveRequest, false)) {
//            result = "Success";
//        } else {
//            result = "Failed";
//        }
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
