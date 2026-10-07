public class Main {

    public static void main(String[] args) {

        try {

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

            System.out.println("Casa creada correctamente:");
            System.out.println(casa1);
            System.out.println("Costo arriendo: $" + casa1.calcularCostoArriendo());

            System.out.println();

            System.out.println("Departamento creado correctamente:");
            System.out.println(departamento1);
            System.out.println("Costo arriendo: $" + departamento1.calcularCostoArriendo());

            System.out.println();

            System.out.println("Costo Casa con 10% de descuento:");
            System.out.println("$" + casa1.calcularCostoArriendo(10));

            System.out.println();

            System.out.println("Estacionamiento Departamento:");
            System.out.println(departamento1.tieneEstacionamientoAsignado());

            departamento1.asignarEstacionamiento();

            System.out.println("Estacionamiento asignado:");
            System.out.println(departamento1.tieneEstacionamientoAsignado());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}