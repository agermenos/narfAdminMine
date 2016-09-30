package com.idg.narf.admin.daos;

import com.idg.narf.admin.pojos.ImageFileEntity;
import com.idg.narf.admin.pojos.ImageFileKey;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by agermenos on 9/28/16.
 */
@Repository("imageFileDao")
public class ImageFileDao  extends GeneralDao<ImageFileEntity>{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void add(ImageFileEntity entinty){
        sessionFactory.getCurrentSession().save(entinty);
    }

    @Transactional
    public void update(ImageFileEntity entity){
        sessionFactory.getCurrentSession().update(entity);
    }

    @Transactional
    public void delete(ImageFileEntity entity){
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Transactional
    public ImageFileEntity findByKey(ImageFileKey key){
        return sessionFactory.getCurrentSession().get(ImageFileEntity.class, key);
    }
    @Transactional
    public List<ImageFileEntity> findAboveKey(int imageId){
        Query q=sessionFactory.getCurrentSession().createQuery("FROM ImageFileEntity WHERE imageFileKey.image_id>:id");
        q.setParameter("id",100635664);
        return q.list();
    }
}
