// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.HashMap;

// import org.opencv.core.*;
// import org.opencv.core.Core.*;
// import org.opencv.features2d.FeatureDetector;
// import org.opencv.imgcodecs.Imgcodecs;
// import org.opencv.imgproc.*;
// import org.opencv.objdetect.*;

// /**
// * BallFinderContoursThree class.
// *
// * <p>An OpenCV pipeline generated by GRIP.
// *
// * @author GRIP
// */
// public class BallFinderContoursThree {

// 	//Outputs
// 	private Mat resizeImageOutput = new Mat();
// 	private Mat hsvThreshold0Output = new Mat();
// 	private Mat hsvThreshold1Output = new Mat();
// 	private Mat hsvThreshold2Output = new Mat();
// 	private Mat cvAddOutput = new Mat();
// 	private Mat switchOutput = new Mat();
// 	private Mat cvDilateOutput = new Mat();
// 	private Mat cvErodeOutput = new Mat();
// 	private Mat blurOutput = new Mat();
// 	private MatOfKeyPoint findBlobsOutput = new MatOfKeyPoint();
// 	private ArrayList<MatOfPoint> findContoursOutput = new ArrayList<MatOfPoint>();
// 	private ArrayList<MatOfPoint> filterContoursOutput = new ArrayList<MatOfPoint>();
// 	private Mat maskOutput = new Mat();

// 	private boolean switchSwitch = true;
// 	static {
// 		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
// 	}

// 	/**
// 	 * This is the primary method that runs the entire pipeline and updates the outputs.
// 	 */
// 	public void process(Mat source0) {
// 		// Step Resize_Image0:
// 		Mat resizeImageInput = source0;
// 		double resizeImageWidth = 315.0;
// 		double resizeImageHeight = 216.0;
// 		int resizeImageInterpolation = Imgproc.INTER_CUBIC;
// 		resizeImage(resizeImageInput, resizeImageWidth, resizeImageHeight, resizeImageInterpolation, resizeImageOutput);

// 		// Step HSV_Threshold0:
// 		Mat hsvThreshold0Input = resizeImageOutput;
// 		double[] hsvThreshold0Hue = {94.91525423728812, 116.30442011169923};
// 		double[] hsvThreshold0Saturation = {67.23163841807909, 187.7768014059754};
// 		double[] hsvThreshold0Value = {60.028248587570616, 212.42530755711775};
// 		hsvThreshold(hsvThreshold0Input, hsvThreshold0Hue, hsvThreshold0Saturation, hsvThreshold0Value, hsvThreshold0Output);

// 		// Step HSV_Threshold1:
// 		Mat hsvThreshold1Input = resizeImageOutput;
// 		double[] hsvThreshold1Hue = {0.0, 19.057376699520166};
// 		double[] hsvThreshold1Saturation = {52.824858757062145, 149.6836555360281};
// 		double[] hsvThreshold1Value = {88.84180790960451, 243.79613356766257};
// 		hsvThreshold(hsvThreshold1Input, hsvThreshold1Hue, hsvThreshold1Saturation, hsvThreshold1Value, hsvThreshold1Output);

// 		// Step HSV_Threshold2:
// 		Mat hsvThreshold2Input = resizeImageOutput;
// 		double[] hsvThreshold2Hue = {175.25423728813558, 180.0};
// 		double[] hsvThreshold2Saturation = {93.64406779661017, 154.1652021089631};
// 		double[] hsvThreshold2Value = {21.610169491525422, 149.6836555360281};
// 		hsvThreshold(hsvThreshold2Input, hsvThreshold2Hue, hsvThreshold2Saturation, hsvThreshold2Value, hsvThreshold2Output);

// 		// Step CV_add0:
// 		Mat cvAddSrc1 = hsvThreshold2Output;
// 		Mat cvAddSrc2 = hsvThreshold1Output;
// 		cvAdd(cvAddSrc1, cvAddSrc2, cvAddOutput);

