package beans;

import org.hibernate.Query;
import org.hibernate.Session;
import utils.SessionUtil;

import java.util.List;

public class RolesDAOHibernate extends SessionUtil implements IHibernateDAO<RolesEntity> {
    @Override
    public boolean create(RolesEntity entity) {
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
    public RolesEntity read(int id) {
        openTransactionSession();
        String sql = ("from RolesEntity where id = " + id);
        Session session = getSession();
        Query query = session.createQuery(sql);
        RolesEntity role = (RolesEntity) query.uniqueResult();
        closeTransactionSession();
        return role;
    }

    @Override
    public RolesEntity read(String login, String password) {
        return null;
    }

    @Override
    public boolean update(RolesEntity entity) {
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
    public boolean delete(RolesEntity entity) {
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
    public List<RolesEntity> getAll() {
        openTransactionSession();
        String sql = "from UsersEntity";
        Session session = getSession();
        Query query = session.createQuery(sql);
        List<RolesEntity> roles = query.list();
        closeTransactionSession();
        return roles;
    }
}
