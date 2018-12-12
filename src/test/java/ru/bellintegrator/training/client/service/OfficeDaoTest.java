package ru.bellintegrator.training.client.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.training.Application;
import ru.bellintegrator.training.dao.office.OfficeDao;
import ru.bellintegrator.training.model.Client;
import ru.bellintegrator.training.model.Office;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeDaoTest {

    @Autowired
    private OfficeDao officeDao;

    @Test
    public void test() {
        Office office = new Office();
        Set<Client> list = new HashSet<>();
        office.setAddress("Address");
        Client client = new Client("Иван", "Иванов", "Иванович", "Охранник", "234567", Long.getLong("1"), true);
        client.addOffice(office);
        office.setClients(list);
        list.add(client);
        officeDao.save(office);

        List<Office> offices = officeDao.allWithId(Long.valueOf(1));
        Assert.assertNotNull(offices);

        client.addOffice(office);

        Assert.assertFalse(offices.isEmpty());

        Set<Client> clients = offices.get(1).getClient();

        Assert.assertNotNull(clients);
        Assert.assertEquals(1, clients.size());

        Client client1 = new Client("Максим", "Максимов", "Максимович", "Вождь", "5135135", Long.getLong("1"), true);
        list.add(client1);

        offices = officeDao.allWithOrgId(Long.valueOf(1));
        clients = offices.get(1).getClient();
        Assert.assertNotNull(client);
        Assert.assertEquals(1, clients.size());
    }
}