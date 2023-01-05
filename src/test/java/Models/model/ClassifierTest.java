package Models.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ClassifierTest {

    HashMap<Double, Integer> input;
    Classifier classifier;

    @BeforeEach
    void setUp() {
        input = new HashMap<Double, Integer>();
        input.put(1.0, 1);
    }

    @Test
    void classificationTest() {
        input.put(1.176, 2);
        input.put(1.470, 1);

        classifier = new Classifier(input, "Dime");
        HashMap<String, Integer> output = classifier.classify(input);

        System.out.println(output.toString());
    }

    @Test
    void counterTest() {
        input.put(1.176, 2);
        input.put(1.470, 1);

        classifier = new Classifier(input, "Dime");
        HashMap<String, Integer> output = classifier.classify(input);

        assertEquals(120, classifier.counter(output));
    }
}