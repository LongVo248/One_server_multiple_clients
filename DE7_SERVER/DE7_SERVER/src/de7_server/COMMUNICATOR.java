/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7_server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author zLittleMasterz
 */
public interface COMMUNICATOR extends Remote{  
    public ArrayList<SVFILE> getFile(String path, String clientName) throws RemoteException;
    public boolean clConnect(String clientName) throws RemoteException;
    public void clDisconnect(String clientName) throws RemoteException;
}
