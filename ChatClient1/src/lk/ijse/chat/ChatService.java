
package lk.ijse.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author User
 */
public interface ChatService extends Remote {
    public void sendMessage(String user,String msg)throws RemoteException;
}
