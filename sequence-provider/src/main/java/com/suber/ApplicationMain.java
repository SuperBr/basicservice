package com.suber;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class);
        while (true) {
            synchronized (ApplicationMain.class) {
                try {
                    ApplicationMain.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
