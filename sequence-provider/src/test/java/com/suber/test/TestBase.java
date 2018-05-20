package com.suber.test;

import com.suber.ApplicationMain;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ApplicationMain.class)
@RunWith(SpringRunner.class)
public abstract class TestBase {

}
