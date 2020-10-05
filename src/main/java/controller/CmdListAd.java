package controller;

import beans.AdsEntity;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListAd extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        if (!Form.isPost(request)) {
            try {
                DAO dao = DAO.getInstance();
                List<AdsEntity> adsList = dao.ads.getAll();
                request.setAttribute("adsList", adsList);
            } catch (Exception e) {
                request.setAttribute(IMessages.MSG_ERROR, e.toString());
                e.printStackTrace();
            }
        }
        return null;
    }
}
