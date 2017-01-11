package ua.training.state;

/**
 * Created by andrii on 11.01.17.
 */
public class StateApp {
    public static void main(String[] args) {

//        Station dfm = new RadioDFM();
//        Radio radio = new Radio();
//        radio.setStation(dfm);
//
//        for (int i=0; i<10; i++){
//            radio.play();
//            radio.nextStation();
//        }

        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 10; i++) {
            human.doSometing();
        }
    }
}

//Context
class Human {
    private  Activity state;
    public void setState(Activity state) {
        this.state = state;
    }
    public void doSometing() {
        state.doSometing(this);
    }
}
//State
interface Activity {
    void doSometing(Human context);
}
class Work implements Activity {
    @Override
    public void doSometing(Human context) {
        System.out.println("Working...");
        context.setState(new WeekEnd());
    }
}
class WeekEnd implements Activity {
    private int count = 0;
    @Override
    public void doSometing(Human context) {
        if (count < 3) {
            count++;
            System.out.println("relaxing time");
        }
        else {
            context.setState(new Work());
        }
    }
}



//State
interface Station{
    void play();
}

class Radio7 implements Station {
    @Override
    public void play() {
        System.out.println("Radio 7...");
    }
}
class  RadioDFM implements Station {
    @Override
    public void play() {
        System.out.println("Radio DFM...");
    }
}
class VestiFM implements Station {
    @Override
    public void play() {
        System.out.println("Vesti FM...");
    }
}

//Context
class Radio {
    Station station;
    public void setStation(Station station) {
        this.station = station;
    }
    void nextStation() {
        if(station instanceof Radio7) {
            setStation(new RadioDFM());
        }
        else if(station instanceof RadioDFM) {
            setStation(new VestiFM());
        }
        else if(station instanceof VestiFM) {
            setStation(new Radio7());
        }
    }
    void play(){
        station.play();
    }
}
