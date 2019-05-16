package com.sample;


public class Gpus {

  private long id;
  private String name;
  private long videoInterfaceId;
  private long power;
  private long vendorId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getVideoInterfaceId() {
    return videoInterfaceId;
  }

  public void setVideoInterfaceId(long videoInterfaceId) {
    this.videoInterfaceId = videoInterfaceId;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }


  public long getVendorId() {
    return vendorId;
  }

  public void setVendorId(long vendorId) {
    this.vendorId = vendorId;
  }

}
