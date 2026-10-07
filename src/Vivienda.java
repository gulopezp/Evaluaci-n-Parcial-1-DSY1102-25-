public class Vivienda {

    private String codigoPropiedad;
    private double superficieM2;
    private int numeroHabitaciones;

    public Vivienda(String codigoPropiedad, double superficieM2, int numeroHabitaciones) {
        setCodigoPropiedad(codigoPropiedad);
        setSuperficieM2(superficieM2);
        setNumeroHabitaciones(numeroHabitaciones);
    }

    public String getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(String codigoPropiedad) {
        if (codigoPropiedad == null || codigoPropiedad.isBlank()) {
            throw new IllegalArgumentException("El codigo de propiedad no puede estar vacio.");
        }

        this.codigoPropiedad = codigoPropiedad;
    }

    public double getSuperficieM2() {
        return superficieM2;
    }

    public void setSuperficieM2(double superficieM2) {
        if (superficieM2 < 20 || superficieM2 > 500) {
            throw new IllegalArgumentException("La superficie debe estar entre 20 y 500 m2.");
        }

        this.superficieM2 = superficieM2;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        if (numeroHabitaciones <= 0) {
            throw new IllegalArgumentException("El numero de habitaciones debe ser mayor que cero.");
        }

        this.numeroHabitaciones = numeroHabitaciones;
    }

    @Override
    public String toString() {
        return "Codigo propiedad: " + codigoPropiedad +
                ", Superficie: " + superficieM2 + " m2";
    }
}