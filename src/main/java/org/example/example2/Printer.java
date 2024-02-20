package org.example.example2;

public class Printer extends Thread {
    @Override
    public void run() {
        try {
            print();
        }
        catch (InterruptedException e){
            throw new RuntimeException();
        }

    }

    void print() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + " " + this.getPriority());
                sleep(0);
            }
        }
    }
}
