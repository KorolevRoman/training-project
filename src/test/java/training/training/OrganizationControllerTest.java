package training.training;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import training.training.service.organization.OrganizationServiceImpl;
import training.training.view.OrganizationView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
public class OrganizationControllerTest {
    private final String URL = "http://localhost:8888/organization/";
    private final Integer ID = 2;
    @Test
    public void getOrganizationById() {
        OrganizationView view = new OrganizationView();
        String expectedValue;
        try {
            view = new OrganizationServiceImpl().getOrganization(ID);
            expectedValue = String.format("{data:%s}", view.toString());
        } catch (Exception e) {
            expectedValue = String.format("{error:%s}", e.getMessage());
        }
        RestTemplate rest = new RestTemplate();
        String actualValue = rest.getForObject(URL + ID, String.class);
        Assert.assertEquals(expectedValue, actualValue);

    }
}
