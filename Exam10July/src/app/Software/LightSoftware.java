package app.Software;

/**
 * Created by Niki on 10.7.2016 г..
 */
public class LightSoftware extends Software {

    public LightSoftware(String name, int capacityConsumption, int
            memoryConsumption) {
        super(name, "Light", capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption - (memoryConsumption / 2));
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption + (capacityConsumption / 2));
    }
}