// 		// Step Switch0:
// 		//Inputs
// 		Mat switchIfTrue = hsvThreshold0Output;
// 		Mat switchIfFalse = cvAddOutput;
// 		//Output
// 		Ref<Mat> switchOutputRef = new Ref<Mat>();
// 		pipelineSwitch(switchSwitch, switchIfTrue,
// 		switchIfFalse, switchOutputRef);
// 		//output assignment
// 		switchOutput = switchOutputRef.get();
// 		// Step CV_dilate0:
// 		Mat cvDilateSrc = switchOutput;
// 		Mat cvDilateKernel = new Mat();
// 		Point cvDilateAnchor = new Point(-1, -1);
// 		double cvDilateIterations = 1.0;
// 		int cvDilateBordertype = Core.BORDER_CONSTANT;
// 		Scalar cvDilateBordervalue = new Scalar(-1);
// 		cvDilate(cvDilateSrc, cvDilateKernel, cvDilateAnchor, cvDilateIterations, cvDilateBordertype, cvDilateBordervalue, cvDilateOutput);

// 		// Step CV_erode0:
// 		Mat cvErodeSrc = cvDilateOutput;
// 		Mat cvErodeKernel = new Mat();
// 		Point cvErodeAnchor = new Point(-1, -1);
// 		double cvErodeIterations = 3.0;
// 		int cvErodeBordertype = Core.BORDER_CONSTANT;
// 		Scalar cvErodeBordervalue = new Scalar(-1);
// 		cvErode(cvErodeSrc, cvErodeKernel, cvErodeAnchor, cvErodeIterations, cvErodeBordertype, cvErodeBordervalue, cvErodeOutput);

// 		// Step Blur0:
// 		Mat blurInput = cvErodeOutput;
// 		BlurType blurType = BlurType.get("Gaussian Blur");
// 		double blurRadius = 1.257862684861669;
// 		blur(blurInput, blurType, blurRadius, blurOutput);

// 		// Step Find_Blobs0:
// 		Mat findBlobsInput = blurOutput;
// 		double findBlobsMinArea = 65.0;
// 		double[] findBlobsCircularity = {0.8474577214084779, 1.0};
// 		boolean findBlobsDarkBlobs = false;
// 		findBlobs(findBlobsInput, findBlobsMinArea, findBlobsCircularity, findBlobsDarkBlobs, findBlobsOutput);

// 		// Step Find_Contours0:
// 		Mat findContoursInput = switchOutput;
// 		boolean findContoursExternalOnly = true;
// 		findContours(findContoursInput, findContoursExternalOnly, findContoursOutput);

// 		// Step Filter_Contours0:
// 		ArrayList<MatOfPoint> filterContoursContours = findContoursOutput;
// 		double filterContoursMinArea = 50.0;
// 		double filterContoursMinPerimeter = 0.0;
// 		double filterContoursMinWidth = 0.0;
// 		double filterContoursMaxWidth = 80.0;
// 		double filterContoursMinHeight = 0.0;
// 		double filterContoursMaxHeight = 60.0;
// 		double[] filterContoursSolidity = {73.44632543861978, 100};
// 		double filterContoursMaxVertices = 1000000.0;
// 		double filterContoursMinVertices = 0.0;
// 		double filterContoursMinRatio = 0.0;
// 		double filterContoursMaxRatio = 1000.0;
// 		filterContours(filterContoursContours, filterContoursMinArea, filterContoursMinPerimeter, filterContoursMinWidth, filterContoursMaxWidth, filterContoursMinHeight, filterContoursMaxHeight, filterContoursSolidity, filterContoursMaxVertices, filterContoursMinVertices, filterContoursMinRatio, filterContoursMaxRatio, filterContoursOutput);

// 		// Step Mask0:
// 		Mat maskInput = resizeImageOutput;
// 		Mat maskMask = switchOutput;
// 		mask(maskInput, maskMask, maskOutput);

// 	}

// 	/**
// 	 * This method is a generated setter for the condition of Switch
// 	 * @param the condition to set
// 	 */
// 	 public void setswitch0(boolean value) {
// 	 	switchSwitch = value;
// 	 }

