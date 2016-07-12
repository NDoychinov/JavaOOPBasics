package Ex1_DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 21.6.2016 г..
 */

class Man {
    String parentName;
    String parentDate;
    String childrenName;
    String childrenDate;

    public Man(String parentName, String parentDate, String childrenName, String childrenDate) {
        this.parentName = parentName;
        this.parentDate = parentDate;
        this.childrenName = childrenName;
        this.childrenDate = childrenDate;
    }

    public Man(String parentName, String childrenName) {
        this(parentName, "unknown", childrenName, "unknown");
    }

    public Man() {
    }
}

public class Problem10_FamilyTree {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Man> knownPeople = new ArrayList<>();
        List<String> unknownPeople = new ArrayList<>();

        String lookingName = sc.readLine();

        String input = sc.readLine();
        while (!input.equals("End")) {
            if (!input.contains("-")) {
                String[] data = input.split("\\s+");
                knownPeople.add(new Man(data[0] + " " + data[1], data[2]));
            } else {
                unknownPeople.add(input);
            }

            input = sc.readLine();
        }


        List<Man> manList = new ArrayList<>();

        for (int i = 0; i < unknownPeople.size(); i++) {
            String[] data = unknownPeople.get(i).split(" - ");
            Man man = new Man();

            if (data[0].contains("/")) {
                String parentDate = data[0];
                String parentName = "";
                for (int j = 0; j < knownPeople.size(); j++) {
                    if (knownPeople.get(j).parentName.equals(parentDate)) {
                        parentName = knownPeople.get(j).childrenName;
                    } else if (knownPeople.get(j).childrenName.equals(parentDate)) {
                        parentName = knownPeople.get(j).parentName;
                    }
                }
                man.parentName = parentName;
                man.parentDate = parentDate;
            } else {
                String[] splitted = data[0].split("\\s+");
                String parentName = splitted[0] + " " + splitted[1];
                String parentDate = "";
                for (int j = 0; j < knownPeople.size(); j++) {
                    if (knownPeople.get(j).parentName.equals(parentName)) {
                        parentDate = knownPeople.get(j).childrenName;
                    } else if (knownPeople.get(j).childrenName.equals(parentName)) {
                        parentDate = knownPeople.get(j).parentName;
                    }
                }
                man.parentName = parentName;
                man.parentDate = parentDate;
            }

            if (data[1].contains("/")) {
                String childrenDate = data[1];
                String childrenName = "";
                for (int j = 0; j < knownPeople.size(); j++) {
                    if (knownPeople.get(j).parentName.equals(childrenDate)) {
                        childrenName = knownPeople.get(j).childrenName;
                    } else if (knownPeople.get(j).childrenName.equals(childrenDate)) {
                        childrenName = knownPeople.get(j).parentName;
                    }
                }
                man.childrenName = childrenName;
                man.childrenDate = childrenDate;
            } else {
                String[] splitted = data[1].split("\\s+");
                String childrenName = splitted[0] + " " + splitted[1];
                String childrenDate = "";
                for (int j = 0; j < knownPeople.size(); j++) {
                    if (knownPeople.get(j).parentName.equals(childrenName)) {
                        childrenDate = knownPeople.get(j).childrenName;
                    } else if (knownPeople.get(j).childrenName.equals(childrenName)) {
                        childrenDate = knownPeople.get(j).parentName;
                    }
                }
                man.childrenName = childrenName;
                man.childrenDate = childrenDate;
            }
            manList.add(man);
        }

        if (lookingName.contains("/")) {
            for (int i = 0; i < manList.size(); i++) {
                Man currMan = manList.get(i);
                if (currMan.parentDate.equals(lookingName)) {
                    System.out.println(currMan.parentName + " " + lookingName);
                    break;
                } else if (currMan.childrenDate.equals(lookingName)) {
                    System.out.println(currMan.childrenName + " " + lookingName);
                    break;
                }
            }
        } else {
            for (int i = 0; i < manList.size(); i++) {
                Man currMan = manList.get(i);
                if (currMan.childrenName.equals(lookingName)) {
                    System.out.println(lookingName + " " + currMan.childrenDate);
                    break;
                } else if (currMan.parentName.equals(lookingName)) {
                    System.out.println(lookingName + " " + currMan.parentDate);
                    break;
                }
            }
        }

        System.out.println("Parents:");
        for (int i = 0; i < manList.size(); i++) {
            Man currMan = manList.get(i);
            if (currMan.childrenName.equals(lookingName) || currMan.childrenDate.equals(lookingName)) {
                System.out.println(currMan.parentName + " " + currMan.parentDate);
            }
        }

        System.out.println("Children:");
        for (int i = 0; i < manList.size(); i++) {
            Man currMan = manList.get(i);
            if (currMan.parentName.equals(lookingName) || currMan.parentDate.equals(lookingName)) {
                System.out.println(currMan.childrenName + " " + currMan.childrenDate);
            }
        }
    }
}
