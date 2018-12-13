package ru.bellintegrator.training.dao.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.training.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    private final EntityManager em;

    @Autowired
    public ClientDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> allWithOfficeId(Long officeId) {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.office_id = :officeId", Client.class);
        query.setParameter("officeId", officeId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> allWithId(Long id) {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.id = :Id", Client.class);
        query.setParameter("Id", id);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Client client) throws Exception{
        if(client == null){
            throw new Exception("id can not be null");
        }
        em.merge(client);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Client client) {
        em.persist(client);
    }
}


