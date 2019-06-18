/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ACER
 */
public class EmployeeSession {
    
    public static String idEmp;
    public static String nameEmp;

    public EmployeeSession() {
    }

    public EmployeeSession(String idEmp, String nameEmp) {
        this.idEmp = idEmp;
        this.nameEmp = nameEmp;
    }

    public static String getIdEmp() {
        return idEmp;
    }

    public static void setIdEmp(String idEmp) {
        EmployeeSession.idEmp = idEmp;
    }

    public static String getNameEmp() {
        return nameEmp;
    }

    public static void setNameEmp(String nameEmp) {
        EmployeeSession.nameEmp = nameEmp;
    }   
    
}
