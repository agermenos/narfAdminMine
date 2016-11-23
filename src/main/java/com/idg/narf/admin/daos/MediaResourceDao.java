package com.idg.narf.admin.daos;

import com.idg.narf.admin.pojos.MediaResourceEntity;
import com.idg.narf.admin.utils.DateHelper;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by agermenos on 11/22/16.
 */
@Repository("mediaResourceDao")
public class MediaResourceDao extends GeneralDao<MediaResourceEntity>{
@Autowired
private SessionFactory sessionFactory;
    @Transactional
    public List<MediaResourceEntity> getMediaResourcesByDate(String dateFrom, String dateTo){
        Query q=sessionFactory.getCurrentSession().createQuery("FROM MediaResourceEntity WHERE resourceDate>=:dateFrom AND resourceDate<=:dateTo");
        q.setParameter("dateFrom", DateHelper.stringToTimestamp(dateFrom));
        q.setParameter("dateTo", DateHelper.stringToTimestamp(dateTo));
        return q.list();
    }
    @Transactional
    public List<MediaResourceEntity> getAll(){
        return sessionFactory.getCurrentSession().createCriteria(MediaResourceEntity.class).list();
    }
}
