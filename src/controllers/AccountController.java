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

    @Override
    public Account getById(String id) {
        return gdao.getById(id);
    }

    @Override
    public List<Account> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String username, String password) {
        String result = "Failed";
        Account account = new Account(new Long(id), username, password, new Character('0'));
        if (gdao.saveOrDelete(account, false)) {
            result = "Success";
        } 
        
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Failed";
        Account account = new Account(new Long(id));
        if (gdao.saveOrDelete(account, true)) {
            result = "Success";
        }
        
        return result;
    }

    @Override
    public String login(String username, String password) {
        String result = "No such account";
        if (gdao.login(username, password) != null) {
            for (Account account : gdao.getData("")) {
                account.getPassword();
                account.getUsername();
            }
            
            result = "Nice";
        }
        
        return result;
    }

}
