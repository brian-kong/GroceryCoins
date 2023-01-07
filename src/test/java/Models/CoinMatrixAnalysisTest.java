package Models;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoinMatrixAnalysisTest {

    @Test
    void simpleInput() {
        List<Integer> testList = new ArrayList<Integer>();
        CoinMatrixAnalysis matrix = new CoinMatrixAnalysis("Dime");

        for (int i = 0; i < 3; i++) {
            testList.add(1000);
        }

        HashMap<Double, Integer> output = null;
        try {
            output = matrix.countRatio(testList);
        } catch (Exception e) {
            fail("oh no");
        }

        assertEquals(1, output.size());
        assertEquals(3, output.get(1.0));

    }

    @Test
    void RealInput() {
        List<Integer> testList = new ArrayList<Integer>();
        CoinMatrixAnalysis matrix = new CoinMatrixAnalysis("Dime");

        testList.add(255);
        testList.add(229);
        testList.add(276);
        testList.add(233);
        testList.add(168);
        testList.add(201);
        testList.add(200);
        testList.add(227);
        testList.add(177);

        HashMap<Double, Integer> output = null;
        try {
            output = matrix.countRatio(testList);
        } catch (Exception e) {
            fail("oh no");
        }

        assertEquals(5, output.size());
        assertEquals(2, output.get(1.0));

        System.out.println(output.toString());
        // {1.0=2, 1.11=2, 1.553=1, 1.321=3, 1.47=1}

    }

    @Test
    void AnotherInput6() {
        List<Integer> testList = new ArrayList<Integer>();
        CoinMatrixAnalysis matrix = new CoinMatrixAnalysis("Dime");

        testList.add(211);
        testList.add(280);
        testList.add(265);
        testList.add(212);
        testList.add(267);
        testList.add(180);

        HashMap<Double, Integer> output = null;
        try {
            output = matrix.countRatio(testList);
        } catch (Exception e) {
            fail("oh no");
        }

        assertEquals(3, output.size());
        assertEquals(1, output.get(1.0));

        System.out.println(output.toString());
        // {1.0=1, 1.11=2, 1.47=3}

    }

}