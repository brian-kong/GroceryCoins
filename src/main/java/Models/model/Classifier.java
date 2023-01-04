package Models.model;

import java.util.HashMap;
import java.util.List;

public class Classifier {

    private HashMap<Double, String> coinRatios;
    private HashMap<Double, Integer> ratioCount;
    private String smallest;

    public Classifier(HashMap<Double, Integer> ratios, String smallest) {
        this.ratioCount = ratios;
        this.smallest = smallest;
        this.coinRatios = new HashMap<Double, String>();
        setRatios();
    }

    private void setRatios() {
        coinRatios.put(1.0, smallest);

        coinRatios.put(1.553, "Toonie");
        coinRatios.put(1.321, "Toonie");
        coinRatios.put(1.057, "Toonie");
        coinRatios.put(1.173, "Toonie");

        coinRatios.put(1.25, "Loonie");
        coinRatios.put(1.47, "Loonie");
        coinRatios.put(1.110, "Loonie");

        coinRatios.put(1.324, "Quarters");
        coinRatios.put(1.126, "Quarters");

        coinRatios.put(1.176, "Nickel");
    }
}
