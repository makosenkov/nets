package mksnkv.nets.utilities;

import mksnkv.nets.entities.*;

import java.util.HashSet;
import java.util.Random;

class EntitiesGenerator {

    private final Random random = new Random();
    private final StringRandomizer randomizer = StringRandomizer.INSTANCE;

    RamVersions generateRamVersion() {
        RamVersions entity = new RamVersions();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    RamFreqs generateRamFreq() {
        RamFreqs entity = new RamFreqs();
        entity.setName(random.nextInt(4000) + 200);
        return entity;
    }

    RamVendors generateRamVendor() {
        RamVendors entity = new RamVendors();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    Sockets generateSocket() {
        Sockets entity = new Sockets();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    CpuVendors generateCpuVendor() {
        CpuVendors entity = new CpuVendors();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    GpuVendors generateGpuVendor() {
        GpuVendors entity = new GpuVendors();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    PsuVendors generatePsuVendor() {
        PsuVendors entity = new PsuVendors();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }


    MotherboardVendors generateMotherboardVendor() {
        MotherboardVendors entity = new MotherboardVendors();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    DiskVendors generateDiskVendor() {
        DiskVendors entity = new DiskVendors();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    Cases generateCase() {
        Cases entity = new Cases();
        entity.setName("Case " + randomizer.generateRandomString(15));
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    VideoInterfaces generateVideoInterface() {
        VideoInterfaces entity = new VideoInterfaces();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    DiskInterfaces generateDiskInterface() {
        DiskInterfaces entity = new DiskInterfaces();
        entity.setName(randomizer.generateRandomString(15));
        return entity;
    }

    Cpus generateCpu() {
        Cpus entity = new Cpus();
        entity.setName("CPU " + randomizer.generateRandomString(15));
        entity.setPower(random.nextInt(100) + 50);
        entity.setConfigurations(new HashSet<>());
        entity.setMotherboards(new HashSet<>());
        return entity;
    }

    Gpus generateGpu() {
        Gpus entity = new Gpus();
        entity.setName("GPU " + randomizer.generateRandomString(15));
        entity.setPower(random.nextInt(500) + 200);
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    Psus generatePsu() {
        Psus entity = new Psus();
        entity.setName("PSU " + randomizer.generateRandomString(15));
        entity.setPowerRate(random.nextInt(1500) + 500);
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    Disks generateDisk() {
        Disks entity = new Disks();
        entity.setName("Disk " + randomizer.generateRandomString(15));
        entity.setPower(random.nextInt(300) + 200);
        entity.setArchitecture(randomizer.generateRandomString(15));
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    Rams generateRam() {
        Rams entity = new Rams();
        entity.setName("Ram " + randomizer.generateRandomString(15));
        entity.setPower(random.nextInt(50) + 10);
        entity.setConfigurations(new HashSet<>());
        return entity;
    }

    Configurations generateConfiguration() {
        return new Configurations();
    }

    Motherboards generateMotherboard() {
        Motherboards entity = new Motherboards();
        entity.setName("Motherboard " + randomizer.generateRandomString(15));
        entity.setConfigurations(new HashSet<>());
        entity.setCpus(new HashSet<>());
        return entity;
    }

    Items generateItem() {
        return new Items(
            random.nextInt(25000),
            random.nextBoolean()
        );
    }

    Orders generateOrder() {
        Orders entity = new Orders();
        entity.setAddress(randomizer.generateRandomString(15));
        entity.setItems(new HashSet<>());
        return entity;
    }
}
