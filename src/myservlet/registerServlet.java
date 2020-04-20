package myservlet;

import dao.UserDao;
import dao.UserDaoImplement;
import entity.MyUser;
import util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = MD5Util.getInstance().encodeByMD5(request.getParameter("password"));
        UserDao userDao = new UserDaoImplement();
        MyUser myUser = new MyUser(MD5Util.getInstance().UUID(),name,1,pwd);
        userDao.register(myUser);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
