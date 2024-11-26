// Class to perform network checks
class NetworkChecker {
    public void performChecks() {
        try {
            System.out.println("Performing network checks...");

            System.out.println("Checking IP configuration:");
            CommandExecutor.execute(isWindows() ? "ipconfig" : "ifconfig");

            System.out.println("Pinging localhost:");
            CommandExecutor.execute("ping 8.8.8.8");

            System.out.println("Tracing route to localhost:");
            CommandExecutor.execute(isWindows() ? "tracert 127.0.0.1" : "traceroute 127.0.0.1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}
