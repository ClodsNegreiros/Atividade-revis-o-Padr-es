package Domain.Entities;
import Domain.Enum.EFuelType;

public class EngineType {
    EFuelType fuel;

    public void setFuel(EFuelType fuel) {
        this.fuel = fuel;
    }

    public EFuelType getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "EngineType{" +
                "fuel=" + fuel +
                '}';
    }
}