// Implementation for Linux
class LinuxFirewallManager extends FirewallManager {
    @Override
    public void addFirewallRule() {
        try {
            System.out.println("Adding firewall rule for Linux...");
            CommandExecutor.execute("sudo iptables -A INPUT -p tcp --dport 8080 -j ACCEPT");
            System.out.println("Firewall rule added for port 8080 on Linux.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeFirewallRule() {
        try {
            System.out.println("Removing firewall rule for Linux...");
            CommandExecutor.execute("sudo iptables -D INPUT -p tcp --dport 8080 -j ACCEPT");
            System.out.println("Firewall rule removed for port 8080 on Linux.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
