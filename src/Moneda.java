import com.google.gson.annotations.SerializedName;

public class Moneda {
    @SerializedName("base_code")
    private String monedaBase;
    @SerializedName("target_code")
    private String monedaFinal;
    @SerializedName("conversion_rate")
    private double resultado;

    public String getMonedaBase() {
            return monedaBase;
    }
    public String getMonedaFinal() {
            return monedaFinal;
    }
    public Double getResultado() {
            return resultado;
    }

    public Moneda(String monedaBase, String monedaFinal, Double resultado) {
            this.monedaBase = monedaBase;
            this.monedaFinal = monedaFinal;
            this.resultado = resultado;
    }
    public Moneda(TipoMoneda miMoneda) {
        this.monedaBase = miMoneda.base_code();
        this.monedaFinal = miMoneda.target_code();
        this.resultado = miMoneda.conversion_rate();
    }

    }
