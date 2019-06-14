/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAccountController;
import java.util.List;
import models.Account;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class AccountController implements IAccountController {

    private GeneralDAO<Account> gdao;

    public AccountController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Account.class);
    }

    @Override
    public List<Account> getAll() {
        return gdao.getData("");
    }

}
