package openCV;

import nu.pattern.OpenCV;
import org.opencv.core.Mat;

import java.security.KeyStore;
import java.util.ArrayList;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;
import static org.opencv.imgcodecs.Imgcodecs.IMREAD_GRAYSCALE;
import static org.opencv.imgproc.Imgproc.COLOR_RGB2GRAY;
import static org.opencv.core.CvType.CV_8U;
import static org.opencv.imgproc.Imgproc.cvtColor;


public class ScanCoin {

    public static void main(String[] args) throws InterruptedException{
        String file = "src/main/java/resources/image2.jpg";

        Mat src = Imgcodecs.imread(file, IMREAD_GRAYSCALE);
        System.out.println(findCoins(src).toString());

    }


    public static ArrayList<Integer> findCoins(Mat mat) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //pre-process image, setting image to gray
        Mat gray = new Mat();

        Imgproc.cvtColor(mat, gray, COLOR_RGB2GRAY);
        Imgcodecs.imwrite("gray.jpg", gray);

        //pre-process- detect edge of an image (Canny Edge Algorithm)

        Mat edges = new Mat();
        Imgproc.Canny(gray, edges, 50, 150, 3, true);
        Imgcodecs.imwrite("edges.jpg", edges);

        return list;
    }
}
