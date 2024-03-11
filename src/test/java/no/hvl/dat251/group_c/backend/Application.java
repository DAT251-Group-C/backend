package no.hvl.dat251.group_c.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import no.hvl.dat251.group_c.backend.controllers.HealthController;

@SpringBootTest
class Application {

    @Autowired
    private HealthController healthController;

    @Test
    void contextLoads() {
        assert healthController != null;
    }

}
