package ru.bellintegrator.training.service;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.training.model.Client;
import ru.bellintegrator.training.view.ClientView;
import ru.bellintegrator.training.dao.client.ClientDao;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public ClientServiceImpl(ClientDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(ClientView view) {
        Client client = new Client(view.name, view.secondName, view.middleName, view.post, view.phone, Long.valueOf(view.office_id), Long.valueOf(view.document_id), Long.valueOf(view.citizenship_id), view.isIdentified);
        dao.save(client);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ClientView> clients() {
        List<Client> all = dao.allWithId(Long.valueOf(1));
        return mapperFacade.mapAsList(all, ClientView.class);
    }
}

