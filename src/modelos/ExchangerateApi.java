package modelos;
import com.google.gson.annotations.SerializedName;

public class ExchangerateApi implements Comparable<ExchangerateApi> {
    @SerializedName("base_code")
    private String base_code;
    @SerializedName("target_code")
    private String target_code;
    @SerializedName("conversion_rate")
    private String conversion_rate;

    public double getConversion_rate() {
        double cr = Double.parseDouble(conversion_rate);
        return cr;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    @Override
    public int compareTo(ExchangerateApi o) {
        return 0;
    }

    @Override
    public String toString() {
        double cr = Double.parseDouble(conversion_rate);
        String texto = String.format("1 %s = %.2f %s \n", base_code, cr, target_code); //= "1 " + base_code + " = " +  conversion_rate + " " + target_code;
        return texto;
    }
}