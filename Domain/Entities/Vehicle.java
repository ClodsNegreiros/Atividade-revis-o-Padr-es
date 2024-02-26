package Domain.Entities;

public class Vehicle {
    String brand;
    String model;
    Double autonomy;
    EngineType engineType;
    Integer tankCapacity;
    Double availableFuel;

    public Vehicle(String brand, String model, Double autonomy, EngineType engineType, Integer tankCapacity, Double availableFuel) {
        this.brand = brand;
        this.model = model;
        this.autonomy = autonomy;
        this.engineType = engineType;
        this.tankCapacity = tankCapacity;
        this.availableFuel = availableFuel;
    }

    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;;
    }

    public Double getAutonomy() {
        return this.autonomy;
    }

    public void setAutonomy(Double autonomy) {
        this.autonomy = autonomy;
    }

    public EngineType getEngineType() {
        return this.engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Integer getTankCapacity(Integer tankCapacity) {
        return this.getTankCapacity(tankCapacity);
    };

    public void setTankCapacity(Integer tankCapacity) {
        this.tankCapacity = tankCapacity;
    };

    public Double getAvailableFuel() {
        return this.availableFuel;
    };

    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    };

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", autonomy=" + autonomy +
                ", engineType=" + engineType +
                ", tankCapacity=" + tankCapacity +
                ", availableFuel=" + availableFuel +
                '}';
    }
}