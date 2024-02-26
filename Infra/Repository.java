package Infra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Domain.Entities.Vehicle;
import Domain.Enum.EFuelType;

public class Repository {
    private static Map<String, ArrayList<String>> marcaEModeloMap = new HashMap<>();
    ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();

    public Repository(){
        mapBrandsAndModels();
    }

    public Boolean registerVehicle(Vehicle Vehicle) throws Exception{
        if(!validateVehicle(Vehicle.getBrand(), Vehicle.getModel()))
            throw new Exception("Erro ao cadastrar Vehicle: "
                    + Vehicle.getBrand() + "-" + Vehicle.getModel() + ", confira se a marca do carro é do modelo correto");

        return Vehicles.add(Vehicle);
    }

    private boolean validateVehicle(String marca, String modelo) {
        ArrayList<String> modelosValidos = marcaEModeloMap.get(marca);
        return modelosValidos != null && modelosValidos.contains(modelo);
    }

    public ArrayList<Vehicle> listAllVehicles(){
            if(!Vehicles.isEmpty())
                return Vehicles;
            return null;
    }

    public ArrayList<Vehicle> listVehiclesWithHighestAutonomy() throws Exception{
        List<Vehicle> VehiclesOrdenados = Vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getAutonomy).reversed())
                .limit(10)
                .collect(Collectors.toList());

        return  new ArrayList<>(VehiclesOrdenados);
    }

    public ArrayList<Vehicle> listVehiclesWithLowestAutonomy() {
        List<Vehicle> VehiclesOrdenados = Vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getAutonomy))
                .limit(10)
                .collect(Collectors.toList());

        return  new ArrayList<>(VehiclesOrdenados);
    }

    public ArrayList<Vehicle> listVehiclesByFuel(EFuelType fuel) {
        List<Vehicle> filter = Vehicles.stream().filter(v -> v.getEngineType().equals(fuel))
                .collect(Collectors.toList());

        return new ArrayList<>(filter);
    }

    public void Abastecer(EFuelType tipofuel, double qtdCombustivel) {
        List<Vehicle> VehicleParaAbastecer = listVehiclesByFuel(tipofuel);

        for(Vehicle Vehicle : VehicleParaAbastecer){
            Double qtdDisponivel = Vehicle.getAvailableFuel();

            if(qtdDisponivel >= qtdCombustivel){
                Integer enchendoTanque = (int)Math.round(qtdDisponivel - qtdCombustivel);
                Vehicle.setTankCapacity(enchendoTanque);
                System.out.println(Vehicle.getModel() + " abastecido com sucesso - Capacidade atual do tanque: " + Vehicle.getCapacidadeDeTanque());
            } else{
                System.out.println("A quantidade de combustivel que você deseja inserir ultrapassa a capacidade do tanque do " + Vehicle.getModel());
            }
        }
    }

    public ArrayList<Vehicle> listVehiclesByLowerAutonomy(double autonomia) throws Exception{
        ArrayList<Vehicle> VehiclesComAutonomiaInferior = new ArrayList<>();

        for(Vehicle Vehicle : Vehicles)
            if(Vehicle.getAutonomy() < autonomia)
                VehiclesComAutonomiaInferior.add(Vehicle);

        if(VehiclesComAutonomiaInferior.isEmpty())
            throw new Exception("Não há Vehicles com autonomia inferior ao que foi inserido.");

        return VehiclesComAutonomiaInferior;
    }

    private static void mapBrandsAndModels()
    {
        marcaEModeloMap.put("chevrolet", new ArrayList<>());
        marcaEModeloMap.put("ford", new ArrayList<>());
        marcaEModeloMap.put("volkswagen", new ArrayList<>());
        marcaEModeloMap.put("fiat", new ArrayList<>());
        marcaEModeloMap.put("renault", new ArrayList<>());
        marcaEModeloMap.put("toyota", new ArrayList<>());
        marcaEModeloMap.put("hyundai", new ArrayList<>());
        marcaEModeloMap.put("honda", new ArrayList<>());
        marcaEModeloMap.put("volkswagen", new ArrayList<>());
        marcaEModeloMap.put("fiat", new ArrayList<>());
        marcaEModeloMap.put("byd", new ArrayList<>());

        marcaEModeloMap.get("chevrolet").add("onix");
        marcaEModeloMap.get("chevrolet").add("classic");
        marcaEModeloMap.get("volkswagen").add("fox");
        marcaEModeloMap.get("volkswagen").add("gol");
        marcaEModeloMap.get("fiat").add("uno");
        marcaEModeloMap.get("fiat").add("palio");
        marcaEModeloMap.get("renault").add("duster");
        marcaEModeloMap.get("renault").add("kwid");
        marcaEModeloMap.get("toyota").add("corolla");
        marcaEModeloMap.get("toyota").add("etios");
        marcaEModeloMap.get("hyundai").add("hb20");
        marcaEModeloMap.get("honda").add("civic");
        marcaEModeloMap.get("ford").add("ka");
        marcaEModeloMap.get("ford").add("fiesta");
        marcaEModeloMap.get("byd").add("dolphin");
    }
}
