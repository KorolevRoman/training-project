package training.training.service.organization;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.training.view.OrganizationView;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> organizations() {
        List<OrganizationView> organizationViewList = new ArrayList<>();
        organizationViewList.add(new OrganizationView(1, "Тройка", "581243562945"));
        organizationViewList.add(new OrganizationView(2, "Землекопы", "581243536942"));
        organizationViewList.add(new OrganizationView(3, "ПоволжУправ", "581243561234"));
        return organizationViewList;
    }
}
