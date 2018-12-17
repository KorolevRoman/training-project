package training.training.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.training.view.OrganizationView;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    List<OrganizationView> organizationViewList = new ArrayList<>();

    @Autowired
    public OrganizationServiceImpl() {
        organizationViewList.add(new OrganizationView(1, "Тройка", "ООО Тройка", "581243562945", "582341001", "ул. Гоголя, 15",
                "89324243412", true));
        organizationViewList.add(new OrganizationView(2, "Землекопы", "ООО Землекопы", "581243536942", "582241001", "ул. Победы, 24",
                "89376543412", true));
        organizationViewList.add(new OrganizationView(3, "Тройка", "Тройка-Инвест", "581243562945", "582341001", "ул. Гоголя, 15",
                "89324242222", true));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationView getOrganizations(OrganizationView view) throws Exception {
        OrganizationView returnedView = new OrganizationView();
        for (OrganizationView orgView:organizationViewList) {
            if(orgView.name.equals(view.name) && orgView.inn.equals(view.inn) && orgView.isActive == view.isActive){
                returnedView = orgView;
            }
        }
        if(returnedView.id != null) {
            return returnedView;
        } else {
            throw new Exception("Not found organization");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationView getOrganization(Integer id) throws Exception {
        OrganizationView returnedView = new OrganizationView();
        for (OrganizationView view:organizationViewList) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String addOrganization(OrganizationView view) throws Exception {
        if(view != null){
            view.id = organizationViewList.size() + 1;
            organizationViewList.add(view);
            return "result : success";
        } else {
            throw new Exception("Not save in DB");
        }
    }
}
