package training.training;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
public class OrganizationControllerTest {
    private String URL = "http://localhost:8888/organization/";
    @Test
    public void getOgranizationTest() {
        RestTemplate restTemplate = new RestTemplate();
        String expect ="{data:[{id: 2; name: Землекопы; fullName: ООО Землекопы; inn: 581243536942; kpp: 582241001; address: ул. Победы, 24; phone: 89376543412; isActive: true}]}";
        String requestString =  "Землекопы";
        String actual = restTemplate.postForObject(URL + "list", requestString, String.class);
        Assert.assertEquals(expect,actual);
    }
}
