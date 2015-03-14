package com.example.tim.sunshine;


/**
 * Created by Tim on 3/3/2015.
 */
public class WeatherInfo {
    private double High;
    private double Low;
    private String date;
    private double Pressure;
    private double Humidity;
    private String Description;
    private String Main;
    private double DayTemp;
    private double NightTemp;
    private static String Icon;
    private double Speed;
    private double Direction;
    //public static byte[] iconData;
    //private String Weather;


    public WeatherInfo()
    {
    }

   public WeatherInfo(double High, double Low, String date,
                      double Pressure,  double Humidity, String Icon, String Description,
                      String Main, double DayTemp, double NightTemp, double Speed, double Direction )
   {
        this.High = High;
        this.Low = Low;
        this.date = date;
        this.Pressure = Pressure;
        this.Humidity = Humidity;
        this.Description = Description;
        this.Main = Main;
        this.DayTemp = DayTemp;
        this.NightTemp = NightTemp;
        this.Icon = Icon;
        this.Speed = Speed;
        this.Direction = Direction;


    }


    public double getHigh() {
        return High;
    }

    public double getLow() {
        return Low;
    }

    public String getDate() {
        return date;
    }

    public void setHigh(double high) {
        High = high;
    }

    public void setLow(double low) {
        Low = low;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPressure() {
        return Pressure;
    }

    public void setPressure(double pressure) {
        Pressure = pressure;
    }

    public double getHumidity() {
        return Humidity;
    }

    public void setHumidity(double humidity) {
        Humidity = humidity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;

    }
   public String getMain() {
        return Main;
    }

    public void setMain(String Main ) {
        this.Main = Main;
    }
    public static String getIcon() {
        return Icon;
    }

    public void setIcon(String Icon ) {
        this.Icon = Icon;
    }
    public double getSpeed() {
        return Speed;
    }

    public void setSpeed(double speed) {
        Speed = speed;
    }

    public double getDirection() {
        return Direction;
    }

    public void setDirection(double direction) {
        Direction = direction;
    }
    public double getDayTemp() {
        return DayTemp;
    }

    public void setDayTemp(double dayTemp) {
        DayTemp = dayTemp;
    }

    public double getNightTemp() {
        return NightTemp;
    }

    public void setNightTemp(double nightTemp) {
        NightTemp = nightTemp;
    }



    @Override
    public String toString() {
        return "Date: " + date +
               "\nHigh: " + High + "°" +
               "\nLow: " + Low +"°";
    }

    public String getInfo() {
        return "Date: " + date +
                "\n"+ Main +
                "\n"+ Description +
                "\nHigh: " + High + "°" +
                "\nLow: " + Low + "°" +
                "\nDay Temperature: " + DayTemp + "°" +
                "\nNight Temperature: " + NightTemp +"°" +
                "\nHumidity: " + Humidity +
                "\nPressure: " + Pressure +
                "\nWind Speed: "+ Speed +
                "\nWind Direction in Degrees: " + Direction;



    }
}

