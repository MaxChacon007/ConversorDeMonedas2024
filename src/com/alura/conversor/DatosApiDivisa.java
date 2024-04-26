package com.alura.conversor;

public class DatosApiDivisa {

    private String base_code;
    private String target_code;
    private double conversion_rate;

    public DatosApiDivisa(DatosApi datosApi){
        this.base_code =datosApi.base_code();
        this.target_code =datosApi.target_code();
        this.conversion_rate =datosApi.conversion_rate();
            }

    @Override
    public String toString() {
        return "" + "conversion_rate=" + conversion_rate;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }
}
