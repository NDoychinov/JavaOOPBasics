package Ex6_Polymorphism.Problem3_WildFarm.Animals;

/**
 * Created by Niki on 4.7.2016 г..
 */
public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight);
        this.setLivingRegion(livingRegion);
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
}
