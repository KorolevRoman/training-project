package training.training;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import training.training.controller.wrapper.WrapperObj;
import training.training.dao.mapper.MapperFacade;
import training.training.view.OrganizationView;
import training.training.view.ResultView;

import static java.lang.Boolean.TRUE;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
public class OrganizationControllerTest {
    private final String URL = "http://localhost:8888/organization/";
    private final String SAVE = "save";
    private final String UPDATE = "update";
    private final String LIST = "list";
    private final Integer ID = 1;
    private final OrganizationView view = new OrganizationView("ИмяТест", "ПолноеИмяТест", "585858585858", "123456789", "ТестовыйАдрес", TRUE);
    private final MapperFacade mapper = new MapperFacade();

    private OrganizationView viewWithId;
    private RestTemplate rest = new RestTemplate();

    @Test
    public void addOrganization(){
        ResponseEntity<WrapperObj> resultView= rest.postForEntity(URL + SAVE, view, WrapperObj.class);
        String str = resultView.getBody().toString();
        Assert.assertNotNull(str);
        Assert.assertTrue(str.contains("success"));
    }
    @Test
    public void getOrganization(){
        WrapperObj<OrganizationView> result = rest.postForObject(URL+ LIST, view, WrapperObj.class);
        OrganizationView actualView = mapper.map(result.getData(), OrganizationView.class);
        Assert.assertNotNull(actualView);
        Assert.assertEquals(view.fullName, actualView.fullName);
    }

    @Test
    public void getOrganizationById() {
        WrapperObj<OrganizationView> result = rest.postForObject(URL+ LIST, view, WrapperObj.class);
        viewWithId = mapper.map(result.getData(), OrganizationView.class);
        WrapperObj<OrganizationView> resultById = rest.getForObject(URL+ viewWithId.id, WrapperObj.class);
        OrganizationView actualView = mapper.map(resultById.getData(), OrganizationView.class);
        Assert.assertNotNull(actualView);
        Assert.assertEquals(viewWithId.id, actualView.id);
    }

    @Test
    public void updateOrganization(){
        WrapperObj<OrganizationView> resultById = rest.getForObject(URL+ ID, WrapperObj.class);
        OrganizationView expectedView = mapper.map(resultById.getData(), OrganizationView.class);
        expectedView.name = expectedView.name + UPDATE;
        WrapperObj<OrganizationView> result = rest.postForObject(URL+ UPDATE, expectedView, WrapperObj.class);
        OrganizationView actualView = mapper.map(result.getData(), OrganizationView.class);
        Assert.assertNotNull(actualView);
        Assert.assertEquals(expectedView.name, actualView.name);
    }

}
