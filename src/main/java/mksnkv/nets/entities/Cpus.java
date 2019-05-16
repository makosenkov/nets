package com.sample;


public class Cpus {

  private long id;
  private String name;
  private long socketId;
  private long power;
  private long maxRamFreqId;
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


  public long getSocketId() {
    return socketId;
  }

  public void setSocketId(long socketId) {
    this.socketId = socketId;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }


  public long getMaxRamFreqId() {
    return maxRamFreqId;
  }

  public void setMaxRamFreqId(long maxRamFreqId) {
    this.maxRamFreqId = maxRamFreqId;
  }


  public long getVendorId() {
    return vendorId;
  }

  public void setVendorId(long vendorId) {
    this.vendorId = vendorId;
  }

}
