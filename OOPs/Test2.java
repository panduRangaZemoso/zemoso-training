public class Test2 {

    public static void main(String[] args){
        Clock c1 = new WallClock(11, 59, 59);
        Clock c2 = new WallClock(14, 59, 59);

        Clock c3 = new DigitalClock(11, 59, 59);
        Clock c4 = new DigitalClock(14, 59, 59);

        c1.showTime();
        c2.showTime();
        c3.showTime();
        c4.showTime();

        c1.showTime(22,22,22);
        c3.showTime(9,18,19);

    }

}

class DigitalClock extends Clock{

    public DigitalClock(int hour, int minute, int seconds) {
        super(hour, minute, seconds);
    }

    @Override
    public void showTime() {
        int hourHand = this.getHour();
        String meridiem = "AM";
        if(this.getHour() > 12){
            hourHand = this.getHour()-12;
            meridiem = "PM";
        }
        System.out.println(hourHand+":"+ this.getMinute()+":"+this.getSeconds()+ meridiem);
    }

    @Override
    void showTime(int hour, int minute, int seconds) {
        Clock c = new DigitalClock(hour, minute, seconds);
        c.showTime();
    }

}

//INHERITENCE
class WallClock extends Clock{

    public WallClock(int hour,  int minute, int seconds) {
        super(hour, minute, seconds);
    }

    @Override
    public void showTime(){
        int hourHand = this.getHour();
        if(this.getHour() > 12){
            hourHand = this.getHour()-12;
        }
        System.out.println("hourHand :"+ hourHand+" minuteHand :"+ this.getMinute()+" secondHand :"+this.getSeconds());
    }

    @Override
    void showTime(int hour, int minute, int seconds) {
        Clock c = new WallClock(hour, minute, seconds);
        c.showTime();
    }
}


abstract class Clock{
    private int hour;
    private int minute;
    private int seconds;

    public Clock(int hour, int minute, int seconds) {
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
    }


    // ABSTRACTION
    abstract void showTime();
    abstract void showTime(int hour, int minute, int seconds);  // METHOD OVERLOADING(POLYMORPHISM)

    public int getHour() {
        return hour;
    }

    //ENCAPSULATION
    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinute() {
        return minute;
    }

    public int getSeconds() {
        return seconds;
    }
}