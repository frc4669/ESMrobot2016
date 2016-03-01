package org.usfirst.frc.team4669.robot.subsystems;

import java.util.ArrayList;

//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfInt;
//import org.opencv.core.MatOfPoint;
//import org.opencv.core.Scalar;
//import org.opencv.highgui.Highgui;
//import org.opencv.highgui.VideoCapture;
//import org.opencv.imgproc.Imgproc;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
//	private Relay lightRelay;
//	private VideoCapture videoCapture;
//	
//	public Vision() {
//		super();
//		lightRelay = new Relay(0);
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		videoCapture = new VideoCapture();  
//		videoCapture.open(0);
//		if(!videoCapture.isOpened())
//		{
//			System.out.println("Video not open");
//		}
//	}
//	
//	public void releaseCapture() {
//		videoCapture.release();
//	}
//	
//	public void turnOnLight() {
//		lightRelay.set(Relay.Value.kForward);
//	}
//	
//	public void turnOffLight() {
//		lightRelay.set(Relay.Value.kOff);
//	}
//	
//	public Mat getCameraImage() {
//		Mat frame = new Mat();
//		videoCapture.retrieve(frame);
//		return frame;
//	}
//	
//	public Mat getDifference(Mat frame1, Mat frame2) {
//		Mat diff = new Mat();
//		Core.subtract(frame2, frame1, diff);
//		return diff;
//	}
//	
//	public Mat getGrayscale(Mat frame) {
//		Mat grayscale = new Mat();
//		Imgproc.cvtColor(frame, grayscale, Imgproc.COLOR_RGB2GRAY);
//		return grayscale;
//	}
//	
//	public Mat threshold(Mat frame) {
//		Mat newFrame = new Mat();
//		Imgproc.threshold(frame, newFrame, 50, 255, Imgproc.THRESH_BINARY);
//		return newFrame;
//	}
//	
//	public ArrayList<MatOfPoint> getContours(Mat frame) {
//		ArrayList<MatOfPoint> contoursList = new ArrayList<MatOfPoint>();
//		Mat hierarchy = new Mat();
//		Imgproc.findContours(frame, contoursList, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
////		Scalar color = new Scalar( 255, 0, 0 );
////		Imgproc.drawContours(frame, contoursList, -1, color, 3);
//		return contoursList;
//	}
//	
//	public MatOfPoint getMaxContour(ArrayList<MatOfPoint> contoursList) {
//		MatOfPoint maxContour = new MatOfPoint();
//		if (contoursList.size()>0) {
//			maxContour = contoursList.get(0);
//			double maxArea = Imgproc.contourArea(maxContour);
//			for (MatOfPoint contour:contoursList) {
//				double area = Imgproc.contourArea(contour);
//				if (area>maxArea) {
//					maxContour = contour;
//					maxArea = area;
//				}
//			}
//		}
//		return maxContour;
//	}
//	
//	public MatOfInt getConvexHull(MatOfPoint contour) {
//		MatOfInt hull = new MatOfInt();
//		Imgproc.convexHull(contour, hull);
//		return hull;
//	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
