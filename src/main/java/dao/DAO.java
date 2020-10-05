package dao;

public class DAO {

    public static DAO instance;

    public UsersDAO user;
    public RolesDAO role;
    public AdsDAO ads;

    public DAO() {
    }

    public static DAO getInstance(){
        if (instance == null){
            synchronized (DAO.class){
                if (instance == null){
                    instance = new DAO();
                    instance.user = new UsersDAO();
                    instance.role = new RolesDAO();
                    instance.ads = new AdsDAO();
                }
            }
        }
        return instance;
    }
}
