package by.russianzak;

import by.russianzak.db.ConnectionManager;
import by.russianzak.db.impl.ConnectionManagerImpl;
import by.russianzak.repository.HouseEntityRepository;
import by.russianzak.repository.RoadSurfaceEntityRepository;
import by.russianzak.repository.StreetEntityRepository;
import by.russianzak.repository.impl.HouseEntityRepositoryImpl;
import by.russianzak.repository.impl.RoadSurfaceEntityRepositoryImpl;
import by.russianzak.repository.impl.StreetEntityRepositoryImpl;
import by.russianzak.repository.mapper.HouseResultSetMapper;
import by.russianzak.repository.mapper.HouseResultSetMapperImpl;
import by.russianzak.repository.mapper.RoadSurfaceResultSetMapper;
import by.russianzak.repository.mapper.RoadSurfaceResultSetMapperImpl;
import by.russianzak.repository.mapper.StreetResultSetMapper;
import by.russianzak.repository.mapper.StreetResultSetMapperImpl;
import by.russianzak.service.HouseEntityService;
import by.russianzak.service.RoadSurfaceEntityService;
import by.russianzak.service.StreetEntityService;
import by.russianzak.service.impl.HouseEntityServiceImpl;
import by.russianzak.service.impl.RoadSurfaceEntityServiceImpl;
import by.russianzak.service.impl.StreetEntityServiceImpl;
import by.russianzak.servlet.HouseEntityServlet;
import by.russianzak.servlet.RoadSurfaceEntityServlet;
import by.russianzak.servlet.StreetEntityServlet;
import by.russianzak.servlet.mapper.HouseEntityDtoMapper;
import by.russianzak.servlet.mapper.HouseEntityDtoMapperImpl;
import by.russianzak.servlet.mapper.RoadSurfaceEntityDtoMapper;
import by.russianzak.servlet.mapper.RoadSurfaceEntityDtoMapperImpl;
import by.russianzak.servlet.mapper.StreetEntityDtoMapper;
import by.russianzak.servlet.mapper.StreetEntityDtoMapperImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;


@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy")
            .create();
        ConnectionManager connectionManager = new ConnectionManagerImpl();
        HouseResultSetMapper houseResultSetMapper = new HouseResultSetMapperImpl();
        StreetResultSetMapper streetResultSetMapper = new StreetResultSetMapperImpl();
        RoadSurfaceResultSetMapper roadSurfaceResultSetMapper = new RoadSurfaceResultSetMapperImpl();
        HouseEntityRepository houseEntityRepository = new HouseEntityRepositoryImpl(houseResultSetMapper, streetResultSetMapper, connectionManager);
        StreetEntityRepository streetEntityRepository = new StreetEntityRepositoryImpl(houseResultSetMapper, streetResultSetMapper, roadSurfaceResultSetMapper, connectionManager);
        RoadSurfaceEntityRepository roadSurfaceEntityRepository = new RoadSurfaceEntityRepositoryImpl(roadSurfaceResultSetMapper, streetResultSetMapper, connectionManager);

        HouseEntityService houseEntityService = new HouseEntityServiceImpl(houseEntityRepository);
        StreetEntityService streetEntityService = new StreetEntityServiceImpl(streetEntityRepository);
        RoadSurfaceEntityService roadSurfaceEntityService = new RoadSurfaceEntityServiceImpl(roadSurfaceEntityRepository);

        HouseEntityDtoMapper houseEntityDtoMapper = new HouseEntityDtoMapperImpl();
        StreetEntityDtoMapper streetEntityDtoMapper = new StreetEntityDtoMapperImpl();
        RoadSurfaceEntityDtoMapper roadSurfaceEntityDtoMapper = new RoadSurfaceEntityDtoMapperImpl();

        HouseEntityServlet houseEntityServlet = new HouseEntityServlet(houseEntityService, houseEntityDtoMapper, gson);
        StreetEntityServlet streetEntityServlet = new StreetEntityServlet(streetEntityService, streetEntityDtoMapper, gson);
        RoadSurfaceEntityServlet roadSurfaceEntityServlet = new RoadSurfaceEntityServlet(roadSurfaceEntityService, roadSurfaceEntityDtoMapper, gson);

        ServletContext servletContext = sce.getServletContext();
        ServletRegistration.Dynamic houseRegistration = servletContext.addServlet("house", houseEntityServlet);
        houseRegistration.addMapping("/houses/*");

        ServletRegistration.Dynamic streetRegistration = servletContext.addServlet("street", streetEntityServlet);
        streetRegistration.addMapping("/streets/*");

        ServletRegistration.Dynamic roadSurfaceRegistration = servletContext.addServlet("road-surface", roadSurfaceEntityServlet);
        roadSurfaceRegistration.addMapping("/road-surfaces/*");
    }
}
