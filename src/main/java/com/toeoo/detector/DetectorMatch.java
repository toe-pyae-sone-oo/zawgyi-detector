package com.toeoo.detector;

public class DetectorMatch {

    private DetectedEnc detectedEnc;

    private double probability;

    private int start;

    private int length;

    private String matchedString;

    private DetectorMatch competitorMatch;

    public DetectorMatch() {
    }

    public DetectorMatch(DetectedEnc detectedEnc, double probability, int start, int length, String matchedString, DetectorMatch competitorMatch) {
        this.detectedEnc = detectedEnc;
        this.probability = probability;
        this.start = start;
        this.length = length;
        this.matchedString = matchedString;
        this.competitorMatch = competitorMatch;
    }

    public DetectedEnc getDetectedEnc() {
        return detectedEnc;
    }

    public void setDetectedEnc(DetectedEnc detectedEnc) {
        this.detectedEnc = detectedEnc;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMatchedString() {
        return matchedString;
    }

    public void setMatchedString(String matchedString) {
        this.matchedString = matchedString;
    }

    public DetectorMatch getCompetitorMatch() {
        return competitorMatch;
    }

    public void setCompetitorMatch(DetectorMatch competitorMatch) {
        this.competitorMatch = competitorMatch;
    }
}