// 	/**
// 	 * This method is a generated getter for the output of a Resize_Image.
// 	 * @return Mat output from Resize_Image.
// 	 */
// 	public Mat resizeImageOutput() {
// 		return resizeImageOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a HSV_Threshold.
// 	 * @return Mat output from HSV_Threshold.
// 	 */
// 	public Mat hsvThreshold0Output() {
// 		return hsvThreshold0Output;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a HSV_Threshold.
// 	 * @return Mat output from HSV_Threshold.
// 	 */
// 	public Mat hsvThreshold1Output() {
// 		return hsvThreshold1Output;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a HSV_Threshold.
// 	 * @return Mat output from HSV_Threshold.
// 	 */
// 	public Mat hsvThreshold2Output() {
// 		return hsvThreshold2Output;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a CV_add.
// 	 * @return Mat output from CV_add.
// 	 */
// 	public Mat cvAddOutput() {
// 		return cvAddOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a Switch.
// 	 * @return Mat output from Switch.
// 	 */
// 	public Mat switchOutput() {
// 		return switchOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a CV_dilate.
// 	 * @return Mat output from CV_dilate.
// 	 */
// 	public Mat cvDilateOutput() {
// 		return cvDilateOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a CV_erode.
// 	 * @return Mat output from CV_erode.
// 	 */
// 	public Mat cvErodeOutput() {
// 		return cvErodeOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a Blur.
// 	 * @return Mat output from Blur.
// 	 */
// 	public Mat blurOutput() {
// 		return blurOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a Find_Blobs.
// 	 * @return MatOfKeyPoint output from Find_Blobs.
// 	 */
// 	public MatOfKeyPoint findBlobsOutput() {
// 		return findBlobsOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a Find_Contours.
// 	 * @return ArrayList<MatOfPoint> output from Find_Contours.
// 	 */
// 	public ArrayList<MatOfPoint> findContoursOutput() {
// 		return findContoursOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a Filter_Contours.
// 	 * @return ArrayList<MatOfPoint> output from Filter_Contours.
// 	 */
// 	public ArrayList<MatOfPoint> filterContoursOutput() {
// 		return filterContoursOutput;
// 	}

// 	/**
// 	 * This method is a generated getter for the output of a Mask.
// 	 * @return Mat output from Mask.
// 	 */
// 	public Mat maskOutput() {
// 		return maskOutput;
// 	}


// 	/**
// 	 * Scales and image to an exact size.
// 	 * @param input The image on which to perform the Resize.
// 	 * @param width The width of the output in pixels.
// 	 * @param height The height of the output in pixels.
// 	 * @param interpolation The type of interpolation.
// 	 * @param output The image in which to store the output.
// 	 */
// 	private void resizeImage(Mat input, double width, double height,
// 		int interpolation, Mat output) {
// 		Imgproc.resize(input, output, new Size(width, height), 0.0, 0.0, interpolation);
// 	}

// 	/**
// 	 * Segment an image based on hue, saturation, and value ranges.
// 	 *
// 	 * @param input The image on which to perform the HSL threshold.
// 	 * @param hue The min and max hue
// 	 * @param sat The min and max saturation
// 	 * @param val The min and max value
// 	 * @param output The image in which to store the output.
// 	 */
// 	private void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val,
// 	    Mat out) {
// 		Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HSV);
// 		Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
// 			new Scalar(hue[1], sat[1], val[1]), out);
// 	}

// 	/**
// 	 * Calculates the sum of two Mats.
// 	 * @param src1 the first Mat
// 	 * @param src2 the second Mat
// 	 * @param out the Mat that is the sum of the two Mats
// 	 */
// 	private void cvAdd(Mat src1, Mat src2, Mat out) {
// 		Core.add(src1, src2, out);
// 	}

// 	/**
// 	 * Selects an output from two inputs based on a boolean.
// 	 * @param sw The boolean that determines the output.
// 	 * @param onTrue The output if sw is true.
// 	 * @param onFalse The output if sw is false.
// 	 * @param output The output which is equal to either onTrue or onFalse.
// 	 */
// 	private <T> void pipelineSwitch(boolean sw, T onTrue, T onFalse, Ref<T> output) {
// 		if (sw) {
// 			output.set(onTrue);
// 		}
// 		else {
// 			output.set(onFalse);
// 		}
// 	}

