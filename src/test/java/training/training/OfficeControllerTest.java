package training.training;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import training.training.controller.wrapper.WrapperObj;
import training.training.dao.mapper.MapperFacade;
import training.training.service.office.OfficeServiceImpl;
import training.training.view.OfficeView;
import training.training.view.ResultView;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
public class OfficeControllerTest {
    private final String URL = "http://localhost:8888/office/";
    private final String SAVE = "save";
    private final String LIST = "list/";
    private final String UPDATE = "update";
    private final Integer ID = 1;
    private final OfficeView view = new OfficeView("Тест", 1,"Тестовый адрес", "89993334422", true);
    private RestTemplate rest = new RestTemplate();

    @Test
    public void addOffice() {
        WrapperObj result = rest.postForObject(URL +SAVE, view, WrapperObj.class);
        MapperFacade mapperFacade = new MapperFacade();
        ResultView resultView = mapperFacade.map(result.getData(), ResultView.class);
        Assert.assertNotNull(resultView);
        Assert.assertEquals("success",resultView.result);
    }
    @Test
    public void getOfficeById() {
        WrapperObj result = rest.getForObject(URL + ID, WrapperObj.class);
        MapperFacade mapperFacade = new MapperFacade();
        OfficeView view = mapperFacade.map(result.getData(), OfficeView.class);
        Assert.assertNotNull(view);
        Assert.assertEquals(ID, view.id);
    }

    @Test
    public void getOfficeByOrgId(){
    }
}
