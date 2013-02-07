/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdiddy.objects.dao;

import cdiddy.objects.ByeWeek;
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

@Repository("ByeWeekDAO")
@Transactional
public class ByeWeekDAOImpl implements ByeWeekDAO
{
        private HibernateTemplate hibernateTemplate;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    @Transactional(readOnly = false)
    
    public void saveByeWeek(ByeWeek bw) 
    {
         hibernateTemplate.saveOrUpdate(bw);
    }

    @Transactional(readOnly = false)
    
    public void saveByeWeeks(List<ByeWeek> listBW) 
    {
         hibernateTemplate.saveOrUpdateAll(listBW);
    }

    
    public List<ByeWeek> getByeWeeks() {
          return (List<ByeWeek>) hibernateTemplate.find("from "
                + ByeWeek.class.getName());
    }

    
    public ByeWeek geByeWeekById(int byeWeekId) 
    {
        return hibernateTemplate.get(ByeWeek.class, byeWeekId);
    }

    
    @Transactional(readOnly = false)
    public void deleteByeWeek(ByeWeek bw) 
    {
        hibernateTemplate.delete(bw);
    }

    
    @Transactional(readOnly = false)
    public void clearByeWeeks() 
    {
         hibernateTemplate.deleteAll(hibernateTemplate.loadAll(ByeWeek.class));
    }
    
}
