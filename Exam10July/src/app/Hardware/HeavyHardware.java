package app.Hardware;

/**
 * Created by Niki on 10.7.2016 г..
 */
public class HeavyHardware extends Hardware {

    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, "Heavy", maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity * 2);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory - (maximumMemory / 4));
    }
}