// 	/**
// 	 * Expands area of higher value in an image.
// 	 * @param src the Image to dilate.
// 	 * @param kernel the kernel for dilation.
// 	 * @param anchor the center of the kernel.
// 	 * @param iterations the number of times to perform the dilation.
// 	 * @param borderType pixel extrapolation method.
// 	 * @param borderValue value to be used for a constant border.
// 	 * @param dst Output Image.
// 	 */
// 	private void cvDilate(Mat src, Mat kernel, Point anchor, double iterations,
// 	int borderType, Scalar borderValue, Mat dst) {
// 		if (kernel == null) {
// 			kernel = new Mat();
// 		}
// 		if (anchor == null) {
// 			anchor = new Point(-1,-1);
// 		}
// 		if (borderValue == null){
// 			borderValue = new Scalar(-1);
// 		}
// 		Imgproc.dilate(src, dst, kernel, anchor, (int)iterations, borderType, borderValue);
// 	}

// 	/**
// 	 * Expands area of lower value in an image.
// 	 * @param src the Image to erode.
// 	 * @param kernel the kernel for erosion.
// 	 * @param anchor the center of the kernel.
// 	 * @param iterations the number of times to perform the erosion.
// 	 * @param borderType pixel extrapolation method.
// 	 * @param borderValue value to be used for a constant border.
// 	 * @param dst Output Image.
// 	 */
// 	private void cvErode(Mat src, Mat kernel, Point anchor, double iterations,
// 		int borderType, Scalar borderValue, Mat dst) {
// 		if (kernel == null) {
// 			kernel = new Mat();
// 		}
// 		if (anchor == null) {
// 			anchor = new Point(-1,-1);
// 		}
// 		if (borderValue == null) {
// 			borderValue = new Scalar(-1);
// 		}
// 		Imgproc.erode(src, dst, kernel, anchor, (int)iterations, borderType, borderValue);
// 	}

// 	/**
// 	 * An indication of which type of filter to use for a blur.
// 	 * Choices are BOX, GAUSSIAN, MEDIAN, and BILATERAL
// 	 */
// 	enum BlurType{
// 		BOX("Box Blur"), GAUSSIAN("Gaussian Blur"), MEDIAN("Median Filter"),
// 			BILATERAL("Bilateral Filter");

// 		private final String label;

// 		BlurType(String label) {
// 			this.label = label;
// 		}

// 		public static BlurType get(String type) {
// 			if (BILATERAL.label.equals(type)) {
// 				return BILATERAL;
// 			}
// 			else if (GAUSSIAN.label.equals(type)) {
// 			return GAUSSIAN;
// 			}
// 			else if (MEDIAN.label.equals(type)) {
// 				return MEDIAN;
// 			}
// 			else {
// 				return BOX;
// 			}
// 		}

// 		@Override
// 		public String toString() {
// 			return this.label;
// 		}
// 	}

// 	/**
// 	 * Softens an image using one of several filters.
// 	 * @param input The image on which to perform the blur.
// 	 * @param type The blurType to perform.
// 	 * @param doubleRadius The radius for the blur.
// 	 * @param output The image in which to store the output.
// 	 */
// 	private void blur(Mat input, BlurType type, double doubleRadius,
// 		Mat output) {
// 		int radius = (int)(doubleRadius + 0.5);
// 		int kernelSize;
// 		switch(type){
// 			case BOX:
// 				kernelSize = 2 * radius + 1;
// 				Imgproc.blur(input, output, new Size(kernelSize, kernelSize));
// 				break;
// 			case GAUSSIAN:
// 				kernelSize = 6 * radius + 1;
// 				Imgproc.GaussianBlur(input,output, new Size(kernelSize, kernelSize), radius);
// 				break;
// 			case MEDIAN:
// 				kernelSize = 2 * radius + 1;
// 				Imgproc.medianBlur(input, output, kernelSize);
// 				break;
// 			case BILATERAL:
// 				Imgproc.bilateralFilter(input, output, -1, radius, radius);
// 				break;
// 		}
// 	}

