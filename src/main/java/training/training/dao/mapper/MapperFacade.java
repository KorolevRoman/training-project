package training.training.dao.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.training.model.Employee;
import training.training.model.Office;
import training.training.view.EmployeeView;
import training.training.view.OfficeView;

import java.util.List;

import static java.lang.Boolean.FALSE;

@Service
public class MapperFacade {
    private MapperFactory mapperFactory;

    @Autowired
    public MapperFacade() {
        mapperFactory = new DefaultMapperFactory.Builder().mapNulls(FALSE).build();
    }

    public <S, D> D map(S s, Class<D> aClass) {
        D d = mapperFactory.getMapperFacade().map(s, aClass);
        return d;
    }

    public <S, D> void map(S s, D d) {
        mapperFactory.getMapperFacade().map(s, d);
    }

    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().mapAsList(source, destinationClass);
    }
}
