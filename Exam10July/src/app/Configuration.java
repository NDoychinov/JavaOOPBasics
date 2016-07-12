package app;

import app.Dump.Dump;
import app.Hardware.Hardware;
import app.Hardware.HeavyHardware;
import app.Hardware.PowerHardware;
import app.Software.ExpressSoftware;
import app.Software.LightSoftware;
import app.Software.Software;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 11.7.2016 г..
 */
public class Configuration {
    private List<Hardware> hardwareList;
    private Dump dump;

    public Configuration() {
        this.hardwareList = new ArrayList<>();
        this.dump = new Dump();
    }

    public void registerPowerHardware(String name, int maximumCapacity,
                                           int maximumMemory){
        Hardware hardware = new PowerHardware(name,
                maximumCapacity,
                maximumMemory);
        this.hardwareList.add(hardware);
    }

    public void registerHeavyHardware(String name, int maximumCapacity,
                                      int maximumMemory){
        Hardware hardware = new HeavyHardware(name,
                maximumCapacity,
                maximumMemory);
        this.hardwareList.add(hardware);
    }

    public void registerExpressSoftware(String hardwareName,
                                        String softwareName,
                                        int capacityConsumption,
                                        int memoryConsumption){

        for (int i = 0; i < this.hardwareList.size(); i++) {
            Hardware currHardWare = this.hardwareList.get(i);
            if (currHardWare.getName().equals(hardwareName)) {

                Software software = new ExpressSoftware(
                        softwareName,
                        capacityConsumption,
                        memoryConsumption);

                if (currHardWare.isCapable(software)) {
                    currHardWare.addSoftware(software);
                }
            }
        }
    }

    public void registerLightSoftware(String hardwareName,
                                        String softwareName,
                                        int capacityConsumption,
                                        int memoryConsumption){

        for (int i = 0; i < this.hardwareList.size(); i++) {
            Hardware currHardWare = this.hardwareList.get(i);
            if (currHardWare.getName().equals(hardwareName)) {

                Software software = new LightSoftware(
                        softwareName,
                        capacityConsumption,
                        memoryConsumption);

                if (currHardWare.isCapable(software)) {
                    currHardWare.addSoftware(software);
                }
            }
        }
    }

    public void releaseSoftwareComponent(String hardwareName,
                                         String softwareName){
        for (int i = 0; i < hardwareList.size(); i++) {
            Hardware currHardware = hardwareList.get(i);
            if (currHardware.getName().equals(hardwareName)) {
                currHardware.releaseSoftware(softwareName);
            }
        }
    }

    public void analyze(){
        System.out.println("System Analysis");
        System.out.println("Hardware Components: " + this.hardwareList.size());

        int softCount = 0;
        int totalMemoryInUse = 0;
        int totalMemory = 0;
        int totalCapacityInUse = 0;
        int totalCapacity = 0;
        for (int i = 0; i < this.hardwareList.size(); i++) {
            softCount += this.hardwareList.get(i).getSoftwares().size();
            totalMemoryInUse += this.hardwareList.get(i).getMaximumMemory() - this.hardwareList.get(i).getMemory();
            totalMemory += this.hardwareList.get(i).getMaximumMemory();
            totalCapacityInUse += this.hardwareList.get(i).getMaximumCapacity() - this.hardwareList.get(i)
                    .getCapacity();
            totalCapacity += this.hardwareList.get(i).getMaximumCapacity();
        }

        System.out.println("Software Components: " + softCount);
        System.out.printf("Total Operational Memory: %d / %d%n", totalMemoryInUse, totalMemory);
        System.out.printf("Total Capacity Taken: %d / %d%n", totalCapacityInUse, totalCapacity);
    }

    public void dump(String name){
        for (int i = 0; i < this.hardwareList.size(); i++) {
            if (this.hardwareList.get(i).getName().equals(name)) {
                this.dump.addDump(this.hardwareList.get(i));
                this.hardwareList.remove(i);
                i--;
            }
        }
    }

    public void restore(String name){
        try {
            Hardware restored = this.dump.restore(name);
            this.hardwareList.add(restored);
        } catch (IllegalArgumentException e) {

        }
    }

    public void destroy(String name){
        this.dump.destroy(name);
    }

    public void dumpAnalyze(){
        this.dump.makeAnalize();
    }

    public void printSystemSplit(){
        for (int i = 0; i < this.hardwareList.size(); i++) {
            Hardware currHardware = this.hardwareList.get(i);
            if (currHardware.getType().equals("Power"))
                currHardware.systemAnalize();
        }

        for (int i = 0; i < this.hardwareList.size(); i++) {
            Hardware currHardware = this.hardwareList.get(i);
            if (currHardware.getType().equals("Heavy"))
                currHardware.systemAnalize();
        }
    }
}
