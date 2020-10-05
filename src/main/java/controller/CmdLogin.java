package controller;

import beans.UsersEntity;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            UsersEntity user = new UsersEntity();
            DAO dao = DAO.getInstance();
            try {
                String login = Form.getString(request, "login", Pattern.LOGIN);
                String password = Form.getString(request, "password", Pattern.PASSWORD);
                user = dao.user.read(login, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    return Actions.PROFILE.command;
                } else {
                    request.setAttribute(IMessages.MSG_MESSAGE, "Нет такого пользователя, повторите ввод");
                    return null;
                }
            } catch (Exception e) {
                request.setAttribute(IMessages.MSG_ERROR, e.toString());
                e.printStackTrace();
            }
            return Actions.LOGIN.command;
        }
    }
}
