public class Main {
    public static void main(String[] args) {
        try {
            GestorViviendas gestor = new GestorViviendas();
            Casa casa1 = new Casa(
                    "CASA001",
                    120.0,
                    4,
                    true
            );
            Departamento departamento1 = new Departamento(
                    "DEP001",
                    75.0,
                    3,
                    5,
                    false
            );
            gestor.registrarVivienda(casa1);
            gestor.registrarVivienda(departamento1);
            System.out.println();
            System.out.println("Listado de viviendas:");
            for (Vivienda vivienda : gestor.obtenerViviendas()) {
                System.out.println(vivienda);
                System.out.println("Costo arriendo: $" + vivienda.calcularCostoArriendo());
                System.out.println();
            }
            System.out.println("Busqueda por codigo CASA001:");
            for (Vivienda vivienda : gestor.buscarPorCodigo("CASA001")) {
                System.out.println(vivienda);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}