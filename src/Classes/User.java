/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author himagi
 */
abstract class User implements UserInterface {
    protected String id;
    protected String fullName;
    protected String password;
    protected String contactNum;
    
    abstract void createAccount();
    
    

}