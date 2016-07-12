package app.Hardware;

/**
 * Created by Niki on 10.7.2016 г..
 */
public class PowerHardware extends Hardware {

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, "Power", maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity - ((maximumCapacity * 3) / 4));
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory + ((maximumMemory * 3) / 4));
    }
}
