/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iconjframe;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author DeividnN
 */
public final class IconJframe extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IconJframe j = new IconJframe();
        j.setVisible(true);
    }

    Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");//icone do jframe
    Image icon2 = Toolkit.getDefaultToolkit().getImage("icon2.png");//icone do tray

    public IconJframe() {
        setIconImage(icon);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        criarSystemtray();
      
    }

        public void criarSystemtray() {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon
                = new TrayIcon(icon2);
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a pop-up menu components
        MenuItem aboutItem = new MenuItem("About");
        MenuItem exitItem = new MenuItem("Exit");

        //Add components to pop-up menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.addSeparator();
        popup.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }

}
