package mksnkv.nets.utilities;

import com.github.javafaker.Faker;
import mksnkv.nets.entities.*;

import java.util.HashSet;
import java.util.Random;

public class EntitiesGenerator {
    
    private final Random random = new Random();
    private Faker faker = new Faker();
    
    public RamVersions generateRamVersion() {
        RamVersions entity = new RamVersions();
        entity.setName(String.format("DDR%d", random.nextInt(5000)));
        return entity;
    }

    public RamFreqs generateRamFreq() {
        RamFreqs entity = new RamFreqs();
        entity.setName(random.nextInt(4000)+200);
        return entity;
    }

    public RamVendors generateRamVendor() {
        RamVendors entity = new RamVendors();
        entity.setName(faker.company().name());
        return entity;
    }

    public Sockets generateSocket() {
        Sockets entity = new Sockets();
        entity.setName(String.format("Socket%d", random.nextInt(5000)));
        return entity;
    }

    public CpuVendors generateCpuVendor() {
        CpuVendors entity = new CpuVendors();
        entity.setName(faker.company().name());
        return entity;
    }

    public GpuVendors generateGpuVendor() {
        GpuVendors entity = new GpuVendors();
        entity.setName(faker.company().name());
        return entity;
    }

    public PsuVendors generatePsuVendor() {
        PsuVendors entity = new PsuVendors();
        entity.setName(faker.company().name());
        return entity;
    }
    

    public MotherboardVendors generateMotherboardVendor() {
        MotherboardVendors entity = new MotherboardVendors();
        entity.setName(faker.company().name());
        return entity;
    }

    public DiskVendors generateDiskVendor() {
        DiskVendors entity = new DiskVendors();
        entity.setName(faker.company().name());
        return entity;
    }

    public Cases generateCase() {
        Cases entity = new Cases();
        entity.setName(faker.rockBand().name());
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    public VideoInterfaces generateVideoInterface() {
        VideoInterfaces entity = new VideoInterfaces();
        entity.setName(faker.app().name() + random.nextInt(10));
        return entity;
    }

    public DiskInterfaces generateDiskInterface() {
        DiskInterfaces entity = new DiskInterfaces();
        entity.setName(String.format("SATA%d", random.nextInt(3000)));
        return entity;
    }

    public Cpus generateCpu() {
        Cpus entity = new Cpus();
        entity.setName(faker.cat().name() + random.nextInt(10));
        entity.setPower(random.nextInt(100)+50);
        entity.setMotherboards(new HashSet<>());
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    public Gpus generateGpu() {
        Gpus entity = new Gpus();
        entity.setName(faker.dog().name() + random.nextInt(10));
        entity.setPower(random.nextInt(500)+200);
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    public Psus generatePsu() {
        Psus entity = new Psus();
        entity.setName(faker.beer().name());
        entity.setPowerRate(random.nextInt(1500)+500);
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    public Disks generateDisk() {
        Disks entity = new Disks();
        entity.setName(faker.beer().name() + random.nextInt(10));
        entity.setPower(random.nextInt(300)+200);
        entity.setArchitecture(faker.beer().style());
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    public Rams generateRam() {
        Rams entity = new Rams();
        entity.setName(faker.esports().game() + random.nextInt(20));
        entity.setPower(random.nextInt(50)+10);
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    Configurations generateConfiguration() {
        return new Configurations();
    }

    Motherboards generateMotherboard() {
        Motherboards entity = new Motherboards();
        entity.setName(faker.space().galaxy() + random.nextInt(10));
        entity.setCpus(new HashSet<>());
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    Items generateItem() {
        return new Items(
            random.nextInt(25000),
            faker.witcher().monster() + random.nextInt(1000),
            random.nextBoolean()
        );
    }

    public Orders generateOrder() {
        Orders entity = new Orders();
        entity.setAddress(faker.address().fullAddress());
        entity.setItems(new HashSet<>());
        return entity;
    }
}
