package controller;

import beans.AdsEntity;
import beans.UsersEntity;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

public class CmdCreateAd extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UsersEntity sessionUser = (UsersEntity) session.getAttribute("user");

        if (sessionUser == null && !Form.isPost(request)) {
            request.setAttribute(IMessages.MSG_MESSAGE, "Авторизуйтесь, чтобы создать объявление");
            return Actions.LOGIN.command;
        } else if (Form.isPost(request)) {
            DAO daoAds = DAO.getInstance();
            try {
                AdsEntity ads = new AdsEntity();
                ads.setId(0);
                ads.setAnimal(Form.getString(request, "animal", Pattern.ANIMAL));
                ads.setBreed(Form.getString(request, "breed", Pattern.BREED));
                ads.setName(Form.getString(request, "name", Pattern.NAME));
                ads.setWeight(Form.getString(request, "weight", Pattern.WEIGHT));
                ads.setAge(Form.getString(request, "age", Pattern.AGE));
                ads.setNumberPhone(Form.getString(request, "numberPhone", Pattern.NUMBERPHONE));
                ads.setUser(sessionUser);
                daoAds.ads.create(ads);
                return Actions.LISTAD.command;

            } catch (ParseException e) {
                request.setAttribute(IMessages.MSG_ERROR, e.toString());
                e.printStackTrace();
            }
        }
        return null;
    }
}
