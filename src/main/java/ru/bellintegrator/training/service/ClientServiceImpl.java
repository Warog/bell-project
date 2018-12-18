package ru.bellintegrator.training.service;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.training.model.Client;
import ru.bellintegrator.training.view.ClientView;


import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class ClientServiceImpl implements ClientService {
//    private final ClientDao dao;
//    private final MapperFacade mapperFacade;

//    @Autowired
//    public ClientServiceImpl(ClientDao dao, MapperFacade mapperFacade) {
//        this.dao = dao;
//        this.mapperFacade = mapperFacade;
//    }

    private Client client = new Client("Иван", "Иванов", "Иванович", "Охранник", "234567", Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), true);
    private ClientView clientView = new ClientView();
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(ClientView view) {
        Client client = new Client(view.name, view.secondName, view.middleName, view.post, view.phone, Long.valueOf(view.office_id), Long.valueOf(view.document_id), Long.valueOf(view.citizenship_id), view.isIdentified);
//        dao.save(client);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ClientView clientView(){
//        Client client = new Client(clientView().name, clientView().secondName, clientView().middleName, clientView().post, clientView().phone, Long.valueOf(clientView().office_id), Long.valueOf(clientView().document_id), Long.valueOf(clientView().citizenship_id), clientView().isIdentified);
        System.out.println(client.getFiristName());

        return clientView();
    }

}

