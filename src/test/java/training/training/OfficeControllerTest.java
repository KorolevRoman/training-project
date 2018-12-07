package training.training;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import training.training.service.office.OfficeService;
import training.training.service.office.OfficeServiceImpl;
import training.training.view.OfficeView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)

public class OfficeControllerTest {
    private String URL = "http://localhost:8888/office/{id}";
    @Test
    public void getOfficeTest() {
        OfficeService officeService = new OfficeServiceImpl();
        OfficeView expectedOfficeView = officeService.office(1);

        RestTemplate rest = new RestTemplate();
        OfficeView officeView = rest.getForObject(URL, OfficeView.class, expectedOfficeView.id);

        Assert.assertEquals(expectedOfficeView.toString(), officeView.toString());
    }
}
