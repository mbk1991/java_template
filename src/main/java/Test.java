package main.java;

public class Test extends Thread{

    static int share;
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();

        t1.start();
        t2.start();

    }

    @Override
    public void run(){
        for(int count = 0; count<10; count++){
            System.out.println(share++);

            try{
                sleep(3000);

            }catch(InterruptedException e){

            }
        }
    }
}
