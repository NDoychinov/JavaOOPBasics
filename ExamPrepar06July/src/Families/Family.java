package Families;

import Furnishings.Furnishing;
import Homes.Home;
import Models.Children;
import Models.Man;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 9.7.2016 г..
 */
public abstract class Family extends Home {

    private List<Man> members;
    private List<Children> kids;

    public Family(double roomsAmount, double roomElectricity) {
        super(roomsAmount, roomElectricity);
        this.kids = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    @Override
    public double getTotalConsumption() {
        double totalCons = 0;
        //Get room consumption
        totalCons += super.getRoomsAmount() * super.getRoomElectricity();

        //Get furnishings consumption
        List<Furnishing> furnishingList = super.getFurnishings();
        for (int i = 0; i < furnishingList.size(); i++) {
            Furnishing current = furnishingList.get(i);
            totalCons += current.getElCost();
        }

        //Get kids consumption
        for (int i = 0; i < this.kids.size(); i++) {
            totalCons += this.kids.get(i).getConsumption();
        }
        return totalCons;
    }

    @Override
    public double getTotalSalary() {
        double totalSalary = 0;
        for (int i = 0; i < this.members.size(); i++) {
            Man current = this.members.get(i);
            totalSalary += current.getSalary();
        }
        return totalSalary;
    }

    @Override
    public void addMember(Man man) {
        this.members.add(man);
    }

    @Override
    public void addChildren(Children kid) {
        this.kids.add(kid);
    }

    @Override
    public double livingPplCount() {
        return this.members.size() + this.kids.size();
    }
}
