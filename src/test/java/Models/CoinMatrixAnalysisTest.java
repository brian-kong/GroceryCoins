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

}