/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.AccountController;
import controllers.AnnualLeaveController;
import controllers.EmployeeController;
import daos.GeneralDAO;
import icontrollers.IAccountController;
import icontrollers.IEmployeeController;
import models.Account;
import models.AnnualLeave;
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

        GeneralDAO<AnnualLeave> dDao = new GeneralDAO<>(factory, AnnualLeave.class);
        AnnualLeaveController dc = new AnnualLeaveController(factory);
        for (AnnualLeave annualLeave : dDao.getData("")) {
            System.out.println(annualLeave.getId());
            System.out.println(annualLeave.getRemain());
        }
        
        //System.out.println(dDao.getEmployee("sindiyuliawibowo31@gmail.com"));
//        IEmployeeController iec = new EmployeeController(factory);
//        System.out.println(iec.save("150", "coba", "coba", "mail", "100", "100"));
        IAccountController iac = new AccountController(factory);
//        Account account = iac.getById("100");
//        System.out.println(iac.save("100", "arif", "123"));
//        String email = "usup@mail.com";
//        System.out.println(email.contains("@"));
          System.out.println(iac.login("sindiyuliawibowo31@gmail.com", "yulia123"));
        //System.out.println(iac.save("130", "usup", "usup123"));
    }
}
