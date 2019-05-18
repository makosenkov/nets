package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "configurations")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Configurations {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "motherboard_id")
  private Motherboards motherboardId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cpu_id")
  private Cpus cpuId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gpu_id")
  private Gpus gpuId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ram_id")
  private Rams ramId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "disk_id")
  private Disks diskId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "psu_id")
  private Psus psuId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "case_id")
  private Cases caseId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Items itemId;

  public Configurations(Motherboards motherboardId, Cpus cpuId, Gpus gpuId, Rams ramId,
                        Disks diskId, Psus psuId, Cases caseId) {
    this.motherboardId = motherboardId;
    this.cpuId = cpuId;
    this.gpuId = gpuId;
    this.ramId = ramId;
    this.diskId = diskId;
    this.psuId = psuId;
    this.caseId = caseId;
  }
}
