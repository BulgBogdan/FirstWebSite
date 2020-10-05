package controller;

import beans.AdsEntity;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdSearch extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            try {
                DAO dao = DAO.getInstance();
                String animal = Form.getString(request, "search", Pattern.ANIMAL);
                String breed = Form.getString(request, "search", Pattern.BREED);
                AdsEntity ads = dao.ads.read(animal, breed);
                if (ads != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("ads", ads);
                    return Actions.FOUNDEDADS.command;
                } else {
                    request.setAttribute(IMessages.MSG_MESSAGE, "Нет животного такой породы");
                    return null;
                }

            } catch (Exception e) {
                request.setAttribute(IMessages.MSG_MESSAGE, e.toString());
                e.printStackTrace();
            }
            return Actions.SEARCH.command;
        }

    }
}
