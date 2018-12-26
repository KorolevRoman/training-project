package training.training;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import training.training.controller.wrapper.WrapperObj;
import training.training.dao.mapper.MapperFacade;
import training.training.view.OfficeView;
import training.training.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
public class OfficeControllerTest {
    private final String URL = "http://localhost:8888/office/";
    private final String SAVE = "save";
    private final String LIST = "list/";
    private final String UPDATE = "update";
    private final Integer ID = 1;
    private final OfficeView view = new OfficeView("Тест", 1,"Тестовый адрес", "89993334422", TRUE);
    private final MapperFacade mapper = new MapperFacade();
    private RestTemplate rest = new RestTemplate();


    @Test
    public void addOffice() {
        WrapperObj result = rest.postForObject(URL +SAVE, view, WrapperObj.class);
        ResultView resultView = mapper.map(result.getData(), ResultView.class);
        Assert.assertNotNull(resultView);
        Assert.assertEquals("success",resultView.result);
    }
    @Test
    public void getOfficeById() {
        WrapperObj result = rest.getForObject(URL + ID, WrapperObj.class);
        OfficeView view = mapper.map(result.getData(), OfficeView.class);
        Assert.assertNotNull(view);
        Assert.assertEquals(ID, view.id);
    }

    @Test
    public void getOfficeByOrgId(){
        WrapperObj<List> result = rest.postForObject(URL + LIST + ID, view, WrapperObj.class);
        List<OfficeView> list = new ArrayList<>();
        for (Object o: result.getData()) {
            list.add(mapper.map(o, OfficeView.class));
        }
        mapper.map(result.getData(), list);
        Assert.assertNotNull(result);
        Assert.assertTrue(!list.isEmpty());
    }

    @Test
    public  void updateOffice(){
        WrapperObj resultById = rest.getForObject(URL+ ID, WrapperObj.class);
        OfficeView expectedView = mapper.map(resultById.getData(), OfficeView.class);
        expectedView.orgId = ID;
        expectedView.name = expectedView.name + UPDATE;
        rest.postForObject(URL + UPDATE, expectedView, WrapperObj.class);
        WrapperObj result = rest.getForObject(URL + expectedView.id, WrapperObj.class);
        OfficeView actualView = mapper.map(result.getData(), OfficeView.class);
        Assert.assertNotNull(actualView);
        Assert.assertEquals(expectedView.name, actualView.name);
    }
}
