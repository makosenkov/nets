package com.sample;


public class Motherboards {

  private long id;
  private String name;
  private long diskInterfaceId;
  private long ramVersionId;
  private long maxRamFreqId;
  private long socketId;
  private long videoInterfaceId;
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


  public long getDiskInterfaceId() {
    return diskInterfaceId;
  }

  public void setDiskInterfaceId(long diskInterfaceId) {
    this.diskInterfaceId = diskInterfaceId;
  }


  public long getRamVersionId() {
    return ramVersionId;
  }

  public void setRamVersionId(long ramVersionId) {
    this.ramVersionId = ramVersionId;
  }


  public long getMaxRamFreqId() {
    return maxRamFreqId;
  }

  public void setMaxRamFreqId(long maxRamFreqId) {
    this.maxRamFreqId = maxRamFreqId;
  }


  public long getSocketId() {
    return socketId;
  }

  public void setSocketId(long socketId) {
    this.socketId = socketId;
  }


  public long getVideoInterfaceId() {
    return videoInterfaceId;
  }

  public void setVideoInterfaceId(long videoInterfaceId) {
    this.videoInterfaceId = videoInterfaceId;
  }


  public long getVendorId() {
    return vendorId;
  }

  public void setVendorId(long vendorId) {
    this.vendorId = vendorId;
  }

}
