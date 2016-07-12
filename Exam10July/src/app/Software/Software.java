package app.Software;

/**
 * Created by Niki on 10.7.2016 г..
 */
public abstract class Software {

    private String name;
    private String type;
    private int capacityConsumption;
    private int memoryConsumption;

    protected Software(String name, String type, int capacityConsumption, int memoryConsumption) {
        this.setName(name);
        this.setType(type);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
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

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }


}
