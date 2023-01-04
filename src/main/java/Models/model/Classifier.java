package Models.model;

import java.util.List;

public class Classifier {

    private List<List<Double>> coinRatio;
    private List<List<Double>> inputRatio;

    public Classifier(List<List<Double>> ratios) {
        this.inputRatio = ratios;
    }

}
