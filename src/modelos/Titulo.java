package modelos;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("base_code")
    private String base_code;
    @SerializedName("target_code")
    private String target_code;
    @SerializedName("conversion_rate")
    private String conversion_rate;

    public String getConversion_rate() {
        return conversion_rate;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    @Override
    public int compareTo(Titulo o) {
        return 0;
    }

    @Override
    public String toString() {
        String texto = "1 " + base_code + " = " + conversion_rate + " " + target_code;
        return texto;
    }
}