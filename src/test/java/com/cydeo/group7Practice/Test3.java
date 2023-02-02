package com.cydeo.group7Practice;

import org.testng.annotations.Test;

public class Test3 {
    @Test
    public void os_test(){
       String system = System.getProperty("os.name");
        System.out.println(system);
    }
}
