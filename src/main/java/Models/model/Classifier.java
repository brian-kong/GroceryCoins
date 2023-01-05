package Models.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // Count up the total coin values given the String
    public int counter(HashMap<String, Integer> coinCount) {
        int rf = 0;

        for (Map.Entry<String, Integer> entry :coinCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (key.equals("Toonie")) {
                rf += (200 * value);
            } else if (key.equals("Loonie")) {
                rf += (100 * value);
            } else if (key.equals("Quarter")) {
                rf += (25 * value);
            } else if (key.equals("Dime")) {
                rf += (10 * value);
            } else {
                rf += (5 * value);
            }
        }

        return rf;
    }
}
