/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.LeaveRequest;

/**
 *
 * @author Arif Fridasari
 */
public interface ILeaveRequestController {

    public List<LeaveRequest> getAll();

    public LeaveRequest getById(String id);

    public List<LeaveRequest> search(Object keyword);

    public String save(String id, String startDate, String endDate, String type, String notes, 
            String requester, String manager, String status);

    public String delete(String id);
}
