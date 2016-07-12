package Ex3_StaticMembers.Problem5_AnimalClinic;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class Animal {
    String name;
    String breed;

    public Animal(String name, String breed, String action) {
        this.name = name;
        this.breed = breed;
        AnimalClinic.patientId++;
        if (action.equals("heal")){
            AnimalClinic.healedAnimals.put(AnimalClinic.patientId, this);
            System.out.printf("Patient %d: [%s(%s)] has been healed!%n",
                    AnimalClinic.patientId, name, breed);
        } else {
            AnimalClinic.rehabilitedAnimals.put(AnimalClinic.patientId, this);
            System.out.printf("Patient %d: [%s(%s)] has been rehabilitated!%n",
                    AnimalClinic.patientId, name, breed);
        }
    }
}
