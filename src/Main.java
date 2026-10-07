public class Main {

    public static void main(String[] args) {

        try {
            Vivienda vivienda1 = new Vivienda(
                    "VIV001",
                    80.5,
                    3
            );

            System.out.println("Vivienda creada correctamente:");
            System.out.println(vivienda1);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}