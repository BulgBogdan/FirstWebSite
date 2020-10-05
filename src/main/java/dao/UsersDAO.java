package dao;

import beans.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.SessionUtil;

import java.util.List;

public class UsersDAO extends SessionUtil implements IDAO<UsersEntity> {


    @Override
    public boolean create(UsersEntity entity) {
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
    public UsersEntity read(int id) {
        openTransactionSession();
        String sql = ("from UsersEntity where id = " + id);
        Session session = getSession();
        Query query = session.createQuery(sql);
        UsersEntity user = (UsersEntity) query.uniqueResult();
        closeTransactionSession();
        return user;
    }

    @Override
    public UsersEntity read(String login, String password) {
        openTransactionSession();
        String hql = ("from UsersEntity where login = '" + login + "'" + " and password = '" + password + "'");
        Session session = getSession();
        Query query = session.createQuery(hql);
        UsersEntity user = (UsersEntity) query.uniqueResult();
        closeTransactionSession();
        return user;
    }

    @Override
    public boolean update(UsersEntity entity) {
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
    public boolean delete(UsersEntity entity) {
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
    public List<UsersEntity> getAll() {
        openTransactionSession();
        String sql = "from UsersEntity";
        Session session = getSession();
        Query query = session.createQuery(sql);
        List<UsersEntity> usersList = query.list();
        closeTransactionSession();
        return usersList;
    }
}
