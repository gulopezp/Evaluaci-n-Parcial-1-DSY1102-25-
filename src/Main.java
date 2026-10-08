import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("BUSQUEDA OFICIAL PROP-D01");
            System.out.println("-------------------------");
            List<Vivienda> resultados = gestor.buscarPorCodigo("PROP-D01");

            for (Vivienda vivienda : resultados) {
                System.out.println("Tipo: " + vivienda.getClass().getSimpleName());
                System.out.println("Codigo: " + vivienda.getCodigoPropiedad());
                System.out.println("Superficie: " + vivienda.getSuperficieM2());
                System.out.println("Habitaciones: " + vivienda.getNumeroHabitaciones());
                if (vivienda instanceof Departamento departamento) {
                    System.out.println("Piso: " + departamento.getNumeroPiso());
                    System.out.println("Gasto comun al dia: " + departamento.isGastoComunAlDia());
                    System.out.println("Estacionamiento asignado: " + departamento.tieneEstacionamientoAsignado());
                }

                if (vivienda instanceof Casa casa) {
                    System.out.println("Tiene patio: " + casa.isTienePatio());
                }
                System.out.println("Costo arriendo: $"+ vivienda.calcularCostoArriendo());
            }
            System.out.println();
            System.out.println("LISTADO OFICIAL");
            System.out.println("----------------");
            for (Vivienda vivienda : gestor.obtenerViviendas()) {
                System.out.println(vivienda);
            }
            int opcion = 0;
            while (opcion != 4) {
                System.out.println();
                System.out.println("MENU");
                System.out.println("1. Listar viviendas");
                System.out.println("2. Buscar por codigo");
                System.out.println("3. Simular costo con descuento");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                    switch (opcion) {
                        case 1:
                            System.out.println();
                            System.out.println("LISTADO DE VIVIENDAS");
                            for (Vivienda vivienda : gestor.obtenerViviendas()) {
                                System.out.println(vivienda);
                                System.out.println("Costo: $"+ vivienda.calcularCostoArriendo());
                            }
                            break;
                        case 2:
                            System.out.print("Ingrese codigo de propiedad: ");
                            String codigo = scanner.nextLine();
                            List<Vivienda> encontrados =gestor.buscarPorCodigo(codigo);
                            if (encontrados.isEmpty()) {
                                System.out.println("No se encontraron viviendas.");
                            } else {
                                for (Vivienda vivienda : encontrados) {
                                    System.out.println(vivienda);
                                    System.out.println("Costo: $"+ vivienda.calcularCostoArriendo());
                                }
                            }
                            break;
                        case 3:
                            System.out.print("Ingrese codigo de propiedad: ");
                            String codigoDescuento = scanner.nextLine();
                            List<Vivienda> viviendasEncontradas =gestor.buscarPorCodigo(codigoDescuento);

                            if (viviendasEncontradas.isEmpty()) {
                                System.out.println("No se encontro la vivienda.");
                            } else {
                                double descuento = -1;
                                while (descuento < 0 || descuento > 100) {
                                    System.out.print("Ingrese porcentaje de descuento (0 a 100): ");
                                    try {
                                        descuento = Double.parseDouble(scanner.nextLine());
                                        if (descuento < 0 || descuento > 100) {
                                            System.out.println("El porcentaje debe estar entre 0 y 100.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un numero valido.");
                                    }
                                }

                                for (Vivienda vivienda : viviendasEncontradas) {
                                    System.out.println("Costo normal: $" + vivienda.calcularCostoArriendo());
                                    System.out.println("Costo con descuento: $"+ vivienda.calcularCostoArriendo(descuento));
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Programa finalizado.");
                            break;
                        default:
                            System.out.println(
                                    "Opcion invalida. Intente nuevamente."
                            );
                    }
                } catch (NumberFormatException e) {
                    System.out.println(
                            "Debe ingresar un numero para seleccionar una opcion."
                    );
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}