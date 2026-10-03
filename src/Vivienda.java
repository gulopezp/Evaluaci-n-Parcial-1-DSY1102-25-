public class Vivienda {
    private String codigoPropiedad;
    private double superficieM2;
    private int numeroHabitaciones;

    Vivienda(String codigoPropiedad,double superficieM2, int numeroHabitaciones) {
        if (codigoPropiedad == null || codigoPropiedad.isBlank() ) {
            throw new IllegalArgumentException("El codigo no puede estar vacio.");
        }

        if (superficieM2 >= 20 && superficieM2 <= 500) {
            throw new IllegalArgumentException("El superficiem2 debe estar entre los rangos 20 y 500");
        }

        this.codigoPropiedad = codigoPropiedad;
        this.superficieM2 = superficieM2;
        this.numeroHabitaciones = numeroHabitaciones;
    }


    public String getCodigoPropiedad() {
        return codigoPropiedad;
    }
    public double getSuperficieM2() {
        return superficieM2;
    }
    public int getNumeroHabitaciones(){
        return numeroHabitaciones;
    }


}
