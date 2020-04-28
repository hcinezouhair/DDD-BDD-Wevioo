package com.wevioo.demo.bdd.createUser;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/com/wevioo/demo/bdd/createUser/createUser.feature"
        },
        plugin = {"pretty", "html:target/cucumber"},
        strict = true,
        glue="com.wevioo.demo.bdd.createUser")
public class CreateTest {
}
