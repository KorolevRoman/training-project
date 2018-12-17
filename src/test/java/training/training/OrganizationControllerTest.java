package training.training;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import training.training.view.OrganizationView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
public class OrganizationControllerTest {
    private final String URL = "http://localhost:8888/organization/list";
    private final Integer ID = 2;
    @Test
    public void getOrganizationById() {
        RestTemplate rest = new RestTemplate();
        OrganizationView actualValue = rest.postForObject(URL,new OrganizationView(1, "dfsdfd", "581243562945", true),OrganizationView.class);
        System.out.println(actualValue);
    }
}
