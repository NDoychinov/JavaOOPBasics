package app.Software;

/**
 * Created by Niki on 10.7.2016 г..
 */
public class ExpressSoftware extends Software {

    public ExpressSoftware(String name, int capacityConsumption, int
            memoryConsumption) {
        super(name, "Express", capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption * 2);
    }
}
