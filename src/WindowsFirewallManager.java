// Implementation for Windows
class WindowsFirewallManager extends FirewallManager {
    @Override
    public void addFirewallRule() {
        try {
            System.out.println("Adding firewall rule for Windows...");
            CommandExecutor.execute("netsh advfirewall firewall add rule name=\"Allow8080\" dir=in action=allow protocol=TCP localport=8080");
            System.out.println("Firewall rule added for port 8080 on Windows.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeFirewallRule() {
        try {
            System.out.println("Removing firewall rule for Windows...");
            CommandExecutor.execute("netsh advfirewall firewall delete rule name=\"Allow8080\"");
            System.out.println("Firewall rule removed for port 8080 on Windows.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
