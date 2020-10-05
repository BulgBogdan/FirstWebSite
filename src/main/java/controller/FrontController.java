package controller;

import dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/do")

public class FrontController extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            config.getServletContext().setAttribute("roles", DAO.getInstance().role.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.init(config);
    }

    private RequestDispatcher dispatcher(Action action) {
        return getServletContext().getRequestDispatcher(action.getJsp());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        Action nextAction = action.execute(req, resp);
        if (nextAction != null) {
            resp.sendRedirect("do?command=" + nextAction);
        } else {
            dispatcher(action).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        Action nextAction = action.execute(req, resp);
        if (nextAction != null) {
            resp.sendRedirect("do?command=" + nextAction);
        } else {
            dispatcher(action).forward(req, resp);
        }
    }
}
