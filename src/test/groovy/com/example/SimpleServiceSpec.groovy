package com.example

import com.github.starnowski.bmunit.extension.junit4.rule.BMUnitMethodRule
import org.jboss.byteman.contrib.bmunit.BMRule
import org.junit.Rule
import spock.lang.Specification


class SimpleServiceSpec extends Specification {

    @Rule
    public BMUnitMethodRule bmUnitMethodRule = new BMUnitMethodRule()

    @BMRule(name = "handle file not found",
            targetClass = "File",
            targetMethod = "<init>(String)",
            action = "throw new RuntimeException( \"Ha ha Byteman fooled you again!\" )"
    )
    def test() {
        File file = new File("C:\\tutorials\\src\\main\\resources\\lwk.txt");
        System.out.println(file.length());
        expect:
        1 == 1
    }
}