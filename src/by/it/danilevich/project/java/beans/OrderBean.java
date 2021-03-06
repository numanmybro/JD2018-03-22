package by.it.danilevich.project.java.beans;

import by.it.danilevich.project.java.dao.Dao;
import javafx.scene.input.DataFormat;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderBean implements Serializable {
    private int id;
    private long dateOrder;
    private int clientId;
    private int kindOfWorkId;
    private int executorId;
    private int adminId;
    private int amount;
    private double totalMoney;
    private double totalTime;
    private String status;

    public OrderBean() {
    }

    public long getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(long dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getKindOfWorkId() {
        return kindOfWorkId;
    }

    public void setKindOfWorkId(int kindOfWorkId) {
        this.kindOfWorkId = kindOfWorkId;
    }

    public int getExecutorId() {
        return executorId;
    }

    public void setExecutorId(int executorId) {
        this.executorId = executorId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderBean(int id, long dateOrder, int clientId, int kindOfWorkId, int executorId, int adminId,  int amount, double totalMoney, double totalTime, String status) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.clientId = clientId;
        this.kindOfWorkId = kindOfWorkId;
        this.executorId = executorId;
        this.adminId = adminId;
        this.amount = amount;
        this.totalMoney = totalMoney;
        this.totalTime = totalTime;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBean orderBean = (OrderBean) o;
        return id == orderBean.id &&
                Objects.equals(dateOrder, orderBean.dateOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOrder);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", dateOrder='" + dateOrder + '\'' +
                ", clientId=" + clientId +
                ", kindOfWorkId=" + kindOfWorkId +
                '}';
    }


    public String getNameExecutor() {

        List<UserBean> userBeans= null;
        String nameExecutor="";
        try {
            userBeans = Dao.getInstance().userDao.getAll("where `id`="+this.executorId);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userBeans.size()!=0) {
            nameExecutor = userBeans.get(0).getName();
        }
        return nameExecutor;
    }
    public String getNameClient() {

        List<UserBean> userBeans= null;
        String nameClient="";
        try {
            userBeans = Dao.getInstance().userDao.getAll("where `id`="+this.clientId);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userBeans.size()!=0) {
            nameClient = userBeans.get(0).getName();
        }
        return nameClient;
    }
    public String getAddress() {

        List<UserBean> userBeans= null;
        String address="";
        try {
            userBeans = Dao.getInstance().userDao.getAll("where `id`="+this.clientId);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userBeans.size()!=0) {
            address = userBeans.get(0).getAddress();
        }
        return address;
    }
    public String getNameWork() {

        List<KindOfWorkBean> kindOfWorkBeans= null;
        String nameWork="";
        try {
            kindOfWorkBeans = Dao.getInstance().kindOfWorkDao.getAll("where `id`="+this.kindOfWorkId);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (kindOfWorkBeans.size()!=0) {
            nameWork = kindOfWorkBeans.get(0).getName();
        }
        return nameWork;
    }

    public String getUnitWork() {

        List<KindOfWorkBean> kindOfWorkBeans= null;
        String nameWork="";
        try {
            kindOfWorkBeans = Dao.getInstance().kindOfWorkDao.getAll("where `id`="+this.kindOfWorkId);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (kindOfWorkBeans.size()!=0) {
            nameWork = kindOfWorkBeans.get(0).getUnit();
        }
        return nameWork;
    }

    public String getDateString(){
        Long mil = this.dateOrder;
        Date date = new Date(mil);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        return dateFormat.format(date);
    }
}
