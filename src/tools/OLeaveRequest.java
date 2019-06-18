/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.AccountController;
import controllers.AnnualLeaveController;
import controllers.EmployeeController;
import controllers.EmployeeRoleController;
import controllers.JobController;
import controllers.RoleController;
import daos.GeneralDAO;
import icontrollers.IAccountController;
import icontrollers.IEmployeeController;
import icontrollers.IEmployeeRoleController;
import icontrollers.IJobController;
import icontrollers.IRoleController;
import models.Account;
import models.AnnualLeave;
import models.Employee;
import models.EmployeeRole;
import models.Job;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class OLeaveRequest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println(factory);
        
        GeneralDAO<Account> dDao = new GeneralDAO(factory, Account.class);
        AnnualLeaveController dc = new AnnualLeaveController(factory);
//        for (AnnualLeave annualLeave : dDao.getData("")) {
//            System.out.println(annualLeave.getId());
//            System.out.println(annualLeave.getRemain());
//        }
        
        //System.out.println(dDao.getEmployee("sindiyuliawibowo31@gmail.com"));
//        IEmployeeController iec = new EmployeeController(factory);
//        System.out.println(iec.save("150", "coba", "coba", "mail", "100", "100"));
        IAccountController iac = new AccountController(factory);
//        Account account = iac.getById("100");
//        System.out.println(iac.save("100", "arif", "123"));
//        String email = "usup@mail.com";
//        System.out.println(email.contains("@"));
          //System.out.println(iac.login("gmail.com", "yulia123"));
//          Account account = dDao.getAccount("sindi123");
//          if (account != null) {
//              System.out.println("berisi");
//        }else{
//              System.out.println("kosong");
//          }
        //System.out.println(iac.save("130", "usup", "usup123"));
        IJobController ijc = new JobController(factory);
//        for (Job job : ijc.search("110")) {
//            job.getName();
//        }
        IEmployeeRoleController ierc = new EmployeeRoleController(factory);
        IRoleController irc = new RoleController(factory);
        IEmployeeController iec = new EmployeeController(factory);
        String idRole = "";
        
        for (EmployeeRole employeeRole : ierc.search("110")) {
            System.out.println(employeeRole.getRole().getName());
        }
        
        Employee employee = iec.getById("110");
        System.out.println(employee.getManager().getFirstName()+" "+employee.getManager().getLastName());
        
        factory.close();
        
    }
}
