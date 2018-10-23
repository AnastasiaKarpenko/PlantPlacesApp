package ws.tilda.anastasia.plantplacesapp;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import ws.tilda.anastasia.plantplacesapp.dao.NetworkDAO;

import static org.junit.Assert.assertEquals;

public class TestNetworkDAO {
    NetworkDAO networkDAO;

    @Before
    public void setUp() {
        networkDAO = new NetworkDAO();
    }

    @Test
    public void fetchShouldSucceedWhenGivenValidUri() throws IOException {
        String result = networkDAO.fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=akjdf;lajksdf");
        System.out.println(result);
        assertEquals("{\"plants\":[]}-1", result);
    }

}
