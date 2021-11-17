/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7_server;

import java.io.Serializable;

/**
 *
 * @author zLittleMasterz
 */
public class SVFILE implements Serializable{

    private static final long serialVersionUID = 1L;
    private int type;
    private String absolutePath;
    private String name;

    public SVFILE() {
    }

    public SVFILE(int type, String absolutePath, String name) {
        this.type = type;
        this.absolutePath = absolutePath;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
