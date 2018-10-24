package ws.tilda.anastasia.plantplacesapp.plantplaces;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ws.tilda.anastasia.plantplacesapp.dao.BDDTestPlantDAO;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BDDTestPlantDAO.class,
        TestNetworkDAO.class
})

public class DAOTestSuite {
}
