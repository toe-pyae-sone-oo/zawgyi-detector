package com.toeoo.detector;

public class ZawgyiDetectorOptions {
    private Boolean preferZg;

    private Boolean detectMixType;

    public ZawgyiDetectorOptions() {
    }

    public ZawgyiDetectorOptions(Boolean preferZg, Boolean detectMixType) {
        this.preferZg = preferZg;
        this.detectMixType = detectMixType;
    }

    public Boolean getPreferZg() {
        return preferZg;
    }

    public void setPreferZg(Boolean preferZg) {
        this.preferZg = preferZg;
    }

    public Boolean getDetectMixType() {
        return detectMixType;
    }

    public void setDetectMixType(Boolean detectMixType) {
        this.detectMixType = detectMixType;
    }

}
