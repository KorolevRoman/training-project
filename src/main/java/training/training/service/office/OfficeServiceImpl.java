package training.training.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.training.view.OfficeView;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    public OfficeServiceImpl() {
    }

    @Override
    public List<OfficeView> offices() {
        List<OfficeView> officeViewList = new ArrayList<>();
        officeViewList.add(new OfficeView(1, "Главный", "ул. Свободы, 15", "8412454545", true));
        officeViewList.add(new OfficeView(2, "Обособленный", "ул. Гоголя, 25", "84124124251", true));
        return officeViewList;
    }

    @Override
    public OfficeView office(Integer id) {
        if (id == 1){
            return new OfficeView(1, "Главный", "ул. Свободы, 15", "8412454545", true);
        };
        if (id == 2){
            return new OfficeView(2, "Обособленный", "ул. Гоголя, 25", "84124124251", true);
        } else {
            return new OfficeView();
        }
    }


}
