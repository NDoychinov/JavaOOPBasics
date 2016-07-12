package app.Dump;

import app.Hardware.Hardware;
import app.Software.Software;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 10.7.2016 г..
 */
public class Dump {

    private List<Hardware> dumpedHardware;

    public Dump() {
        this.dumpedHardware = new ArrayList<>();
    }

    public void addDump(Hardware hardware) {
        dumpedHardware.add(hardware);
    }

    public Hardware restore(String name) {
        for (int i = 0; i < this.dumpedHardware.size(); i++) {
            if (dumpedHardware.get(i).getName().equals(name)) {
                Hardware hardware = dumpedHardware.get(i);
                dumpedHardware.remove(i);
                return hardware;
            }
        }
        throw new IllegalArgumentException("Not exciting dump");
    }

    public void destroy(String name) {
        for (int i = 0; i < this.dumpedHardware.size(); i++) {
            if (this.dumpedHardware.get(i).getName().equals(name)) {
                this.dumpedHardware.remove(i);
                i--;
            }
        }
    }


    public void makeAnalize() {
        System.out.println("Dump Analysis");

        int powerHardCount = 0;
        int heavyHardCount = 0;
        for (int i = 0; i < this.dumpedHardware.size(); i++) {
            if (this.dumpedHardware.get(i).getType().equals("Power")) {
                powerHardCount++;
            } else {
                heavyHardCount++;
            }
        }

        System.out.println("Power Hardware Components: " + powerHardCount);
        System.out.println("Heavy Hardware Components: " + heavyHardCount);

        int expessSoftCount = 0;
        int lightSoftCount = 0;
        int totalDumpedMemory = 0;
        int totalDimpedCapacity = 0;

        for (int i = 0; i < this.dumpedHardware.size(); i++) {
            Hardware currHardware = this.dumpedHardware.get(i);

            for (int j = 0; j < currHardware.getSoftwares().size(); j++) {
                Software currSoftware = currHardware.getSoftwares().get(j);
                if (currSoftware.getType().equals("Express")) {
                    expessSoftCount++;
                } else {
                    lightSoftCount++;
                }
                totalDumpedMemory += currSoftware.getMemoryConsumption();
                totalDimpedCapacity += currSoftware.getCapacityConsumption();
            }
        }

        System.out.println("Express Software Components: " + expessSoftCount);
        System.out.println("Light Software Components: " + lightSoftCount);
        System.out.println("Total Dumped Memory: " + totalDumpedMemory);
        System.out.println("Total Dumped Capacity: " + totalDimpedCapacity);
    }
}
