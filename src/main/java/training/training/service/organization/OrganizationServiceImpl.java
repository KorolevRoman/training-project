package training.training.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.training.dao.mapper.MapperFacade;
import training.training.dao.organization.OrganizationDAO;
import training.training.model.Organization;
import training.training.view.OrganizationView;

import java.util.ArrayList;
import java.util.List;

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
    public OrganizationView getOrganizations(OrganizationView view) throws Exception {
        Organization organization = dao.loadByNameAndInn(view.name, view.inn);
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
    public OrganizationView getOrganization(Integer id) throws Exception {
        Organization organization = dao.loadById(id);
        OrganizationView view = mapper.map(organization, OrganizationView.class);
        if(view.id != null) {
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
    public String addOrganization(OrganizationView view) throws Exception {
        if(view != null){
            Organization organization = mapper.map(view, Organization.class);
            dao.save(organization);
            return "result : success";
        } else {
            throw new Exception("Not save in DB");
        }
    }
}
