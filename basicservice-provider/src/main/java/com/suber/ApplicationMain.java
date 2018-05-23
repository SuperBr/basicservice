package com.suber;


import com.suber.api.ISequence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:dubbo.xml"})
public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext st = SpringApplication.run(ApplicationMain.class);
        ISequence iSequence = (ISequence) st.getBean("sequence");

        for (int i = 0; i < 10; i++) {
            System.out.println(iSequence.getDefaultSequence());
        }

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
