/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IStatusController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class StatusController implements IStatusController {

    private GeneralDAO<Status> gdao;

    public StatusController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Status.class);
    }

    @Override
    public List<Status> getAll() {
        return gdao.getData("");
    }

    @Override
    public Status getById(String id) {
        return gdao.getById(new Long(id));
    }

    @Override
    public List<Status> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String name) {
        String result = "";
//        date = formatter.parse(statusDate);
        Status status = new Status(new Long(id), name);
        if (gdao.saveOrDelete(status, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Status status = new Status(new Long(id));
        if (gdao.saveOrDelete(status, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

}
