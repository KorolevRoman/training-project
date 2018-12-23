package training.training.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.training.dao.mapper.MapperFacade;
import training.training.dao.office.OfficeDAO;
import training.training.dao.office.OfficeDAOImpl;
import training.training.dao.organization.OrganizationDAO;
import training.training.model.Office;
import training.training.view.OfficeView;
import training.training.view.ResultView;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private OfficeDAO dao;
    private OrganizationDAO orgDAO;
    private MapperFacade mapper;


    @Autowired
    public OfficeServiceImpl(OfficeDAO dao, OrganizationDAO orgDAO, MapperFacade mapper) {
        this.dao = dao;
        this.orgDAO = orgDAO;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OfficeView getOfficeById(Integer id) throws Exception {
        OfficeView view = mapper.map(dao.loadById(id), OfficeView.class);
        if(view !=null) {
            return view;
        } else {
            throw new Exception("Not found id");
        }
    }

    @Override
    public List<OfficeView> getOfficeByOrg(Integer orgId) throws Exception {
        List<OfficeView> offices = mapper.mapAsList(dao.loadByOrgId(orgId), OfficeView.class);
        if((offices != null) && (!offices.isEmpty())){
            return offices;
        } else {
            throw new Exception("Not find offices by ID of Organization");
        }
    }

    @Override
    @Transactional
    public ResultView addOffice(OfficeView view) throws Exception {
        if(view !=null) {
            Office office = mapper.map(view, Office.class);
            office.setOrganization(orgDAO.loadById(view.orgId));
            dao.save(office);
            return new ResultView("success");
        } else {
            throw new Exception("Not add an empty office");
        }
    }

    @Override
    @Transactional
    public ResultView updateOffice(OfficeView view) throws Exception {
        if(view !=null) {
            Office office = mapper.map(view, Office.class);
            office.setOrganization(dao.loadById(view.id).getOrganization());
            dao.update(office);
            return new ResultView("success");
        } else {
            throw new Exception("Not update an empty office");
        }
    }
}
