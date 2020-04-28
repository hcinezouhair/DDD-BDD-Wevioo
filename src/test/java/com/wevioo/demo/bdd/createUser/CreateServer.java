package com.wevioo.demo.bdd.createUser;


import com.wevioo.demo.bdd.utils.ApiHelper;
import lombok.Getter;
import lombok.Setter;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class CreateServer {

    @Getter
    @Setter
    @LocalServerPort
    private int port;


    protected ApiHelper apiHelper;

    protected void setup() {
        apiHelper = new ApiHelper(port);
    }
}
