import java.util.List;
public class Main {
    public static void main(String[] args) {
        try {
            GestorViviendas gestor = new GestorViviendas();
            Departamento departamento1 = new Departamento(
                    "PROP-D01",
                    65,
                    3,
                    8,
                    false
            );
            Departamento departamento2 = new Departamento(
                    "PROP-D02",
                    48,
                    2,
                    3,
                    true
            );
            Casa casa1 = new Casa(
                    "PROP-C01",
                    120,
                    4,
                    true
            );
            Casa casa2 = new Casa(
                    "PROP-C02",
                    90,
                    3,
                    false
            );
            departamento1.asignarEstacionamiento();
            gestor.registrarVivienda(departamento1);
            gestor.registrarVivienda(departamento2);
            gestor.registrarVivienda(casa1);
            gestor.registrarVivienda(casa2);
            System.out.println();
            System.out.println("BUSQUEDA POR CODIGO PROP-D01");
            System.out.println("--------------------------------");
            List<Vivienda> resultados = gestor.buscarPorCodigo("PROP-D01");
            for (Vivienda vivienda : resultados) {
                System.out.println("Tipo: " + vivienda.getClass().getSimpleName());
                System.out.println("Codigo: " + vivienda.getCodigoPropiedad());
                System.out.println("Superficie: " + vivienda.getSuperficieM2() + " m2");
                System.out.println("Habitaciones: " + vivienda.getNumeroHabitaciones());
                if (vivienda instanceof Departamento departamento) {
                    System.out.println("Piso: " + departamento.getNumeroPiso());
                    System.out.println("Gasto comun al dia: "
                            + departamento.isGastoComunAlDia());
                    System.out.println("Estacionamiento asignado: "
                            + departamento.tieneEstacionamientoAsignado());
                }
                if (vivienda instanceof Casa casa) {
                    System.out.println("Tiene patio: "
                            + casa.isTienePatio());
                }
                System.out.println("Costo arriendo: $"
                        + vivienda.calcularCostoArriendo());
            }
            System.out.println();
            System.out.println("LISTADO DE TODAS LAS VIVIENDAS");
            System.out.println("--------------------------------");
            for (Vivienda vivienda : gestor.obtenerViviendas()) {
                System.out.println(vivienda);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}