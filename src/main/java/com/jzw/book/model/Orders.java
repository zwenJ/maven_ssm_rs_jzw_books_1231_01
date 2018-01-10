package com.jzw.book.model;

import com.jzw.book.util.DateUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Orders implements Serializable {

    private Integer orderId;

    private Integer userId;
    private Users users;

    private Integer orderSum;

    private BigDecimal orderPrice = new BigDecimal(0);

    /**
     * 支付方式
     */
    private Integer orderPayType = 1;

    /**
     * 下单时间
     */
    private Date orderDate;

    /**
     * 订单发货方式
     */
    private Integer orderSendType;

    /**
     * 订单状态  -- 订单状态 1未付款 2已付款 3商家已发货 4卖家已收货 5卖家申请售后 6订单交易完成 7卖家取消 8卖家删除 9售后完成
     */
    private Integer orderStatus = 1;

    /**
     * 地址对象
     */
    private Address address;

    /**
     * 订单项集合
     */
    private List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();


    public Orders() {

    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(Integer orderPayType) {
        this.orderPayType = orderPayType;
    }

    public String getOrderDate() {
        return DateUtil.dateToString(orderDate);
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderSendType() {
        return orderSendType;
    }

    public void setOrderSendType(Integer orderSendType) {
        this.orderSendType = orderSendType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;

        /**
         * 计算订单金额
         */
        if (orderDetailsList.size()>0) {
            BigDecimal bigDecimalA;
            BigDecimal bigDecimalB;
            for (OrderDetails orderDetails : orderDetailsList) {
                //BigDecimal 加法 最后必须赋值给自己，否则加法运算失败！
                this.orderPrice = this.orderPrice.add(orderDetails.getOdPrice());
            }
        }

        //设置订单商品数量
        this.orderSum = orderDetailsList.size();
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", users=" + users +
                ", orderSum=" + orderSum +
                ", orderPrice=" + orderPrice +
                ", orderPayType=" + orderPayType +
                ", orderDate=" + orderDate +
                ", orderSendType=" + orderSendType +
                ", orderStatus=" + orderStatus +
                ", address=" + address +
                ", orderDetailsList=" + orderDetailsList +
                '}';
    }
}