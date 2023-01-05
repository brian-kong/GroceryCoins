package Models;

import Models.Exceptions.RatioNotFound;

import java.util.HashMap;
import java.util.List;

public class CoinMatrixAnalysis {
    private static final double NICKEL_RADIUS = 21.2;
    private static final double DIME_RADIUS = 18.03;
    private static final double QUARTER_RADIUS = 23.88;
    private static final double LOONIE_RADIUS = 26.5;
    private static final double TOONIE_RADIUS = 28;
    private static final double ERROR = 0.1;
    private static String smallest;

    public CoinMatrixAnalysis(String smallest) {
        this.smallest = smallest;
    }

    // group ratios using small radius as reference (hashmap is <ratio, count>)
    // need to perform checks on small-est coin value
    public static HashMap<Double, Integer> countRatio(List<Integer> radiusList) throws RatioNotFound {
        double min = findMin(radiusList);
        HashMap<Double, Integer> rf = new HashMap<Double, Integer>();

        for (Integer radius : radiusList) {
            double ratio = radius / min;

            if (Math.abs(ratio - 1) < ERROR) {
                put(rf, 1.0);
            } else if (Math.abs(ratio - 1.) < ERROR) {
                put(rf, 1.0);
            } else if (Math.abs(ratio - 1.057) < ERROR) {
                put(rf, 1.057);
            } else if (Math.abs(ratio - 1.110) < ERROR) {
                put(rf, 1.110);
            } else if (Math.abs(ratio - 1.126) < ERROR) {
                put(rf, 1.126);
            } else if (Math.abs(ratio - 1.173) < ERROR) {
                put(rf, 1.173);
            } else if (Math.abs(ratio - 1.321) < ERROR) {
                put(rf, 1.321);
            } else if (Math.abs(ratio - 1.470) < ERROR) {
                put(rf, 1.470);
            } else if (Math.abs(ratio - 1.553) < ERROR) {
                put(rf, 1.553);
            } else if (Math.abs(ratio - 1.324) < ERROR) {
                put(rf, 1.324);
            } else if (Math.abs(ratio - 1.25) < ERROR) {
                put(rf, 1.25);
            } else {
                throw new RatioNotFound();
            }
        }
        return rf;
    }

    private static void put(HashMap<Double, Integer> rf, double v){
        if (!rf.containsKey(v)) {
            rf.put(v,1);
        } else {
            int curr = rf.get(v);
            curr++;
            rf.put(v, curr);
        }
    }


    // get radius from list of radius (double value)
    private static double findMin(List<Integer> radiusList) {
        int minimum_Radius = Integer.MAX_VALUE;

        for (Integer radius : radiusList) {
            if (radius < minimum_Radius) {
                minimum_Radius = radius;
            }
        }
        return (double) minimum_Radius;
    }

}
