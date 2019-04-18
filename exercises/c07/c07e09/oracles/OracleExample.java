package oracles;

public class OracleExample {
    public static void main (String[] argv) {
        LockedOracle oracle = new LockedOracle(123);
        LockedOracleTUI ui =
            new LockedOracleTUI(oracle);
        ui.start();
    }
}
