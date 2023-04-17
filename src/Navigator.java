import java.util.ArrayList;

public class Navigator extends Thread{
    ArrayList s = new ArrayList<Double>();
    ArrayList t = new ArrayList<Double>();
    double averageSpeed = 0.0;
    double S = 0.0;
    double aT = 0.0;
    double aS = 0.0;
    static double rS = 1;

    public void run(){
        while (Speed.check != false){
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            S = Speed.v*Speed.t;
            s.add(S);
            t.add(Speed.t);
            for (int i = 0; i<s.size(); i++){
                aS+=(Double) s.get(i);
            }
            for (int i = 0; i<t.size(); i++){
                aT+=(Double) t.get(i);
            }
            averageSpeed = aS/aT;
            System.out.println("Средняя скорость: " + averageSpeed + " км/ч");
            rS = Main.S - aS;
            if (rS > 0){
                System.out.println("Остаток пути: " + rS + " км");
                System.out.println("Осталось времени: " + (rS/averageSpeed)+ " ч");
            }
            else{
                Speed.check = false;
                System.out.println("Вы доехали до места назначения");
            }
        }
    }
}
