package controller;

import beans.AdsEntity;
import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdFoundedAds extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        AdsEntity sessionAds = (AdsEntity) session.getAttribute("ads");
        if (!Form.isPost(request) && sessionAds != null) {
            try {
                AdsEntity adsFind = DAO.getInstance().ads.read(sessionAds.getId());
                request.setAttribute("adsFind", adsFind);

            } catch (Exception e) {
                request.setAttribute(IMessages.MSG_MESSAGE, e.toString());
                e.printStackTrace();
            }
        }
        return null;
    }
}