// 	/**
// 	 * Detects groups of pixels in an image.
// 	 * @param input The image on which to perform the find blobs.
// 	 * @param minArea The minimum size of a blob that will be found
// 	 * @param circularity The minimum and maximum circularity of blobs that will be found
// 	 * @param darkBlobs The boolean that determines if light or dark blobs are found.
// 	 * @param blobList The output where the MatOfKeyPoint is stored.
// 	 */
// 	private void findBlobs(Mat input, double minArea, double[] circularity,
// 		Boolean darkBlobs, MatOfKeyPoint blobList) {
// 		FeatureDetector blobDet = FeatureDetector.create(FeatureDetector.SIMPLEBLOB);
// 		try {
// 			File tempFile = File.createTempFile("config", ".xml");

// 			StringBuilder config = new StringBuilder();

// 			config.append("<?xml version=\"1.0\"?>\n");
// 			config.append("<opencv_storage>\n");
// 			config.append("<thresholdStep>10.</thresholdStep>\n");
// 			config.append("<minThreshold>50.</minThreshold>\n");
// 			config.append("<maxThreshold>220.</maxThreshold>\n");
// 			config.append("<minRepeatability>2</minRepeatability>\n");
// 			config.append("<minDistBetweenBlobs>10.</minDistBetweenBlobs>\n");
// 			config.append("<filterByColor>1</filterByColor>\n");
// 			config.append("<blobColor>");
// 			config.append((darkBlobs ? 0 : 255));
// 			config.append("</blobColor>\n");
// 			config.append("<filterByArea>1</filterByArea>\n");
// 			config.append("<minArea>");
// 			config.append(minArea);
// 			config.append("</minArea>\n");
// 			config.append("<maxArea>");
// 			config.append(Integer.MAX_VALUE);
// 			config.append("</maxArea>\n");
// 			config.append("<filterByCircularity>1</filterByCircularity>\n");
// 			config.append("<minCircularity>");
// 			config.append(circularity[0]);
// 			config.append("</minCircularity>\n");
// 			config.append("<maxCircularity>");
// 			config.append(circularity[1]);
// 			config.append("</maxCircularity>\n");
// 			config.append("<filterByInertia>1</filterByInertia>\n");
// 			config.append("<minInertiaRatio>0.1</minInertiaRatio>\n");
// 			config.append("<maxInertiaRatio>" + Integer.MAX_VALUE + "</maxInertiaRatio>\n");
// 			config.append("<filterByConvexity>1</filterByConvexity>\n");
// 			config.append("<minConvexity>0.95</minConvexity>\n");
// 			config.append("<maxConvexity>" + Integer.MAX_VALUE + "</maxConvexity>\n");
// 			config.append("</opencv_storage>\n");
// 			FileWriter writer;
// 			writer = new FileWriter(tempFile, false);
// 			writer.write(config.toString());
// 			writer.close();
// 			blobDet.read(tempFile.getPath());
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		}

// 		blobDet.detect(input, blobList);
// 	}

// 	/**
// 	 * Sets the values of pixels in a binary image to their distance to the nearest black pixel.
// 	 * @param input The image on which to perform the Distance Transform.
// 	 * @param type The Transform.
// 	 * @param maskSize the size of the mask.
// 	 * @param output The image in which to store the output.
// 	 */
// 	private void findContours(Mat input, boolean externalOnly,
// 		List<MatOfPoint> contours) {
// 		Mat hierarchy = new Mat();
// 		contours.clear();
// 		int mode;
// 		if (externalOnly) {
// 			mode = Imgproc.RETR_EXTERNAL;
// 		}
// 		else {
// 			mode = Imgproc.RETR_LIST;
// 		}
// 		int method = Imgproc.CHAIN_APPROX_SIMPLE;
// 		Imgproc.findContours(input, contours, hierarchy, mode, method);
// 	}


