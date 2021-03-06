package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.KindOfWorkBean;
import by.it.danilevich.project.java.dao.Dao;
import by.it.danilevich.project.java.dao.connect.CN;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListWork extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao=Dao.getInstance();
        List<KindOfWorkBean> listWork= dao.kindOfWorkDao.getAll("");
        req.setAttribute("listWork",listWork);
        req.setAttribute("listCategory", CN.listCategory);
        req.setAttribute("listUnit", CN.listUnit);

        return null;
    }
}
