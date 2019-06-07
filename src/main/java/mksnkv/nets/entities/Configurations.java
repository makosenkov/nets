package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "configurations")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Configurations {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne
  @MapsId
  @Getter
  @Setter
  private Items item;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "motherboard_id")
  private Items motherboardId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cpu_id")
  private Items cpuId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gpu_id")
  private Items gpuId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ram_id")
  private Items ramId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "disk_id")
  private Items diskId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "psu_id")
  private Items psuId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "case_id")
  private Items caseId;

  public Configurations(Items motherboardId,
                        Items cpuId,
                        Items gpuId,
                        Items ramId,
                        Items diskId,
                        Items psuId,
                        Items caseId) {
    this.motherboardId = motherboardId;
    this.cpuId = cpuId;
    this.gpuId = gpuId;
    this.ramId = ramId;
    this.diskId = diskId;
    this.psuId = psuId;
    this.caseId = caseId;
  }
}
