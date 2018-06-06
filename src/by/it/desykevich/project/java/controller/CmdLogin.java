package by.it.desykevich.project.java.controller;



import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdLogin extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest reg) throws Exception {
        if (reg.getMethod().equalsIgnoreCase("post")){
            String login=reg.getParameter("login");
            String password=reg.getParameter("password");
            User user=new User(0,login,password,"","","",2);
            DAO dao = DAO.getInstanse();
            String where=String.format("WHERE login='%s' AND password='%s'",login,password);
            if (dao.userDAO.getAll(where).size()>0){
                return Actions.INDEX.command;
            }
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstanse();
        String where=String.format("WHERE login='%s' AND password='%s'","TestLogintype","TestPassword");
        if (dao.userDAO.getAll(where).size()==1){
            System.out.println("ok");
        }
    }
}
