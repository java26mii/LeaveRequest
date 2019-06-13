/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.ILeaveRequestStatusController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.LeaveRequest;
import models.LeaveRequestStatus;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class LeaveRequestStatusController implements ILeaveRequestStatusController {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private GeneralDAO<LeaveRequestStatus> gdao;

    public LeaveRequestStatusController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, LeaveRequestStatus.class);
    }

    @Override
    public List<LeaveRequestStatus> getAll() {
        return gdao.getData("");
    }

    @Override
    public LeaveRequestStatus getById(String id) {
        return gdao.getById(new Long(id));
    }

    @Override
    public List<LeaveRequestStatus> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String leaveRequest, String status, String statusDate) {
        String result = "";
        LeaveRequestStatus leaveRequestStatus = new LeaveRequestStatus(new Long(id), new LeaveRequest(new Long(leaveRequest)), new Status(new Long(status)), new java.sql.Date(date.getTime()));
        if (gdao.saveOrDelete(leaveRequestStatus, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        LeaveRequestStatus leaveRequestStatus = new LeaveRequestStatus(new Long(id));
        if (gdao.saveOrDelete(leaveRequestStatus, true)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

}
