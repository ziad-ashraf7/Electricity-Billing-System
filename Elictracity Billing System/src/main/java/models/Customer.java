/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author DELL 5570
 */
public interface Customer {
    int getCustomerId();
    String getName();
    String getEmail();
    String getPhone();
    String getAddress();
    String getMeterCode();
    boolean isNewCustomer();
}
