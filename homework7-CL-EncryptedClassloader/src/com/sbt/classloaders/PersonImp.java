package com.sbt.classloaders;

import com.sbt.classloaders.Person;

public class PersonImp  implements Person {

    @Override
    public void hello() {
        System.out.println("Hello!");
    }
}
