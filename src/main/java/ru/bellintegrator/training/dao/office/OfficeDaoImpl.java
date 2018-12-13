package ru.bellintegrator.training.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.training.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> allWithOrgId(Long orgId) {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o WHERE o.org_id = :orgId", Office.class);
        query.setParameter("orgId", orgId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> allWithId(Long Id) {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o WHERE o.id = :Id", Office.class);
        query.setParameter("Id", Id);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Office office) throws Exception{
        if(office.getId() == null){
            throw new Exception("id can not be null");
        }
        em.merge(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }
}

