/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.LeaveType;

/**
 *
 * @author Arif Fridasari
 */
public interface ILeaveTypeController {

    public List<LeaveType> getAll();

    public LeaveType getById(String id);

    public List<LeaveType> search(Object keyword);

    public String save(String id, String name);

    public String delete(String id);
}
