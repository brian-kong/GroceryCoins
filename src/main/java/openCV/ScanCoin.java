package openCV;


import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import java.util.ArrayList;

import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;
import static org.opencv.imgcodecs.Imgcodecs.IMREAD_GRAYSCALE;
import static org.opencv.core.CvType.CV_8U;
import static org.opencv.imgproc.Imgproc.*;


public class ScanCoin{

    private static boolean renderSteps = true;

    public static ArrayList<Integer> findCoins(Mat mat) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int threshold = 10;

        Mat blur = new Mat();
        Mat edge = new Mat();
        Mat blur2 = new Mat();
        Mat circles = new Mat();
        Mat proc = new Mat();

        // Save an image to a specific file
        if (renderSteps) Imgcodecs.imwrite("in.jpg", mat);

        // convert an image from one color space to gray
        Imgproc.cvtColor(mat, mat, COLOR_RGB2GRAY);
        if (renderSteps) Imgcodecs.imwrite("gray.jpg", mat);

        // blurs an image using Gaussian blur
        Imgproc.GaussianBlur(mat, blur, new Size(13,13), 0, 0);
        Imgproc.GaussianBlur(blur, blur, new Size(9,9), 0, 0);
        if (renderSteps) Imgcodecs.imwrite("blur.jpg", blur);

        // Find edges in an image using the Canny algorithm
        Imgproc.Canny(blur, edge, threshold, threshold*3, 3, true);
        if (renderSteps) Imgcodecs.imwrite("edge.jpg", edge);


        Imgproc.GaussianBlur(edge, blur2, new Size(9,9), 2, 2);
        if (renderSteps) Imgcodecs.imwrite("blur2.jpg", blur2);

        proc = blur2;

        // Implement houghCircles, find circles on a grayscale image
        Imgproc.HoughCircles(proc, circles, CV_HOUGH_GRADIENT, 1, proc.rows() / 8, 20, 100, 0, proc.rows() /10);

        for (int x = 0; x < circles.cols(); x++) {
            double[] c  = circles.get(0, x);
            Point center = new Point(Math.round(c[0]), Math.round(c[1]));

            // Circle center
            Imgproc.circle(proc, center, 1, new Scalar(0, 100, 100), 3, 8, 0);

            // Circle outline
            int radius = (int) Math.round(c[2]);
            Imgproc.circle(blur2, center, radius, new Scalar(255, 0, 255), 3, 8, 0);

            list.add(radius);

        }

        return list;
    }
}

