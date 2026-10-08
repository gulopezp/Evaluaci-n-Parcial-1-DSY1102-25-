import java.util.ArrayList;
import java.util.List;

public class GestorViviendas {

    private List<Vivienda> viviendas;

    public GestorViviendas() {
        viviendas = new ArrayList<>();
    }

    public void registrarVivienda(Vivienda vivienda) {
        viviendas.add(vivienda);
        System.out.println("Vivienda registrada correctamente.");
    }

    public List<Vivienda> buscarPorCodigo(String criterio) {

        List<Vivienda> resultados = new ArrayList<>();

        for (Vivienda vivienda : viviendas) {

            if (vivienda.getCodigoPropiedad().equalsIgnoreCase(criterio)) {
                resultados.add(vivienda);
            }
        }

        return resultados;
    }

    public List<Vivienda> obtenerViviendas() {
        return viviendas;
    }
}