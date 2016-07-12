package app.Commands;

import app.Configuration;

/**
 * Created by Niki on 11.7.2016 г..
 */
public class CommandInterpreter {

    private Configuration configuration;

    public CommandInterpreter(Configuration configuration) {
        this.configuration = configuration;
    }

    public void command(String command, String[] data) {
        switch (command) {
            case "RegisterPowerHardware":
                this.tryRegisterPowerHardware(data);
                break;
            case "RegisterHeavyHardware":
                this.tryRegisterHeavyHardware(data);
                break;
            case "RegisterExpressSoftware":
                this.tryRegisterExpressSoftware(data);
                break;
            case "RegisterLightSoftware":
                this.tryRegisterLightSoftware(data);
                break;
            case "ReleaseSoftwareComponent":
                this.tryReleaseSoftwareComponent(data);
                break;
            case "Analyze":
                this.tryAnalyze(data);
                break;

            case "Dump":
                this.tryDump(data);
                break;
            case "Restore":
                this.tryRestore(data);
                break;
            case "Destroy":
                this.tryDestroy(data);
                break;
            case "DumpAnalyze":
                this.tryDumpAnalyze(data);
                break;
        }
    }

    public void tryRegisterPowerHardware(String[] data) {
        String name = data[0];
        int maxCapacity = Integer.parseInt(data[1]);
        int maxMemory = Integer.parseInt(data[2]);

        configuration.registerPowerHardware(name, maxCapacity,
                maxMemory);
    }

    public void tryRegisterHeavyHardware(String[] data) {
        String name = data[0];
        int maxCapacity = Integer.parseInt(data[1]);
        int maxMemory = Integer.parseInt(data[2]);

        configuration.registerHeavyHardware(name, maxCapacity,
                maxMemory);
    }

    public void tryRegisterExpressSoftware(String[] data) {
        String hardwareName = data[0];
        String softwareName = data[1];
        int capacity = Integer.parseInt(data[2]);
        int memory = Integer.parseInt(data[3]);

        configuration.registerExpressSoftware(hardwareName,
                softwareName,
                capacity,
                memory);
    }

    public void tryRegisterLightSoftware(String[] data) {
        String hardwareName = data[0];
        String softwareName = data[1];
        int capacity = Integer.parseInt(data[2]);
        int memory = Integer.parseInt(data[3]);

        configuration.registerLightSoftware(hardwareName,
                softwareName,
                capacity,
                memory);
    }

    public void tryReleaseSoftwareComponent(String[] data) {
        String hardwareName = data[0];
        String softwareName = data[1];

        configuration.releaseSoftwareComponent(hardwareName,
                softwareName);
    }

    public void tryAnalyze(String[] data) {
        configuration.analyze();
    }

    public void tryDump(String[] data) {
        String name = data[0];
        configuration.dump(name);
    }

    public void tryRestore(String[] data) {
        String name = data[0];
        configuration.restore(name);
    }

    public void tryDestroy(String[] data) {
        String name = data[0];
        configuration.destroy(name);
    }

    public void tryDumpAnalyze(String[] data) {
        configuration.dumpAnalyze();
    }
}
