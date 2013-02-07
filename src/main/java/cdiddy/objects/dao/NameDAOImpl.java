/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdiddy.objects.dao;

import cdiddy.objects.Name;
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
@Repository("nameDAO")
@Transactional
public class NameDAOImpl implements NameDAO 
{

    private HibernateTemplate hibernateTemplate;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    @Transactional(readOnly = false)
    
    public void saveName(Name n) 
    {
         hibernateTemplate.saveOrUpdate(n);
    }

    @Transactional(readOnly = false)
    
    public void saveNames(List<Name> listN) {
         hibernateTemplate.saveOrUpdateAll(listN);
    }

    
    public List<Name> getNames() {
          return (List<Name>) hibernateTemplate.find("from "
                + Name.class.getName());
    }

    
    public Name geNameById(int nameId) 
    {
        return hibernateTemplate.get(Name.class, nameId);
    }

    
    @Transactional(readOnly = false)
    public void deleteName(Name n) {
        hibernateTemplate.delete(n);
    }

    
    @Transactional(readOnly = false)
    public void clearNames() {
         hibernateTemplate.deleteAll(hibernateTemplate.loadAll(Name.class));
    }
    
}
