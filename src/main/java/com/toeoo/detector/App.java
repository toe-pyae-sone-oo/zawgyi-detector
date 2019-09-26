package com.toeoo.detector;

public class App {

    public static void main(String[] args) {
        ZawgyiDetector detector = new ZawgyiDetector();
        DetectorResult result = detector.detect("မဥ္ဇူ");
        System.out.println(result.getDetectedEnc());
    }
}
