package training.training.service.organization;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.training.view.OrganizationView;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public List<OrganizationView> organizations() {
        List<OrganizationView> organizationViewList = new ArrayList<>();
        organizationViewList.add(new OrganizationView(1, "Тройка", "ООО Тройка", "581243562945", "582341001", "ул. Гоголя, 15",
                "89324243412", true));
        organizationViewList.add(new OrganizationView(2, "Землекопы","ООО Землекопы", "581243536942", "582241001", "ул. Победы, 24",
                "89376543412", true));

        return organizationViewList;
    }


    @Override
    public OrganizationView organization(Integer id) {
        if(id == 1){
             return new OrganizationView(1, "Тройка", "ООО Тройка", "581243562945", "582341001", "ул. Гоголя, 15",
                    "89324243412", true);
        }
        if(id == 2){
            return new OrganizationView(2, "Землекопы","ООО Землекопы", "581243536942", "582241001", "ул. Победы, 24",
                    "89376543412", true);
        } else {
            return new OrganizationView();
        }
    }
}
