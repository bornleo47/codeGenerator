/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuk.test.demorest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anukshakya
 */

@XmlRootElement
public class deposit {
    private int id;
    private String code;
    private double amount;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public String setCode(String code) {
        return this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "deposit{" + "id=" + id + ", code=" + code + ", amount=" + amount + '}';
    }
    
    
    
    
    
    
    
}
