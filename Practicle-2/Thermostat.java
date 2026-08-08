
public class Thermostat {

    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

  
    public Thermostat(String location, int startTemp) {
        this.location = location;

        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }
        activeCount++;
    }

    public void raise(){
        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (30)");
        }
    }

    public void lower() {
        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (16)");
        }

    }

    public int getTemperature() {
        return temperature;
    }

    public static int getActiveCount() {
        return activeCount;
    }
    public static void main(String[] args){
        Thermostat th1 = new Thermostat("classRoom", 22);
        System.out.println("Temperature: " + th1.getTemperature());

        System.out.println("Raising Temperature:");
        for (int i = 0; i < 10; i++) {
            th1.raise();
            System.out.println("Temperature: " + th1.getTemperature());
        }
        System.out.println("\nLowering Temperature:");
        for (int i = 0; i < 20; i++) {  
            th1.lower();
            System.out.println("Temperature: " + th1.getTemperature());
        }   
   
    }}

    

