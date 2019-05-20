package mksnkv.nets.utilities;

import com.github.javafaker.Faker;
import mksnkv.nets.entities.*;

import java.util.Random;

public class EntitiesGenerator {
    
    private final Random random = new Random();
    private Faker faker = new Faker();
    
    public RamVersions generateRamVersion(int i) {
        RamVersions entity = new RamVersions();
        entity.setName(String.format("DDR%d", i));
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

    public Sockets generateSocket(int i) {
        Sockets entity = new Sockets();
        entity.setName(String.format("Socket%d", i));
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
        return entity;
    }

    public VideoInterfaces generateVideoInterface() {
        VideoInterfaces entity = new VideoInterfaces();
        entity.setName(faker.app().name() + random.nextInt(10));
        return entity;
    }

    public DiskInterfaces generateDiskInterface(int i) {
        DiskInterfaces entity = new DiskInterfaces();
        entity.setName(String.format("SATA%d", i));
        return entity;
    }

    public Cpus generateCpu() {
        Cpus entity = new Cpus();
        entity.setName(faker.cat().name() + random.nextInt(10));
        entity.setPower(random.nextInt(100)+50);
        return entity;
    }

    public Gpus generateGpu() {
        Gpus entity = new Gpus();
        entity.setName(faker.dog().name() + random.nextInt(10));
        entity.setPower(random.nextInt(500)+200);
        return entity;
    }

    public Psus generatePsu() {
        Psus entity = new Psus();
        entity.setName(faker.beer().name());
        entity.setPowerRate(random.nextInt(1500)+500);
        return entity;
    }

    public Disks generateDisk() {
        Disks entity = new Disks();
        entity.setName(faker.beer().name() + random.nextInt(10));
        entity.setPower(random.nextInt(300)+200);
        entity.setArchitecture(faker.beer().style());
        return entity;
    }

    public Rams generateRam() {
        Rams entity = new Rams();
        entity.setName(faker.esports().game() + random.nextInt(20));
        entity.setPower(random.nextInt(50)+10);
        return entity;
    }

    public Configurations generateConfiguration() {
        return new Configurations();
    }

    public Motherboards generateMotherboard() {
        Motherboards entity = new Motherboards();
        entity.setName(faker.space().galaxy() + random.nextInt(10));
        return entity;
    }

    public Items generateItem() {
        Items entity = new Items();
        entity.setName(faker.funnyName().name() + random.nextInt(10));
        return entity;
    }

    public Orders generateOrder() {
        Orders entity = new Orders();
        entity.setAddress(faker.address().fullAddress());
        return entity;
    }
}
