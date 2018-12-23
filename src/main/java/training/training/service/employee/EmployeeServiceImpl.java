package training.training.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.training.view.EmployeeView;
import training.training.view.ResultView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeServiceImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeView getEmployeeById(Integer id) throws Exception {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeView getEmployeeById(EmployeeView view) throws Exception {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView addEmployee(EmployeeView view) throws Exception {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView updateEmployee(EmployeeView view) throws Exception {
        return null;
    }
}
