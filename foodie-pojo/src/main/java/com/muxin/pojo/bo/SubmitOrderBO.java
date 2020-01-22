package com.muxin.pojo.bo;

/**
 * 用于创建订单的BO对象
 */
public class SubmitOrderBO {
  private String userId;
  private String itemSpecIds;
  private String addressId;
  private Integer payMethod;
  private String leftMsg;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getItemSpecIds() {
    return itemSpecIds;
  }

  public void setItemSpecIds(String itemSpecIds) {
    this.itemSpecIds = itemSpecIds;
  }

  public String getAddressId() {
    return addressId;
  }

  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }

  public Integer getPayMethod() {
    return payMethod;
  }

  public void setPayMethod(Integer payMethod) {
    this.payMethod = payMethod;
  }

  public String getLeftMsg() {
    return leftMsg;
  }

  public void setLeftMsg(String leftMsg) {
    this.leftMsg = leftMsg;
  }

  @Override
  public String toString() {
    return "SubmitOrderBO{" +
      "userId='" + userId + '\'' +
      ", itemSpecIds='" + itemSpecIds + '\'' +
      ", addressId='" + addressId + '\'' +
      ", payMethod=" + payMethod +
      ", leftMsg='" + leftMsg + '\'' +
      '}';
  }
}
