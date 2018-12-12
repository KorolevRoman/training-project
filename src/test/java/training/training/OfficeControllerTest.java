package training.training;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import training.training.service.office.OfficeServiceImpl;
import training.training.view.OfficeView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
public class OfficeControllerTest {
    private final String URL = "http://localhost:8888/office/";
    private final Integer ID = 2;
    @Test
    public void getOfficeById() {
        OfficeView view = new OfficeView();
        String expectedValue;
        try {
            view = new OfficeServiceImpl().getOffice(ID);
            expectedValue = String.format("{data:%s}", view.toString());
        } catch (Exception e) {
            expectedValue = String.format("{error:%s}", e.getMessage());
        }
        RestTemplate rest = new RestTemplate();
        String actualValue = rest.getForObject(URL + ID, String.class);
        Assert.assertEquals(expectedValue, actualValue);

    }
}
