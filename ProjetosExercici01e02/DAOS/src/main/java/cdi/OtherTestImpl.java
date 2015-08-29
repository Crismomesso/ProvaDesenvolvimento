package main.java.cdi;

import main.java.cdi.qualifier.OtherTest;

@OtherTest
public class OtherTestImpl implements TestInterface {

    @Override
    public void a() {
        System.out.println("Outra");
    }
}
