package lk.ijse.chat;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainChatForm extends javax.swing.JFrame implements ChatService {

    public void sendMessage(String user, String msg) throws RemoteException {
        String messages = txt.getText();
        messages += user + " : " + msg + "\n";
        txt.setText(messages);
    }

    public MainChatForm() {
        initComponents();
        setLocationRelativeTo(null);

        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException ex) {
            Logger.getLogger(MainChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Public Chat Room");

        txt.setColumns(20);
        txt.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        txt.setRows(5);
        jScrollPane1.setViewportView(txt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) throws RemoteException, AlreadyBoundException {
        System.setProperty("java.rmi.server.hostname", "localhost");
        MainChatForm mainChatForm = new MainChatForm();

        Registry rmiRegistry = LocateRegistry.createRegistry(6060);
        rmiRegistry.bind("chat", mainChatForm);
        System.out.println("Server has been started");
        mainChatForm.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
