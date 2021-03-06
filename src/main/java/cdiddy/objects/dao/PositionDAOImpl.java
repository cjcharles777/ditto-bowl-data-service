/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdiddy.objects.dao;

import cdiddy.objects.Position;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cedric
 */
@Repository("positionDAO")
@Transactional
public class PositionDAOImpl implements PositionDAO
{
        private HibernateTemplate hibernateTemplate;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    @Transactional(readOnly = false)
    
    public void savePosition(Position p) 
    {
         hibernateTemplate.saveOrUpdate(p);
    }

    @Transactional(readOnly = false)
    
    public void savePositions(List<Position> listN) {
         hibernateTemplate.saveOrUpdateAll(listN);
    }

    
    public List<Position> getPositions() {
          return (List<Position>) hibernateTemplate.find("from "
                + Position.class.getName());
    }

    
    public Position gePositionById(int positionId) 
    {
        return hibernateTemplate.get(Position.class, positionId);
    }

    
    @Transactional(readOnly = false)
    public void deletePosition(Position p) {
        hibernateTemplate.delete(p);
    }

    
    @Transactional(readOnly = false)
    public void clearPositions() {
         hibernateTemplate.deleteAll(hibernateTemplate.loadAll(Position.class));
    }
}
