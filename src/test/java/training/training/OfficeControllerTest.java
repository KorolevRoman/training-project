package training.training;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import training.training.controller.office.OfficeController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
@RestClientTest(OfficeController.class)
public class OfficeControllerTest {
    @Test
    public void getOfficeTest() {

    }
}
