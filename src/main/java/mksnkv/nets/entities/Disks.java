package com.sample;


public class Disks {

  private long id;
  private String name;
  private String architecture;
  private long interfaceId;
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


  public String getArchitecture() {
    return architecture;
  }

  public void setArchitecture(String architecture) {
    this.architecture = architecture;
  }


  public long getInterfaceId() {
    return interfaceId;
  }

  public void setInterfaceId(long interfaceId) {
    this.interfaceId = interfaceId;
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
