package controller;

import beans.UsersEntity;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdEditUsers extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UsersEntity sessionUser = (UsersEntity) session.getAttribute("user");

        DAO dao = DAO.getInstance();
        List<UsersEntity> users = dao.user.getAll();

        request.setAttribute("users", users);

        if (sessionUser == null) {
            return Actions.LOGIN.command;

        } else if ((sessionUser.getRole().getId() != 1) && !Form.isPost(request)) {
            return Actions.ERROR.command;
        } else {
            try {
                if (request.getParameter("Update") != null) {
                    UsersEntity userUpdate = new UsersEntity(
                            Form.getInt(request, "id"),
                            sessionUser.getRole(),
                            sessionUser.getAds(),
                            Form.getString(request, "login", Pattern.LOGIN),
                            Form.getString(request, "password", Pattern.PASSWORD),
                            Form.getString(request, "email", Pattern.EMAIL));
                    dao.user.update(userUpdate);
                }
                if (request.getParameter("Delete") != null) {
                    UsersEntity user = new UsersEntity();
                    user.setId(Form.getInt(request, "id"));
                    dao.user.delete(user);
                }
            } catch (ParseException e) {
                request.setAttribute(IMessages.MSG_ERROR, e.toString());
                e.printStackTrace();
            }
            return null;
        }
    }
}
