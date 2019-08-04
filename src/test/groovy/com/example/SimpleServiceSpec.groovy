package com.example


import org.jboss.byteman.contrib.bmunit.BMRule
import org.jboss.byteman.contrib.bmunit.WithByteman
import spock.lang.Specification
@WithByteman
@BMRule(name = "handle file not found",
        targetClass = "File",
        targetMethod = "<init>(String)",
        action = "throw new RuntimeException( \"Ha ha Byteman fooled you again!\" )"
)
class SimpleServiceSpec extends Specification {


    def test(){
        File file = new File("C:\\tutorials\\src\\main\\resources\\lwk.txt");
        System.out.println(file.length());
        expect:
        1==1
    }
}