package Homes;

import Furnishings.Furnishing;
import Models.Children;
import Models.Man;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 9.7.2016 г..
 */
public abstract class Home {

    private double roomsAmount;
    private double roomElectricity;
    private List<Furnishing> furnishings;
    private double totalMoney;

    public Home(double roomsAmount, double roomElectricity) {
        this.setRoomsAmount(roomsAmount);
        this.setRoomElectricity(roomElectricity);
        this.furnishings = new ArrayList<>();
        this.totalMoney = 0d;
    }

    public void payBills() {
        if (this.totalMoney - getTotalConsumption() >= 0) {
            this.totalMoney -= getTotalConsumption();
        } else {
            throw new IllegalArgumentException("Not enough money");
        }
    }

    public void paySalaries() {
        this.totalMoney += getTotalSalary();
    }

    public double getTotalMoney() {
        return this.totalMoney;
    }

    protected List<Furnishing> getFurnishings() {
        return furnishings;
    }

    protected double getRoomsAmount() {
        return roomsAmount;
    }

    private void setRoomsAmount(double roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    protected double getRoomElectricity() {
        return roomElectricity;
    }

    private void setRoomElectricity(double roomElectricity) {
        this.roomElectricity = roomElectricity;
    }

    abstract public double getTotalConsumption();

    abstract public double livingPplCount();

    abstract public double getTotalSalary();

    abstract public void addMember(Man man);

    abstract public void addChildren(Children kid);

    public void addFurnishing(Furnishing furnishing) {
        this.furnishings.add(furnishing);
    }

}
