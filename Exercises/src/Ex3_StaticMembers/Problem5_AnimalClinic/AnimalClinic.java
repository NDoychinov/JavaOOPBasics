package Ex3_StaticMembers.Problem5_AnimalClinic;

import java.util.HashMap;

/**
 * Created by Niki on 24.6.2016 г..
 */
public class AnimalClinic {

    static int patientId = 0;
    static HashMap<Integer, Animal> healedAnimals = new HashMap<>();
    static HashMap<Integer, Animal> rehabilitedAnimals= new HashMap<>();

}
