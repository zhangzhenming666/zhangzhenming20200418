package com.bw.zhangzhenming20200414.bean.ddaobean;

import java.io.Serializable;
import java.util.List;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class OrderListBean implements Serializable {
    private List<DetaiListBean> detailList;
    private String expressCompName;
    private String orderId;
    private int orderStatus;
    private  long orderTime;
    private double payAmount;
    private  int payMethod;

    public List<DetaiListBean> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<DetaiListBean> detailList) {
        this.detailList = detailList;
    }

    public String getExpressCompName() {
        return expressCompName;
    }

    public void setExpressCompName(String expressCompName) {
        this.expressCompName = expressCompName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }
}
