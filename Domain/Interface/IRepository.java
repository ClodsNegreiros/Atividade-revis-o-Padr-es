package Domain.Interface;

import java.util.ArrayList;

import Domain.Entities.Vehicle;
import Domain.Enum.EFuelType;

public interface IRepository {
    Boolean CadastrarVeiculo(Vehicle veiculo) throws Exception;
    ArrayList<Vehicle> ListarTodosVeiculos();
    ArrayList<Vehicle> ListarVeiculosMaiorAutonomia() throws Exception;
    ArrayList<Vehicle> ListarVeiculosMenorAutonomia();
    ArrayList<Vehicle> ListarVeiculosPorMotorizacao(EFuelType motorizacao);
    void Abastecer(EFuelType tipoMotorizacao, double qtdCombustivel);
    ArrayList<Vehicle> ListarVeiculosPorAutonomiaInferior(double autonomia) throws Exception;
}
