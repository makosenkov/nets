package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table
@EqualsAndHashCode(of = {"motherboardId", "cpuId"})
public class MothCpuCompat {

  @ManyToMany
  private Motherboards motherboardId;
  @ManyToMany
  private Cpus cpuId;


  public Motherboards getMotherboardId() {
    return motherboardId;
  }

  public void setMotherboardId(Motherboards motherboardId) {
    this.motherboardId = motherboardId;
  }


  public Cpus getCpuId() {
    return cpuId;
  }

  public void setCpuId(Cpus cpuId) {
    this.cpuId = cpuId;
  }

}
