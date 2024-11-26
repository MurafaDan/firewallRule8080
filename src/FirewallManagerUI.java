import javax.swing.*;
import java.awt.*;


class FirewallManagerUI {
    private JFrame frame;

    private FirewallManager firewallManager;

    public FirewallManagerUI() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            firewallManager = new WindowsFirewallManager();
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("mac")) {
            firewallManager = new LinuxFirewallManager();
        } else {
            JOptionPane.showMessageDialog(null, "Unsupported OS: " + osName, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void showUI() {
        frame = new JFrame("Firewall Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel label = new JLabel("Firewall Manager for Port 8080", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        JButton addRuleButton = new JButton("Add Firewall Rule");
        JButton checkNetworkButton = new JButton("Perform Network Checks");
        JButton removeRuleButton = new JButton("Remove Firewall Rule");

        // Button Actions
        addRuleButton.addActionListener(e -> handleAddRule());
        checkNetworkButton.addActionListener(e -> handleNetworkCheck());
        removeRuleButton.addActionListener(e -> handleRemoveRule());

        // Add components to frame
        frame.add(label);
        frame.add(addRuleButton);
        frame.add(checkNetworkButton);
        frame.add(removeRuleButton);

        frame.setVisible(true);

        // Shutdown hook to ensure cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Cleaning up firewall rules...");
            firewallManager.removeFirewallRule();
        }));
    }

    private void handleAddRule() {
        firewallManager.addFirewallRule();
        JOptionPane.showMessageDialog(frame, "Firewall rule added for port 8080!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleNetworkCheck() {
        NetworkChecker checker = new NetworkChecker();
        checker.performChecks();
        JOptionPane.showMessageDialog(frame, "Network checks completed. See console for details.", "Done", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleRemoveRule() {
        firewallManager.removeFirewallRule();
        JOptionPane.showMessageDialog(frame, "Firewall rule removed for port 8080!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
