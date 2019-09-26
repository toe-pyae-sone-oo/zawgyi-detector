package com.toeoo.detector;

public class InternalMatchResult {
    private DetectorMatch sd;
    private DetectorMatch cd;

    public InternalMatchResult() {
    }

    public InternalMatchResult(DetectorMatch sd, DetectorMatch cd) {
        this.sd = sd;
        this.cd = cd;
    }

    public DetectorMatch getSd() {
        return sd;
    }

    public void setSd(DetectorMatch sd) {
        this.sd = sd;
    }

    public DetectorMatch getCd() {
        return cd;
    }

    public void setCd(DetectorMatch cd) {
        this.cd = cd;
    }
}
