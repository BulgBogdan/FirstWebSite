package controller;

import beans.RolesEntity;
import beans.UsersEntity;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

public class CmdSignUp extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        if (Form.isPost(request)) {
            try {
                UsersEntity user = new UsersEntity();
                DAO dao = DAO.getInstance();

                List<UsersEntity> users = dao.user.getAll();
                List<RolesEntity> roles = dao.role.getAll();

                request.setAttribute("users", users);
                request.setAttribute("roles", roles);

                user.setId(0);
                user.setLogin(Form.getString(request, "login", Pattern.LOGIN));
                user.setPassword(Form.getString(request, "password", Pattern.PASSWORD));
                user.setEmail(Form.getString(request, "email", Pattern.EMAIL));
                RolesEntity role = dao.role.read(Form.getInt(request, "FK_roles"));
                user.setRole(role);
                dao.user.create(user);

                return Actions.LOGIN.command;

            } catch (ParseException e) {
                return Actions.ERROR.command;
            }
        }
        return null;
    }
}
