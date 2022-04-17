# 2022_Vision

## Saving a new GRIP pipeline:
1. `CTRL` + `SHIFT` + `S`
2. Select this directory /GRIP

## Exporting a GRIP pipeline in Java
1. `CTRL` + `G` or `Tools` -> `Generate Code`
2. Select Java as language, check WPILib Vision Pipeline, use `src/main/java` as save location, no package name
3. Change the following entries:
    - `import edu.wpi.first.wpilibj.vision.VisionPipeline;`
    to `import edu.wpi.first.vision.VisionPipeline;`
    - `import org.opencv.features2d.FeatureDetector;`
    to `import org.opencv.features2d.*;`
4. Things like SimpleBlobDector may have depreciated, check the openCV docs for more info

## Building Grade
- Windows<br>>
    `gradlew.bat build`
- Linux<br>$
    `./gradlew build`

## Uploading .jar to Pi
-- TODO --

## Using OutlineViewer
Local port is 127.0.0.1
