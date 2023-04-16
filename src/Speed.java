import java.util.Random;

public class Speed extends Thread{
    static double v = 1;
    int z = 0;
    int r = 0;
    int vv = 0;
    double finalV;
    static double t = 0;
    static boolean check = true;

    public void run(){
        while (check != false){
            try{
                sleep(1000);
            }catch(InterruptedException e){}
            if (Navigator.rS > 0){
                if(v < 45.0){
                    vv = (int) (new Random().nextInt(20 - 10) + 10);
                    v+=vv;
                    finalV = v;
                }
                else{
                    v = finalV;
                    z = (int) (Math.random() * 4);
                    r = (int) (Math.random() * 3);
                    if (z % 2 == 0) v -= r;
                    else v += r;
                }
                t= v*0.0003;
                System.out.println("Скорость: " + v + " км/ч");
            }
            else check = false;
        }
    }
}
