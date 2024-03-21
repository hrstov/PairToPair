<<<<<<< HEAD
public class Empresa {
}
=======

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa{

    private String nombreempresa;
    private Map<String, Cliente> mapaClientes;
    private List<Vehiculo> listaVehiculos;

    public Empresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
        this.mapaClientes = new HashMap<>();
        this.listaVehiculos = new ArrayList<>();
    }


    public boolean hayCliente(String id){
        if (mapaClientes.containsKey(id)){
            return true;
        }
        return false;
    }

    public boolean addCliente(String id, Cliente cliente){
        if (cliente != null && !hayCliente(id)){
            mapaClientes.put(id, cliente);
            return true;
        }
        return false;
    }

    public boolean hayVehiculo(String matricula){
        for (Vehiculo v: listaVehiculos){
            if (matricula.equalsIgnoreCase(v.getMatricula())){
                return true;
            }
        }
        return false;
    }

    public boolean addVehiculo(Vehiculo vehiculo){
        if (!hayVehiculo(vehiculo.getMatricula())){
            listaVehiculos.add(vehiculo);
            return true;
        }
        return false;
    }




    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }
}
>>>>>>> 3a23058a0bad796c83adf9681d7a0807fce0ce5e