package com.idg.narf.admin.daos;

import com.idg.narf.admin.pojos.ImageEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by agermenos on 10/12/16.
 */
@Repository ("imageEntityDao")
public class ImageEntityDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    public void add(ImageEntity entinty){
        sessionFactory.getCurrentSession().save(entinty);
    }

    @Transactional
    public void update(ImageEntity entity){
        sessionFactory.getCurrentSession().update(entity);
    }

    @Transactional
    public void delete(ImageEntity entity){
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Transactional
    public ImageEntity findByKey(Integer id){
        return sessionFactory.getCurrentSession().get(ImageEntity.class, id);
    }
}
