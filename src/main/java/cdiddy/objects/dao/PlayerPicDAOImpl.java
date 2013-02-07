/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdiddy.objects.dao;

import cdiddy.objects.PlayerPic;
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
@Repository("PlayerPicDAO")
public class PlayerPicDAOImpl implements PlayerPicDAO
{
    
    private HibernateTemplate hibernateTemplate;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    @Transactional(readOnly = false)
    
    public void savePlayerPic(PlayerPic n) 
    {
         hibernateTemplate.saveOrUpdate(n);
    }

    @Transactional(readOnly = false)
    
    public void savePlayerPics(List<PlayerPic> listN) {
         hibernateTemplate.saveOrUpdateAll(listN);
    }

    
    public List<PlayerPic> getPlayerPics() {
          return (List<PlayerPic>) hibernateTemplate.find("from "
                + PlayerPic.class.getName());
    }

    
    public PlayerPic gePlayerPicById(int PlayerPicId) 
    {
        return hibernateTemplate.get(PlayerPic.class, PlayerPicId);
    }

    
    @Transactional(readOnly = false)
    public void deletePlayerPic(PlayerPic n) {
        hibernateTemplate.delete(n);
    }

    
    @Transactional(readOnly = false)
    public void clearPlayerPics() {
         hibernateTemplate.deleteAll(hibernateTemplate.loadAll(PlayerPic.class));
    }
    
}
