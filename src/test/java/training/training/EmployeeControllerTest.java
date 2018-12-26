package training.training;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import training.training.controller.wrapper.WrapperObj;
import training.training.dao.mapper.MapperFacade;
import training.training.model.Document;
import training.training.model.Employee;
import training.training.view.DocumentView;
import training.training.view.EmployeeView;
import training.training.view.ResultView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainingApplication.class)
public class EmployeeControllerTest {
        private final String URL = "http://localhost:8888/employee/";
        private final String SAVE = "save";
        private final String LIST = "list/";
        private final String UPDATE = "update";
        private final Integer ID = 1;
        private final EmployeeView view = new EmployeeView("Тестов", "Тест", "Тестович", 1, "тестер", new HashSet<DocumentView>(), 643, "Россия");
        private final MapperFacade mapper = new MapperFacade();
        private RestTemplate rest = new RestTemplate();

        @Test
        public void addEmployee() {
        }

        @Test
        public void updateEmployee() {
        }

        @Test
        public void getEmployeeByFilter() {
        }

        @Test
        public void getEmployeeById() {
        }
}