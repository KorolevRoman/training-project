package training.training.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.training.dao.mapper.MapperFacade;
import training.training.dao.organization.OrganizationDAO;
import training.training.model.Organization;
import training.training.view.OrganizationView;
import training.training.view.ResultView;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationDAO dao;
    private MapperFacade mapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO dao, MapperFacade mapper) {
       this.dao = dao;
       this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationView getOrganization(OrganizationView view) throws Exception {
        Organization organization = dao.loadByNameAndInn(view.name, view.inn, view.isActive);
        OrganizationView returnedView = mapper.map(organization, OrganizationView.class);
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
    public OrganizationView getOrganizationById(Integer id) throws Exception {
        Organization organization = dao.loadById(id);
        OrganizationView view = mapper.map(organization, OrganizationView.class);
        if(view != null) {
            return view;
        } else {
            throw new Exception("Not found id");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView addOrganization(OrganizationView view) {
        if(view != null){
            Organization organization = mapper.map(view, Organization.class);
            organization.setIsActive(true);
            dao.save(organization);
            return new ResultView("success");
        } else {
            throw new IllegalArgumentException("empty organization");
        }
    }

    @Override
    @Transactional()
    public ResultView updateOrganization(OrganizationView view) {
        if(view != null) {
            Organization organization = mapper.map(view, Organization.class);
            organization.setVersion(0);
            dao.update(organization);
            return new ResultView("success");
        } else {
            throw new IllegalArgumentException("empty organization");
        }
    }
}
