/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.LeaveRequestStatus;

/**
 *
 * @author Arif Fridasari
 */
public interface ILeaveRequestStatusController {

    public List<LeaveRequestStatus> getAll();

    public LeaveRequestStatus getById(String id);

    public List<LeaveRequestStatus> search(Object keyword);

    public String save(String id, String leaveRequest, String status);

    public String delete(String id);
}
