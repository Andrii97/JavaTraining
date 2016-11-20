package ua.training;

/**
 * Created by andrii on 19.11.16.
 */
public class FacadeApp {

    public static void main(String[] args) {

//        Power power = new Power();
//        power.on();
//
//        DVDRom dvd = new DVDRom();
//        dvd.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("turn on the power");
    }
    void off() {
        System.out.println("turn off the power");
    }
}

class DVDRom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }
    void load() {
        data = true;
    }
    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if(dvd.hasData()) {
            System.out.println("It is copying data from disk");
        } else {
            System.out.println("Insert the data disk");
        }
    }
}