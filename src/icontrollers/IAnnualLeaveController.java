/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.AnnualLeave;

/**
 *
 * @author Arif Fridasari
 */
public interface IAnnualLeaveController {

    public List<AnnualLeave> getAll();

    public AnnualLeave getById(String id);

    public List<AnnualLeave> search(Object keyword);

    public String save(String id, String remain);

    public String delete(String id);

}
