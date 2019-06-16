/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAccountController;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.Employee;
import org.hibernate.SessionFactory;
import tools.BCrypt;

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
        return gdao.getById(new Long(id));
    }

    @Override
    public List<Account> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String username, String password) {
        String result = "Failed";
        String pass = this.hash(password);
        Account account = new Account(new Long(id), username, pass, new Character('0'));
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
    
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public String login(String acc, String password) {
        String result = "NO such account";
        String hashed = "";
        if (!acc.contains("@")) {
            Account account = gdao.getAccount(acc);
            if (account != null) {
                hashed = account.getPassword();
                
            }else{
                result = "Username is wrong";
            }
            
        }else{
            Employee employee = gdao.getEmployee(acc);
            if (employee != null) {
                Account account = gdao.getById(employee.getId());
                hashed = account.getPassword();
                
            }else{
                result = "Email is wrong";
            }
            
        }
        
        boolean cekPassword = BCrypt.checkpw(password, hashed);
            
        if (cekPassword) {
            result = "Login Success";
        }else{
            result = "Wrong Password";
        }

        return result;
    }

}
