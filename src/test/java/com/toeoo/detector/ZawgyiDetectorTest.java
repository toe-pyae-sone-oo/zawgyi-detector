package com.toeoo.detector;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ZawgyiDetectorTest {

    private ZawgyiDetector detector;

    @Before
    public void init() {
        this.detector = new ZawgyiDetector();
    }

    @Test
    public void test_uni() {
        List<String> uniData = Arrays.asList(
                "တစ္ဆေ",
                "ဝေဝေ",
                "လမ်းပိတ်ဆို ရန်ရှာရိုက်နှက်ပြီး ငွေကြေးလုယက်သူ ရှစ်ဦးကို ဖမ်းမိ",
                "လမ်းပိတ်ဆို",
                "ဥုံဩောင်း",
                "ကစိန်းက၀ါး",
                "ကုန်ထုတ်သမဝါယမ",
                "မဥ္ဇရီ",
                "မဥ္ဇူ",
                "မင်္ဂလာပါ",
                "မင်းသိင်္ခ"
        );

        Map<String, DetectedEnc> detected = new HashMap<>();
        uniData.forEach(str -> {
            DetectorResult result = detector.detect(str);
            detected.put(str, result.getDetectedEnc());
        });

        boolean isUni = detected.values()
                .stream().allMatch(DetectedEnc.uni::equals);

        if (!isUni) {
            detected.forEach((str, type) -> {
                String output = String.format("%s: %s", str, type);
                System.out.println(output);
            });
        }

        assertTrue(isUni);
    }

    @Test
    public void test_zg() {
        List<String> zgData = Arrays.asList(
                "တေစၧ",
                "ေဝေဝ",
                "လမ္းပိတ္ဆို ရန္႐ွာ႐ိုက္ႏွက္ၿပီး ေငြေၾကးလုယက္သူ ႐ွစ္ဦးကို ဖမ္းမိ",
                "လမ္းပိတ္ဆို",
                "ဥဳံေဩာင္း",
                "ကစိန္းက၀ါး",
                "ကုႏၳဳတ္သမဝါယမ",
                "မၪၨရီ",
                "မၪၨဴ",
                "မဂၤလာပါ",
                "မင္းသိခၤ"
        );

        Map<String, DetectedEnc> detected = new HashMap<>();
        zgData.forEach(str -> {
            DetectorResult result = detector.detect(str);
            detected.put(str, result.getDetectedEnc());
        });

        boolean isZg = detected.values()
                .stream().allMatch(DetectedEnc.zg::equals);

        if (!isZg) {
            detected.forEach((str, type) -> {
                String output = String.format("%s: %s", str, type);
                System.out.println(output);
            });
        }

        assertTrue(isZg);
    }
}
