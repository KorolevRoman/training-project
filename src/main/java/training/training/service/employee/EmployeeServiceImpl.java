package training.training.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.training.dao.citizenship.CitizenshipDAO;
import training.training.dao.document.DocumentDAO;
import training.training.dao.employee.EmployeeDAO;
import training.training.dao.mapper.MapperFacade;
import training.training.dao.office.OfficeDAO;
import training.training.dao.typeOfDocument.TypeOfDocumentDAO;
import training.training.model.Document;
import training.training.model.Employee;
import training.training.model.TypeOfDocument;
import training.training.view.DocumentView;
import training.training.view.EmployeeView;
import training.training.view.ResultView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * {@inheritDoc}
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO dao;
    private OfficeDAO officeDAO;
    private CitizenshipDAO citizenshipDAO;
    private DocumentDAO docDAO;
    private TypeOfDocumentDAO typeDAO;
    private MapperFacade mapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    public EmployeeServiceImpl(EmployeeDAO dao, OfficeDAO officeDAO, CitizenshipDAO citizenshipDAO, DocumentDAO docDAO, TypeOfDocumentDAO typeDAO, MapperFacade mapper) {
        this.dao = dao;
        this.officeDAO = officeDAO;
        this.citizenshipDAO = citizenshipDAO;
        this.docDAO = docDAO;
        this.typeDAO = typeDAO;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeView getEmployeeById(Integer id) throws Exception {
        Employee employee = dao.loadById(id);
        Set documentViews = new HashSet<DocumentView>();
        if (employee != null) {
            for (Document document : employee.getDocuments()) {
                DocumentView documentView = mapper.map(document, DocumentView.class);
                documentView.dateIssue = sdf.format(document.getDateIssue());
                documentView.codeOfDocument = document.getTypeOfDocument().getCode();
                documentView.typeOfDocument = document.getTypeOfDocument().getName();
                documentViews.add(documentView);
            }
            EmployeeView view = mapper.map(employee, EmployeeView.class);
            view.citizenshipCode = employee.getCitizenship().getCode();
            view.citizenshipName = employee.getCitizenship().getName();
            view.documents = documentViews;
            return view;
        } else {
            throw new Exception("Not found id");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeView getEmployeeByFilter(EmployeeView view) throws Exception {
        Employee employee = mapper.map(view, Employee.class);
        return mapper.map(dao.loadByFilter(employee), EmployeeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultView addEmployee(EmployeeView view) throws Exception{
        if (view != null) {
            Employee employee = new Employee(view.firstName, view.secondName, view.middleName, view.position);
            citizenshipDAO.loadByCode(view.citizenshipCode).addEmployee(employee);
            employee.setOffice(officeDAO.loadById(view.officeId));
            dao.save(employee);
            for (DocumentView docView: view.documents) {
                TypeOfDocument type = typeDAO.loadByCode(docView.codeOfDocument);
                Document document = new Document(docView.number);
                document.setDateIssue(sdf.parse(docView.dateIssue));
                type.addDocument(document);
                employee.addDocument(document);
                docDAO.save(document);
            }
            return new ResultView("success");
        } else {
            throw new IllegalArgumentException("Not add an empty employee");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView updateEmployee(EmployeeView view) throws Exception {
        if (view !=null) {
            Employee employee = mapper.map(view, Employee.class);
            employee.setVersion(0);
            dao.update(employee);
            return new ResultView("success");
        } else {
            throw new IllegalArgumentException("Not update an empty employee");
        }
    }
}
