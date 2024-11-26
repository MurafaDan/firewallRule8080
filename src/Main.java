import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FirewallManagerUI app = new FirewallManagerUI();
            app.showUI();
        });
    }
}