package training.training.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.training.view.OfficeView;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private List<OfficeView> officeViewList = new ArrayList<>();


    @Autowired
    public OfficeServiceImpl() {
        officeViewList.add(new OfficeView(1,"Главный","ул. Свободы, 15","8412454545",true));
        officeViewList.add(new OfficeView(2,"Обособленный","ул. Гоголя, 25","84124124251",true));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OfficeView> offices() {
        return officeViewList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OfficeView getOffice(Integer id) throws Exception {
        OfficeView returnedView = new OfficeView();
        for (OfficeView view : officeViewList) {
            if(id == view.id){
                returnedView = view;
            }
        }
        if(returnedView.id != null) {
            return returnedView;
        } else {
            throw new Exception("Not found id");
        }
    }
}
