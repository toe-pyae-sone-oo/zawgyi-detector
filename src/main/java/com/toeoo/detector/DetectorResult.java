package com.toeoo.detector;

import java.util.Collections;
import java.util.List;

public class DetectorResult {
    private DetectedEnc detectedEnc;

    private long duration;

    private List<DetectorMatch> matches;

    public static DetectorResult defaultResult() {
        return new DetectorResult(DetectedEnc.none, 0, Collections.emptyList());
    }

    public DetectorResult() {
    }

    public DetectorResult(DetectedEnc detectedEnc, long duration, List<DetectorMatch> matches) {
        this.detectedEnc = detectedEnc;
        this.duration = duration;
        this.matches = matches;
    }

    public DetectedEnc getDetectedEnc() {
        return detectedEnc;
    }

    public void setDetectedEnc(DetectedEnc detectedEnc) {
        this.detectedEnc = detectedEnc;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<DetectorMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<DetectorMatch> matches) {
        this.matches = matches;
    }
}
