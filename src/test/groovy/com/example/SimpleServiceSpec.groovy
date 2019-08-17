package com.example

import com.github.starnowski.bmunit.extension.junit4.rule.BMUnitMethodRule
import org.jboss.byteman.contrib.bmunit.BMRule
import org.jboss.byteman.contrib.bmunit.BMUnitConfig
import org.junit.Rule
import spock.lang.Specification
import spock.mock.MockingApi

@BMUnitConfig(debug = true)
class SimpleServiceSpec extends Specification {

    @Rule
    public BMUnitMethodRule bmUnitMethodRule = new BMUnitMethodRule()


    @BMRule(name = "handle file not found",
            targetClass = "SimpleEntityBuilder",
            targetMethod = "newInstance()",
            targetLocation = "AT EXIT",
            action = "System.out.println(\$!);return spy()",
            helper = "com.example.SimpleServiceSpec"
    )
    def test() {
        SimpleService s = new SimpleService()
        SimpleEntity create = s.create()
        SimpleEntity ss=Mock(SimpleEntity)
        when:


        println " aha=" + create.getName()
        then:
        1 * create.getName()
        1 == 1
    }

    SimpleEntity spy() {
        SimpleEntity s=Mock(SimpleEntity)
        return s
    }

}
