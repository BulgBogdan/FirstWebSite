package dao;

import beans.AdsEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.SessionUtil;

import java.util.List;

public class AdsDAO extends SessionUtil implements IDAO<AdsEntity> {
    @Override
    public boolean create(AdsEntity entity) {
        openTransactionSession();
        Session session = getSession();
        session.save(entity);
        if (session == null) {
            return false;
        }
        closeTransactionSession();
        return true;
    }

    @Override
    public AdsEntity read(int id) {
        openTransactionSession();
        String sql = ("from AdsEntity where id = " + id);
        Session session = getSession();
        Query query = session.createQuery(sql);
        AdsEntity ads = (AdsEntity) query.uniqueResult();
        closeTransactionSession();
        return ads;
    }

    @Override
    public AdsEntity read(String animal, String breed) {
        openTransactionSession();
        String hql = ("from AdsEntity where animal = '" + animal + "'" + " or breed = '" + breed + "'");
        Session session = getSession();
        Query query = session.createQuery(hql);
        AdsEntity ads = (AdsEntity) query.uniqueResult();
        closeTransactionSession();
        return ads;
    }


    @Override
    public boolean update(AdsEntity entity) {
        openTransactionSession();
        Session session = getSession();
        session.update(entity);
        if (session == null) {
            return false;
        }
        closeTransactionSession();
        return true;
    }

    @Override
    public boolean delete(AdsEntity entity) {
        openTransactionSession();
        Session session = getSession();
        session.delete(entity);
        if (session == null) {
            return false;
        }
        closeTransactionSession();
        return true;
    }

    @Override
    public List<AdsEntity> getAll() {
        openTransactionSession();
        String sql = "from AdsEntity";
        Session session = getSession();
        Query query = session.createQuery(sql);
        List<AdsEntity> ads = query.list();
        closeTransactionSession();
        return ads;
    }
}
