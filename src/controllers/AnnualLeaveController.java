/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAnnualLeaveController;
import java.util.List;
import models.AnnualLeave;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class AnnualLeaveController implements IAnnualLeaveController {

    private GeneralDAO<AnnualLeave> gdao;

    public AnnualLeaveController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, AnnualLeave.class);
    }

    @Override
    public List<AnnualLeave> getAll() {
        return gdao.getData("");
    }

    @Override
    public AnnualLeave getById(String id) {
        return gdao.getById(new Long(id));
    }

    @Override
    public List<AnnualLeave> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String remain) {
        String result = "";
        AnnualLeave annualLeave = new AnnualLeave(new Long(id), new Short(remain));
        if (gdao.saveOrDelete(annualLeave, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        AnnualLeave annualLeave = new AnnualLeave(new Long(id));
        if (gdao.saveOrDelete(annualLeave, true)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

}
