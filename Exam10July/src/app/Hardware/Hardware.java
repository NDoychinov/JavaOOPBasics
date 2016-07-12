package app.Hardware;

import app.Software.Software;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 10.7.2016 г..
 */
public abstract class Hardware {

    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private int capacity;
    private int memory;
    private List<Software> softwares;

    protected Hardware(String name, String type, int maximumCapacity, int maximumMemory) {
        this.setName(name);
        this.setType(type);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.softwares = new ArrayList<>();
    }

    public void addSoftware(Software software) {
        this.softwares.add(software);
        this.capacity -= software.getCapacityConsumption();
        this.memory -= software.getMemoryConsumption();
    }

    public void releaseSoftware(String name) {

        for (int i = 0; i < this.softwares.size(); i++) {
            if (this.softwares.get(i).getName().equals(name)) {
                this.capacity += this.softwares.get(i).getCapacityConsumption();
                this.memory += this.softwares.get(i).getMemoryConsumption();
                this.softwares.remove(i);
                i--;
            }
        }
    }

    public List<Software> getSoftwares() {
        return softwares;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.capacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
        this.memory = maximumMemory;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMemory() {
        return memory;
    }

    public void reduceCapacity(int capacity) {
        this.capacity -= capacity;
    }

    public void reduceMemory(int memory) {
        this.memory -= memory;
    }

    public void freeCapacity(int capacity) {
        this.capacity += capacity;
    }

    public void freeMemory(int memory) {
        this.memory += memory;
    }

    public boolean isCapable(Software software) {
        if (this.capacity >= software.getCapacityConsumption() &&
                this.memory >= software.getMemoryConsumption()) {
            return true;
        }
        return false;
    }

    public void systemAnalize() {
        System.out.printf("Hardware Component - %s%n", this.getName());
        int exprCount = 0;
        for (int j = 0; j < this.getSoftwares().size(); j++) {
            Software currSoftware = this.getSoftwares().get(j);
            if (currSoftware.getType().equals("Express")) {
                exprCount++;
            }
        }
        System.out.println("Express Software Components - " + exprCount);

        int lightCount = 0;
        for (int j = 0; j < this.getSoftwares().size(); j++) {
            Software currSoftware = this.getSoftwares().get(j);
            if (currSoftware.getType().equals("Light")) {
                lightCount++;
            }
        }

        System.out.println("Light Software Components - " + lightCount);


        System.out.printf("Memory Usage: %d / %d%n", this.getMaximumMemory() - this.getMemory(),
                this.getMaximumMemory());

        System.out.printf("Capacity Usage: %d / %d%n", this.getMaximumCapacity() -
                        this.getCapacity(),
                this.getMaximumCapacity());

        System.out.println("Type: " + this.getType());

        StringBuilder components = new StringBuilder();
        boolean sizeCheck = false;
        for (int j = 0; j < this.getSoftwares().size(); j++) {
            components.append(this.getSoftwares().get(j).getName() + ", ");
            sizeCheck = true;
        }
        if (sizeCheck) {
            System.out.println("Software Components: " + components.substring(0, components.length() - 2));
        } else {
            System.out.println("Software Components: None");
        }
    }
}
