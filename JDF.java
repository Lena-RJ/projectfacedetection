package com.JDF;



import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


public class JDF {
public static void main(String[] args) {
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	String imgFile ="images/face-3.jpg";
	Mat src = Imgcodecs.imread(imgFile);
	
	String xmlFile = "xmls/lbpcascade_frontalface.xml";
	CascadeClassifier classifier = new CascadeClassifier(xmlFile);
	
	MatOfRect faceDetection = new MatOfRect();
	classifier.detectMultiScale(src, faceDetection);
	
	System.out.println(String.format("detected faces : %d", faceDetection.toArray().length));
	
	for(Rect rect: faceDetection.toArray()) {
		Imgproc.rectangle(src, new Point(rect.x,rect.y),new Point(rect.x + rect.width, rect.y + rect.height),new Scalar(0,0,255), 3);
	}
	
	Imgcodecs.imwrite("images/face-3_out.jpg", src);
	System.out.println("Image Detection Finished");
	
	
	
	
	
	
	
}
}
