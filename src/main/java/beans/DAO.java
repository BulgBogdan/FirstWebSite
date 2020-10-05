package beans;

public class HibernateDAO {

    public static HibernateDAO instance;

    public  UsersDAOHibernate user;
    public  RolesDAOHibernate role;
    public  AdsDAOHibernate ads;

    public HibernateDAO() {
    }

    public static HibernateDAO getInstance(){
        if (instance == null){
            synchronized (HibernateDAO.class){
                if (instance == null){
                    instance = new HibernateDAO();
                    instance.user = new UsersDAOHibernate();
                    instance.role = new RolesDAOHibernate();
                    instance.ads = new AdsDAOHibernate();
                }
            }
        }
        return instance;
    }
}
