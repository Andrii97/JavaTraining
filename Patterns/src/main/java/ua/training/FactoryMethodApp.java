package ua.training;

import java.util.Date;

/**
 * Created by andrii on 20.11.16.
 */
public class FactoryMethodApp {
    public static void main(String[] args) {
        WatchMaker maker = getMakerByName("Rome");

        Watch watch = maker.createWatch();
        watch.showTime();
    }
    public static WatchMaker getMakerByName(String maker) {
        if(maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if(maker.equals("Rome")) {
            return new RomeWatchMaker();
        }

        throw  new RuntimeException("does not support production line watches: " + maker);
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}