// 	/**
// 	 * Filters out contours that do not meet certain criteria.
// 	 * @param inputContours is the input list of contours
// 	 * @param output is the the output list of contours
// 	 * @param minArea is the minimum area of a contour that will be kept
// 	 * @param minPerimeter is the minimum perimeter of a contour that will be kept
// 	 * @param minWidth minimum width of a contour
// 	 * @param maxWidth maximum width
// 	 * @param minHeight minimum height
// 	 * @param maxHeight maximimum height
// 	 * @param Solidity the minimum and maximum solidity of a contour
// 	 * @param minVertexCount minimum vertex Count of the contours
// 	 * @param maxVertexCount maximum vertex Count
// 	 * @param minRatio minimum ratio of width to height
// 	 * @param maxRatio maximum ratio of width to height
// 	 */
// 	private void filterContours(List<MatOfPoint> inputContours, double minArea,
// 		double minPerimeter, double minWidth, double maxWidth, double minHeight, double
// 		maxHeight, double[] solidity, double maxVertexCount, double minVertexCount, double
// 		minRatio, double maxRatio, List<MatOfPoint> output) {
// 		final MatOfInt hull = new MatOfInt();
// 		output.clear();
// 		//operation
// 		for (int i = 0; i < inputContours.size(); i++) {
// 			final MatOfPoint contour = inputContours.get(i);
// 			final Rect bb = Imgproc.boundingRect(contour);
// 			if (bb.width < minWidth || bb.width > maxWidth) continue;
// 			if (bb.height < minHeight || bb.height > maxHeight) continue;
// 			final double area = Imgproc.contourArea(contour);
// 			if (area < minArea) continue;
// 			if (Imgproc.arcLength(new MatOfPoint2f(contour.toArray()), true) < minPerimeter) continue;
// 			Imgproc.convexHull(contour, hull);
// 			MatOfPoint mopHull = new MatOfPoint();
// 			mopHull.create((int) hull.size().height, 1, CvType.CV_32SC2);
// 			for (int j = 0; j < hull.size().height; j++) {
// 				int index = (int)hull.get(j, 0)[0];
// 				double[] point = new double[] { contour.get(index, 0)[0], contour.get(index, 0)[1]};
// 				mopHull.put(j, 0, point);
// 			}
// 			final double solid = 100 * area / Imgproc.contourArea(mopHull);
// 			if (solid < solidity[0] || solid > solidity[1]) continue;
// 			if (contour.rows() < minVertexCount || contour.rows() > maxVertexCount)	continue;
// 			final double ratio = bb.width / (double)bb.height;
// 			if (ratio < minRatio || ratio > maxRatio) continue;
// 			output.add(contour);
// 		}
// 	}

// 	/**
// 	 * Filter out an area of an image using a binary mask.
// 	 * @param input The image on which the mask filters.
// 	 * @param mask The binary image that is used to filter.
// 	 * @param output The image in which to store the output.
// 	 */
// 	private void mask(Mat input, Mat mask, Mat output) {
// 		mask.convertTo(mask, CvType.CV_8UC1);
// 		Core.bitwise_xor(output, output, output);
// 		input.copyTo(output, mask);
// 	}


// 	/**
// 	 * Enables C-style output parameters in Java to avoid creating custom data classes for each
// 	 * operation.
// 	 *
// 	 * <p>Syntax is {@code Ref<T> varName = new Ref<T>(initValue)}.
// 	 * Where varName is the name of the variable and initValue is of type T and contains initial value.
// 	 * </p>
// 	 * @param <T> The type of object being referenced
// 	 */
// 	private static class Ref<T> {
// 		private T value;

// 		/**
// 		 * Constructor for a Ref object.
// 		 * @param initValue Type T initial value for the object.
// 		 */
// 		public Ref(T initValue) {
// 			value = initValue;
// 		}

// 		/**
// 		 * Constructor for a Ref object without an initial value.
// 		 * Equivalent to calling Ref(null)
// 		 */
// 		public Ref() {
// 			this(null);
// 		}

// 		/**
// 		 * Sets the object to contain a new value.
// 		 *
// 		 * @param newValue the new value being referenced
// 		 */
// 		public void set(T newValue) {
// 			value = newValue;
// 		}

// 		/**
// 		 * Gets the current referenced value
// 		 *
// 		 * @return the current referenced value
// 		 */
// 		public T get() {
// 			return value;
// 		}
// 	}

// }

