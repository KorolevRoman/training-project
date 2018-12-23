package training.training.dao.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.training.model.Office;
import training.training.view.OfficeView;

import java.util.List;

@Service
public class MapperFacade {
    private MapperFactory mapperFactory;

    @Autowired
    public MapperFacade() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
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
