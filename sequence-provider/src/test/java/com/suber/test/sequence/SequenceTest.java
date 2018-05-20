package com.suber.test.sequence;

import com.suber.api.ISequence;
import com.suber.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SequenceTest extends TestBase {
    @Autowired
    private ISequence sequence;

    @Test
    public void defaultSequenceTest() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(Thread.currentThread().getName()+sequence.getDefaultSequence());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            },"Thread"+i+"    ").start();

        }
        while (true) {
            synchronized (this){
                this.wait();
            }
        }


    }
}
