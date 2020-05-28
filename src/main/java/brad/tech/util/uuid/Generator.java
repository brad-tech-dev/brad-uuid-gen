package brad.tech.util.uuid;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This is the entry-point class.
 * 
 * Contains the main() method.
 * @author brad
 */
public class Generator {
    
    private final UIPanel panel;
    Generator() {
        panel = new UIPanel();
        // fetch logo
        final var logoURL = Generator.class.getResource("processor.png");
        if (logoURL != null) {
            panel.lblLogo.setIcon(new ImageIcon(logoURL));
        }
    }
    
    void display() {
        final var dialog = new JDialog();
        dialog.setTitle("BRAD UUID Generator");
        dialog.setModal(true);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setContentPane(panel);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        // icon
        final var iconURL = Generator.class.getResource("brad-logo.png");
        if (iconURL != null) {
            dialog.setIconImage(new ImageIcon(iconURL).getImage());
        }
        dialog.setVisible(true);
    }
    
    public static void main(String[] args) {
        // look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | 
                InstantiationException | 
                IllegalAccessException | 
                UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // run app
        EventQueue.invokeLater(new Generator()::display);
    }
}
