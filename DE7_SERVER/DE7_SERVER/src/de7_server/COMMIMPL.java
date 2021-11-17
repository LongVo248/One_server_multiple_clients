/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7_server;

import static de7_server.SERVER.timeFormat;
import static de7_server.SERVER.txtboxServer;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author zLittleMasterz
 */
public class COMMIMPL extends UnicastRemoteObject implements COMMUNICATOR{

    public COMMIMPL() throws RemoteException {
        
    }

    @Override
    public synchronized ArrayList<SVFILE> getFile(String path, String clientName) throws RemoteException {
        
        if (!SERVER.isClNameExist(clientName)) {
            return null;
        }
        txtboxServer.append("[" + timeFormat.format(new Date()) + "]: " + clientName + " yêu cầu " + path + "...\n");
        ArrayList<SVFILE> dsFile = new ArrayList<SVFILE>();
        
        if (path.compareToIgnoreCase("PC") == 0) {
            File[] fileList = File.listRoots();
            for (File file : fileList) {
                SVFILE svfile = new SVFILE(3, file.getPath(),
                        FileSystemView.getFileSystemView().getSystemDisplayName(file));
                dsFile.add(svfile);
                System.out.println(FileSystemView.getFileSystemView().getSystemDisplayName(file));
            }
            txtboxServer.append("[" + timeFormat.format(new Date()) + "]: " + "Xong yêu cầu của " + clientName + "\n");
            return dsFile;
        }
        
        File requestFile = new File(path);
        if (requestFile.isDirectory()) {
            File[] fileList = requestFile.listFiles();
            try {
                for (File file : fileList){
                    SVFILE svfile = new SVFILE();
                    if (file.isDirectory()) {
                        svfile.setType(2);
                    } else {
                        svfile.setType(1);
                    }
                    svfile.setAbsolutePath(file.getAbsolutePath());
                    svfile.setName(file.getName());
                    
                    dsFile.add(svfile);
                }
                txtboxServer.append("Xong yêu cầu của " + clientName + "\n");
                return dsFile;
            } catch (NullPointerException e) {
                txtboxServer.append("Thư mục " + clientName + " yêu cầu bị cấm không đc xem \n");
            }
        } else {
            txtboxServer.append("Thư mục " + clientName + " yêu cầu không tồn tại\n");;
        }
        return null;
    }

    @Override
    public synchronized boolean clConnect(String clientName) throws RemoteException {
        if (!SERVER.isClNameExist(clientName)) {
            SERVER.clConnect(clientName);
            return true;
        }
        return false;
    }

    @Override
    public synchronized void clDisconnect(String clientName) throws RemoteException {
        if (SERVER.isClNameExist(clientName)) {
            SERVER.clDisonnect(clientName);
        }
    }
}
