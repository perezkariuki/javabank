/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afterlogin;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author user
 */
 public interface Hello extends Remote{         
void animation()throws RemoteException; 
}


