public class Conversion {
    String direccion;
    String monedaA;
    String monedaB;
    long numDeMonedasA;
    double conversionRateMonedaB;
    double conversionFinal;

    public double ConversionFinal(){
        this.conversionFinal = numDeMonedasA * conversionRateMonedaB;
        return conversionFinal;
    }

    // ###################_SETTERS_##################

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMonedaA(String monedaA) {
        this.monedaA = monedaA;
    }

    public void setMonedaB(String monedaB) {
        this.monedaB = monedaB;
    }

    public void setNumDeMonedasA(long numDeMonedasA) {
        this.numDeMonedasA = numDeMonedasA;
    }

    public void setConversionRateMonedaB(double conversionRateMonedaB) {
        this.conversionRateMonedaB = conversionRateMonedaB;
    }
    //****** No pude hacerlo funcionar *****

    //public double cornversor (ConversionExchangeRateApi caso1Api, double numDeMonedasA) {
    //   this.conversionRateMonedaB = caso1Api.conversion_rate();
    //    this.conversionFinal = numDeMonedasA * conversionRateMonedaB;
    //      return conversionFinal;
    //  }

    public void setConversionFinal(double numDeMonedasA, double conversionRate) {
        this.conversionFinal = numDeMonedasA * conversionRate;
    }
//    ###################_GETTERS_##################


    public String getDireccion() {
        return direccion;
    }

    public String getMonedaA() {
        return monedaA;
    }

    public String getMonedaB() {
        return monedaB;
    }

    public double getNumDeMonedasA() {
        return numDeMonedasA;
    }

    public double getConversionRateMonedaB() {
        return conversionRateMonedaB;
    }

    public double getConversionFinal(){
        return conversionFinal;
    }



}
