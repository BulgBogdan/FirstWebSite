package controller;

import beans.AdsEntity;
import beans.UsersEntity;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UsersEntity sessionUser = (UsersEntity) session.getAttribute("user");
        try {
            if ((Form.isPost(request) && (request.getParameter("logout") != null)) || sessionUser == null) {
                session.invalidate();
                return Actions.LOGIN.command;
            }
            DAO dao = DAO.getInstance();
            if (sessionUser != null) {
                UsersEntity user = dao.user.read(sessionUser.getId());
                request.setAttribute("user", user);
                if (request.getParameter("Update") != null) {
                    UsersEntity userUpdate = new UsersEntity(
                            Form.getInt(request, "id"),
                            sessionUser.getRole(),
                            sessionUser.getAds(),
                            Form.getString(request, "login", Pattern.LOGIN),
                            Form.getString(request, "password", Pattern.PASSWORD),
                            Form.getString(request, "email", Pattern.EMAIL));
                    dao.user.update(userUpdate);
                    return Actions.PROFILE.command;
                }

                List<AdsEntity> adsList = sessionUser.getAds();
                request.setAttribute("adsList", adsList);
                if (request.getParameter("Change") != null) {
                    AdsEntity ads = new AdsEntity(
                            Form.getInt(request, "id"),
                            sessionUser,
                            Form.getString(request, "animal", Pattern.ANIMAL),
                            Form.getString(request, "breed", Pattern.BREED),
                            Form.getString(request, "name", Pattern.NAME),
                            Form.getString(request, "weight", Pattern.WEIGHT),
                            Form.getString(request, "age", Pattern.AGE),
                            Form.getString(request, "numberPhone", Pattern.NUMBERPHONE));
                    dao.ads.update(ads);
                    return Actions.PROFILE.command;
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}