package com.toeoo.detector;

import java.util.*;
import java.util.regex.Pattern;

import static com.toeoo.detector.Constants.*;

public class ZawgyiDetector {

    private final String[][] uniPahsinWords = UniPahsinWords.getWords(); // add data

    // Separator
    private final Pattern _seperatorRegExp = Pattern.compile("[#\\*\\(\\[\\{\\'\\\"]?[\\s]?(zawgyi|unicode|zg|uni|(\\u101A\\u1030\\u1014\\u102D?\\u102E\\u1000\\u102F[\\u1010\\u1012][\\u1039\\u103A])|(\\u1007\\u1031\\u102C\\u103A\\u1002\\u103B\\u102E)|(\\u1031\\u1007\\u102C\\u1039\\u1002\\u103A\\u102D?\\u102E))");
    private final Pattern _mixBlockTestRegExp = Pattern.compile("[\\u1000-\\u1097]");
    private final Pattern _spRegExp = Pattern.compile("[" + rSp + "]");

    // Zg
    private final Pattern _zgAllAcAfCRegExp = Pattern.compile("^[" + rZgAcAfC + rZgAcKsAfC + "]");
    private final Pattern _zg31WCRegExp = Pattern.compile("^\\u1031+[" + rSp + "]*[" + rZg3b + "]*[" + rSp + "]*" + rZgCAndOpG);

    private final Pattern _zg31WPahsinSgRegExp = Pattern.compile("^\\u1031+[" + rSp + "]*[" + rZg3b + "]*[" + rSp + "]*" + rZgPsSgAndOpG);
    private final Pattern _zg31WPahsinDbRegExp = Pattern.compile("^\\u1031+[" + rSp + "]*[" + rZg3b + "]*[" + rSp + "]*" + rZgPsDbAndOpG);
    private final Pattern _zg3bWCRegExp = Pattern.compile("^[" + rZg3b + "]+[" + rSp + "]*" + rZgCAndOpG);
    private final Pattern _zg3bWPahsinSgRegExp = Pattern.compile("^[" + rZg3b + "]+[" + rSp + "]*" + rZgPsSgAndOpG);
    private final Pattern _zg3bWPahsinDbRegExp = Pattern.compile("^[" + rZg3b + "]+[" + rSp + "]*" + rZgPsDbAndOpG);
    private final Pattern _zgPahsinDbRegExp = Pattern.compile("^" + rZgPsDbAndOpG);
    private final Pattern _zgPahsinSgRegExp = Pattern.compile("^" + rZgPsSgAndOpG);
    private final Pattern _zgCAndOptionalRegExp = Pattern.compile("^" + rZgCAndOpG);

    private final Pattern _zg31WCAndAThatRegExp = Pattern.compile("^\\u1031+[" + rSp + "]*[" + rZg3b + "]*[" + rSp + "]*[" + rZgC1For3a + "]([" + rSp + "]*[" + rZgAcKsAfC + "])*[\\u102B\\u102C]" + rZgCAndAThatG);
    private final Pattern _zg31WPahsinSgAndAThatRegExp = Pattern.compile("^\\u1031+[" + rSp + "}]*[" + rZg3b + "]*[" + rSp + "]*[" + rZgPsSgC + "]([" + rSp + "]*[" + rZgAcKsAfC + "])*[\\u102B\\u102C]" + rZgCAndAThatG);
    private final Pattern _zg31WPahsinDbAndAThatRegExp = Pattern.compile("^\\u1031+[" + rSp + "}]*[" + rZg3b + "]*[" + rSp + "]*" + rZgPsDbG + "([" + rSp + "]*[" + rZgAcKsAfC + "])*[\\u102B\\u102C]" + rZgCAndAThatG);
    private final Pattern _zg3bWCAndAThatRegExp = Pattern.compile("^[" + rZg3b + "]+[" + rSp + "]*[" + rZgC1For3a + "]([" + rSp + "]*[" + rZgAcKsAfC + "])*[\\u102B\\u102C]" + rZgCAndAThatG);
    private final Pattern _zg3bWPahsinSgAndAThatRegExp = Pattern.compile("^[" + rZg3b + "]+[" + rSp + "]*[" + rZgPsSgC + "]([" + rSp + "]*[" + rZgAcKsAfC + "])*[\\u102B\\u102C]" + rZgCAndAThatG);
    private final Pattern _zg3bWPahsinDbAndAThatRegExp = Pattern.compile("^[" + rZg3b + "]+[" + rSp + "]" + rZgPsDbG + "([" + rSp + "]*[" + rZgAcKsAfC + "])*[\\u102B\\u102C]" + rZgCAndAThatG);
    private final Pattern _zgCAndAThatRegExp = Pattern.compile("^" + rZgCAndAThatG);

    private final Pattern _zgOnlyCAndAcAfCRegExp = Pattern.compile("[" + rZgOnlyCAndAcAfC + "]");
    private final Pattern _zgOnlyCAndAcAfCFor31Or3bRegExp = Pattern.compile("[" + rZgOnlyCAndAcAfC + "\\u107E-\\u1084]");
    private final Pattern _zgOnlyAc2bOr2cCbRegExp = Pattern.compile("[\\u102B\\u102C]\\u1039");
    private final Pattern _zgOnlyAc2dOr2eCbRegExp = Pattern.compile("[\\u102D\\u102E][\\u1033\\u1034\\u103A\\u103C\\u103D]");
    private final Pattern _zgOnlyAc2fOr30CbRegExp = Pattern.compile("[\\u102F\\u1030\\u1033\\u1034][\\u102D\\u102E\\u1039\\u103C\\u103D]");
    private final Pattern _zgOnlyAc32Or36CbRegExp = Pattern.compile("[\\u1032\\u1036][\\u102D-\\u1030\\u1033\\u1034\\u103A\\u103C\\u103D]");
    private final Pattern _zgOnlyAc37CbRegExp = Pattern.compile("\\u1037[\\u102D\\u102E\\u1032\\u1036\\u1039\\u103C\\u103D]");
    private final Pattern _zgOnlyAc39CbRegExp = Pattern.compile("\\u1039[\\u102B\\u102C\\u102F\\u1030\\u1037\\u1038\\u103A\\u103C\\u103D]");
    private final Pattern _zgOnlyAc3ACbRegExp = Pattern.compile("\\u103A[\\u102B-\\u102E\\u1032-\\u1034\\u1036\\u1039\\u103C\\u103D]");
    private final Pattern _zgCNotCompat3aRegExp = Pattern.compile("[\\u1003\\u1004\\u1006-\\u100F\\u1011-\\u1014\\u1018\\u101B\\u101F-\\u1021\\u1023-\\u1027\\u1029\\u102A]");
    private final Pattern _zgHasUniPsLoCRegExp = Pattern.compile("^[" + rUniPsLoC + "]");
    private final Pattern _zgCNotCompatWith3dRegExp = Pattern.compile("[\\u1000\\u1002\\u1005-\\u1008\\u100B-\\u100E\\u1010-\\u1013\\u1018\\u101E\\u1020\\u1021\\u1023-\\u1027\\u1029\\u102A]");

    // Uni
    private final Pattern _uniAllAcAnd60To97RegExp = Pattern.compile("^[\\u102B-\\u103E\\u105A\\u1060-\\u1097]");
    private final Pattern _uniKsAndPsRegExp = Pattern.compile("^\\u1004\\u103A\\u1039[" + rUniPsUpC + "]\\u1039[" + rUniPsLoC + "]\\u103A?\\u103B?\\u103C?(\\u103D\\u103E|[\\u103D\\u103E])?\\u103A?\\u1031?" + rUniAcAf31G);
    private final Pattern _uniKsAndCRegExp = Pattern.compile("^\\u1004\\u103A\\u1039[" + rUniC + "]\\u103A?\\u103B?\\u103C?(\\u103D\\u103E|[\\u103D\\u103E])?\\u103A?\\u1031?" + rUniAcAf31G);
    private final Pattern _uniPsRegExp = Pattern.compile("^[" + rUniPsUpC + "]\\u1039[" + rUniPsLoC + "]\\u103A?\\u103B?\\u103C?(\\u103D\\u103E|[\\u103D\\u103E])?\\u103A?\\u1031?" + rUniAcAf31G);
    private final Pattern _uniPsLeftEndRegExp = Pattern.compile("[" + rUniC + "]\\u103B?\\u103C?[\\u103D\\u103E]?\\u1031?\\u102D?\\u102F?[\\u102B\\u102C]?$");
    private final Pattern _uniCAndOptionalRegExp = Pattern.compile("^[" + rUniC + "]\\u103A?\\u103B?\\u103C?(\\u103D\\u103E|[\\u103D\\u103E])?\\u103A?\\u1031?" + rUniAcAf31G);

    private final Pattern _uniOnlyAcAf31RegExp = Pattern.compile("[\\u102B\\u102C\\u1037\\u1038]");
    private final Pattern _uniOnlyAcAf3bRegExp = Pattern.compile("[\\u102B-\\u1038\\u103A\\u103D\\u103E]");

    // Ks AThat (e.g. က်ျား)
    private final Pattern _uniCKsAThatRegExp = Pattern.compile("^[" + rUniC + "]" + rUniKsAThatSuffixG);

    // AThat with \u1031 + C2 (ကြောင် | လျှောင် | ငေါင် | ခေတ်)
    private final Pattern _uniC31CAThatRegExp = Pattern.compile("^[" + rUniC1BfAThat + "]" + rUniC31CAThatSuffixG);
    private final Pattern _uniPs31CAThatRegExp = Pattern.compile("^[" + rUniPsUpC + "]\\u1039[" + rUniC1BfAThat + "]" + rUniC31CAThatSuffixG);

    // AThat with \u1031 (e.g. ကျော် | လျှော် | တော် | ခေါ်)
    private final Pattern _uniC312cAThatRegExp = Pattern.compile("^[" + rUniC1BfAThat + "]" + rUni312cAThatSuffixG);
    private final Pattern _uniPs312cAThatRegExp = Pattern.compile("^[" + rUniPsUpC + "]\\u1039[" + rUniC1BfAThat + "]" + rUni312cAThatSuffixG);

    // C1 + C2 + AThat (e.g. ကျင် | ကွင် | ငင်)
    private final Pattern _uniC1C2AThatRegExp = Pattern.compile("^[" + rUniC1BfAThat + "]" + rUniC1C2AThatSuffixG);
    private final Pattern _uniPsC2AThatRegExp = Pattern.compile("^[" + rUniPsUpC + "]\\u1039[" + rUniC1BfAThat + "]" + rUniC1C2AThatSuffixG);

    // Compat with AThat
    private final Pattern _uniC1CompatWithAThat = Pattern.compile("[" + rUniC1BfAThat + "][\\u103B\\u103C]?[\\u103D\\u103E]?\\u1031?[\\u102D\\u102E]?[\\u102F\\u1030]?[\\u102B\\u102C]?$");
    private final Pattern _uniLastCCompatWithKsAThat = Pattern.compile("[" + rUniC1BfAThat + "]\\u103E?\\u1031[\\u102B\\u102C]$");
    private final Pattern _uniCAThatCompatRegExp = Pattern.compile("^[" + rCForAThat + "]\\u103A");

    // Probabilities
    private final double _pZg31Or3b95 = 0.95;
    private final double _pZg31Or3b85 = 0.85;
    private final double _pZg31Or3b53 = 0.53;
    private final double _pZg31Or3b50 = 0.5;

    private final double _pZgPs95 = 0.95;
    private final double _pZgPs90 = 0.9;

    private final double _pUniKs95 = 0.95;
    private final double _pUniKs85 = 0.85;
    private final double _pUniKs80 = 0.8;
    private final double _pUniKs75 = 0.75;
    private final double _pUniKs60 = 0.6;

    private final double _pUniPs95 = 0.95;
    private final double _pUniPs60 = 0.6;
    private final double _pUniPs50 = 0.5;

    private final double _pAThat95 = 0.95;
    private final double _pAThat75 = 0.75;
    private final double _pAThat54 = 0.54;
    private final double _pAThat50 = 0.5;

    private final double _pUniCMax = 1;
    private final double _pC95 = 0.95;
    private final double _pC85 = 0.85;
    private final double _pC55 = 0.55;
    private final double _pC54 = 0.54;
    private final double _pC52 = 0.52;
    private final double _pC50 = 0.5;
    private final double _pC20 = 0.2;

    private final ZawgyiDetectorOptions _options;

    public ZawgyiDetector() {
        this._options = new ZawgyiDetectorOptions(false, false);
    }

    public DetectorResult detect(String input) {
        Objects.requireNonNull(input, "Input must not be null!");

        ZawgyiDetectorOptions curOptions = this._options;

        final Date startTime = new Date();

        final DetectorResult result = DetectorResult.defaultResult();

        if (input.length() == 0 || input.trim().length() == 0) {
            long elapsedTime = new Date().getTime() - startTime.getTime();
            result.setDuration(Math.max(elapsedTime, 0L));

            DetectorMatch match = new DetectorMatch();
            match.setDetectedEnc(DetectedEnc.none);
            match.setProbability(0);
            match.setStart(0);
            match.setLength(0);
            match.setMatchedString(input);
            result.setMatches(Collections.singletonList(match));
        }

        String curStr = input;
        int curStart = 0;
        String lastStr = "";
        DetectedEnc lastEnc = DetectedEnc.none;

        while (curStr.length() > 0) {

            final InternalMatchResult r = this.detectInternal(curStr, lastEnc, lastStr, curOptions);
            final DetectorMatch sd = r.getSd();
            final DetectorMatch cd = r.getCd();

            if ((sd == null || sd.getDetectedEnc() == DetectedEnc.none) && lastEnc != DetectedEnc.none) {
                final DetectorMatch lastMatch = result.getMatches()
                        .get(result.getMatches().size() - 1);
                lastMatch.setLength(lastMatch.getLength() + curStr.length());
                lastMatch.setMatchedString(lastMatch.getMatchedString() + curStr);

                break;
            }

            if (sd == null || sd.getDetectedEnc() == DetectedEnc.none || !curOptions.getDetectMixType()) {
                DetectorMatch match = new DetectorMatch();
                match.setDetectedEnc(sd != null ? sd.getDetectedEnc() : DetectedEnc.none);
                match.setProbability(sd != null ? sd.getProbability() : 0);
                match.setStart(curStart);
                match.setLength(curStr.length());
                match.setMatchedString(curStr);
                match.setCompetitorMatch(cd);

                List<DetectorMatch> matches = new ArrayList<>(result.getMatches());
                matches.add(match);
                result.setMatches(matches);

                break;
            }

            if (lastEnc == sd.getDetectedEnc() && result.getMatches().size() > 0) {
                final DetectorMatch lastMatch = result.getMatches()
                        .get(result.getMatches().size() - 1);

                if (lastMatch.getProbability() > 0 & sd.getProbability() > 0) {
                    lastMatch.setProbability((lastMatch.getProbability() + sd.getProbability()) / 2);
                }

                lastMatch.setLength(lastMatch.getLength() + sd.getLength());
                lastMatch.setMatchedString(lastMatch.getMatchedString() + sd.getMatchedString());

                if (lastMatch.getCompetitorMatch() != null && cd != null) {
                    final DetectorMatch lastCompetitorMatch = lastMatch.getCompetitorMatch();
                    if (lastCompetitorMatch.getProbability() > 0 && cd.getProbability() > 0) {
                        lastCompetitorMatch.setProbability((lastCompetitorMatch.getProbability() + cd.getProbability()) / 2);
                    }
                    lastCompetitorMatch.setLength(lastCompetitorMatch.getLength() + cd.getLength());
                    lastCompetitorMatch.setMatchedString(lastCompetitorMatch.getMatchedString() + cd.getMatchedString());
                }
            } else {
                DetectorMatch match = new DetectorMatch();
                match.setCompetitorMatch(sd);
                match.setStart(curStart);
                match.setCompetitorMatch(cd);

                List<DetectorMatch> matches = new ArrayList<>(result.getMatches());
                matches.add(match);
                result.setMatches(matches);
            }

            lastEnc = sd.getDetectedEnc();
            lastStr += sd.getMatchedString();
            curStart += sd.getLength();
            curStr = curStr.substring(sd.getLength());
        }

        if (result.getMatches().size() > 1) {
            result.setDetectedEnc(DetectedEnc.mix);
        } else if (result.getMatches().size() == 1 && result.getMatches().get(0).getDetectedEnc() == DetectedEnc.zg) {
            result.setDetectedEnc(DetectedEnc.zg);
        } else if (result.getMatches().size() == 1 && result.getMatches().get(0).getDetectedEnc() == DetectedEnc.uni) {
            result.setDetectedEnc(DetectedEnc.uni);
        } else {
            result.setDetectedEnc(DetectedEnc.none);
        }

        result.setDuration(Math.max(new Date().compareTo(startTime), 0));

        return result;
    }

    private InternalMatchResult detectInternal(String curStr,
                                               DetectedEnc lastEnc,
                                               String lastStr,
                                               ZawgyiDetectorOptions curOptions) {

        Optional<DetectorMatch> zd = Optional.empty();
        Optional<DetectorMatch> ud = Optional.empty();

        boolean zdChecked = false;

        final char c = curStr.trim().charAt(0);

        if (c == '\u1031' || c == '\u103B' || c == '\u107E' ||
                c == '\u107F' || c == '\u1080' || c == '\u1081' ||
                c == '\u1082' || c == '\u1083' || c == '\u1084') {
            zd = this.detectZg(curStr, lastEnc, lastStr);
            zdChecked = true;
        }

        if (!zd.isPresent() || zd.get().getProbability() < 0.95 || zd.get().getMatchedString().length() != curStr.length()) {
            ud = this.detectUni(curStr, lastEnc, lastStr);
        }

        if (!zdChecked && (!ud.isPresent() || ud.get().getProbability() < 0.95 || ud.get().getMatchedString().length() != curStr.length())) {
            zd = this.detectZg(curStr, lastEnc, lastStr);
        }

        Optional<DetectorMatch> sd = Optional.empty();
        Optional<DetectorMatch> cd = Optional.empty();

        if (ud.isPresent() && zd.isPresent()) {
            if (zd.get().getDetectedEnc() != DetectedEnc.none && ud.get().getDetectedEnc() != DetectedEnc.none) {
                if (zd.get().getLength() == ud.get().getLength()) {
                    double diff = ud.get().getProbability() - zd.get().getProbability();
                    if (diff == 0) {
                        if (lastEnc == DetectedEnc.uni) {
                            sd = ud;
                        } else if (lastEnc == DetectedEnc.zg) {
                            sd = zd;
                        } else {
                            sd = curOptions.getPreferZg() ? zd : ud;
                        }
                    } else if (diff < 0) {
                        if (lastEnc == DetectedEnc.uni && ud.get().getProbability() > 0.5 && -diff < 0.02) {
                            sd = ud;
                        } else {
                            sd = zd;
                        }
                    } else {
                        if (lastEnc == DetectedEnc.zg && zd.get().getProbability() > 0.5 && (diff < 0.02 || (curOptions.getPreferZg() && diff < 0.021))) {
                            sd = zd;
                        } else {
                            sd = ud;
                        }
                    }
                } else if (zd.get().getLength() > ud.get().getLength()) {
                    sd = zd;
                } else {
                    sd = ud;
                }
            } else if (zd.get().getDetectedEnc() == DetectedEnc.none && ud.get().getDetectedEnc() == DetectedEnc.none) {
                sd = zd.get().getLength() > ud.get().getLength() ? zd : ud;
            } else {
                sd = zd.get().getDetectedEnc() != DetectedEnc.none ? zd : ud;
            }

            cd = sd.get().getDetectedEnc() == DetectedEnc.uni ? zd : ud;
        } else if (ud.isPresent()) {
            sd = ud;
        } else if (zd.isPresent()) {
            sd = zd;
        }

        return new InternalMatchResult(sd.orElse(null), cd.orElse(null));
    }

    private Optional<DetectorMatch> detectZg(String curStr, DetectedEnc lastEnc, String lastStr) {
        String curMatchedStr = "";
        double accProb = 0;
        boolean hasGreatProb = false;
        int seperatorStart = -1;
        boolean startOfNewChuck = true;
        boolean zgDetected = false;
        boolean hasUnDeteactableStart = false;

        while (curStr.length() > 0) {
            Optional<DetectorMatch> d = this.detectZg31Start(curStr, lastEnc, lastStr + curMatchedStr, hasGreatProb);

            if (!d.isPresent()) {
                d = this.detectZg3bStart(curStr, lastEnc, lastStr + curMatchedStr, hasGreatProb);
            }

            if (!d.isPresent()) {
                d = this.detectZgPahsin(curStr, lastEnc, lastStr + curMatchedStr, hasGreatProb);
            }

            if (!d.isPresent()) {
                d = this.detectZgC(curStr, lastEnc, lastStr + curMatchedStr, hasGreatProb);
            }

            if (d.isPresent()) {
                startOfNewChuck = false;
                zgDetected = true;

                if (!hasGreatProb && d.get().getProbability() >= 0.85) {
                    hasGreatProb = true;
                }
            } else {
                d = this.detectOtherChars(curStr, lastEnc, lastStr + curMatchedStr, startOfNewChuck);
                if (d.isPresent() && d.get().getStart() > -1) {
                    seperatorStart = d.get().getStart();
                }
                if (d.isPresent() && d.get().getProbability() > 0 && d.get().getProbability() < 0.1) {
                    hasUnDeteactableStart = true;
                }
            }

            if (!d.isPresent()) {
                break;
            }

            curMatchedStr += d.get().getMatchedString();
            lastEnc = d.get().getDetectedEnc();
            curStr = curStr.substring(d.get().getMatchedString().length());

            if (d.get().getProbability() > 0) {
                accProb = accProb == 0 ? d.get().getProbability() : (accProb + d.get().getProbability()) / 2;
            }

            if (seperatorStart > -1) {
                break;
            }
        }

        if (curMatchedStr.length() == 0) {
            return Optional.empty();
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(zgDetected || accProb >= 0.5 || hasUnDeteactableStart ? DetectedEnc.zg : DetectedEnc.none);
        match.setProbability(accProb);
        match.setStart(seperatorStart);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);

        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectZg31Start(String curStr, DetectedEnc lastEnc, String lastStr, boolean hasGreatProb) {

        if (curStr.length() < 2) {
            return Optional.empty();
        }

        if (curStr.charAt(0) != '\u1031') {
            return Optional.empty();
        }

        String curMatchedStr = "";
        boolean aThatMatched = false;
        boolean pahsinMatched = false;

        if (curStr.length() >= 3) {
            List<String> m = DetectorUtils
                    .match(this._zg31WPahsinDbRegExp, curStr);

            if (m.size() > 0) {
                curMatchedStr = m.get(0);
                pahsinMatched = true;
                final char lastC = curMatchedStr.charAt(curMatchedStr.length() - 1);

                if (lastC == '\u102B' || lastC == '\u102C') {
                    List<String> m2 = DetectorUtils.match(this._zg31WPahsinDbAndAThatRegExp, curStr);
                    if (m2.size() > 0) {
                        curMatchedStr = m2.get(0);
                        aThatMatched = true;
                    }
                }
            }
        }

        if (curMatchedStr.length() == 0) {
            List<String> m = DetectorUtils.match(this._zg31WPahsinSgRegExp, curStr);
            if (m.size() > 0) {
                curMatchedStr = m.get(0);
                pahsinMatched = true;
                final char lastC = curMatchedStr.charAt(curMatchedStr.length() - 1);

                if (lastC == '\u102B' || lastC == '\u102C') {
                    List<String> m2 = DetectorUtils.match(this._zg31WPahsinSgAndAThatRegExp, curStr);
                    if (m2.size() > 0) {
                        curMatchedStr = m2.get(0);
                        aThatMatched = true;
                    }
                }
            }
        }

        if (curMatchedStr.length() == 0) {
            List<String> m = DetectorUtils.match(this._zg31WCRegExp, curStr);
            if (m.size() > 0) {
                curMatchedStr = m.get(0);
                final char lastC = curMatchedStr.charAt(curMatchedStr.length() - 1);
                if (lastC == '\u102B' || lastC == '\u102C') {
                    final List<String> m2 = DetectorUtils.match(this._zg31WCAndAThatRegExp, curStr);
                    if (m2.size() > 0) {
                        curMatchedStr = m2.get(0);
                        aThatMatched = true;
                    }
                }
            }
        }

        if (curMatchedStr.length() == 0) {
            return Optional.empty();
        }

        final double probability = this.getProbForZg31(curStr, lastEnc,
                lastStr, hasGreatProb, curMatchedStr, aThatMatched,
                pahsinMatched);

        DetectorMatch detectorMatch = new DetectorMatch();
        detectorMatch.setDetectedEnc(DetectedEnc.zg);
        detectorMatch.setProbability(probability);
        detectorMatch.setStart(-1);
        detectorMatch.setLength(curMatchedStr.length());
        detectorMatch.setMatchedString(curMatchedStr);

        return Optional.of(detectorMatch);
    }

    private double getProbForZg31(String curStr,
                                  DetectedEnc lastEnc,
                                  String lastStr,
                                  boolean hasGreatProb,
                                  String curMatchedStr,
                                  boolean aThatMatched,
                                  boolean pahsinMatched) {

        double probability;

        if ((lastStr.length() == 0 || lastEnc == DetectedEnc.none) &&
                curMatchedStr.length() == curStr.trim().length()) {
            probability = this._pZg31Or3b95;
        } else if (lastStr.length() == 0 || lastEnc == DetectedEnc.none) {
            probability = this._pZg31Or3b85;
        } else if (curMatchedStr.length() > 2 &&
                (this._zgOnlyCAndAcAfCFor31Or3bRegExp.matcher(curMatchedStr).find() || this.containsZgOnlyAcCombine(curMatchedStr))) {
            probability = this._pZg31Or3b95;
        } else if (pahsinMatched) {
            probability = this._pZg31Or3b95;
        } else if (curMatchedStr.length() == curStr.trim().length() && curMatchedStr.endsWith("\u1039")) {
            probability = this._pZg31Or3b95;
        } else if (aThatMatched || curMatchedStr.contains("\u1039")) {
            final int c39Index = curMatchedStr.indexOf("\u1039");
            final String testStr = c39Index == curMatchedStr.length() - 1 ?
                    curStr.substring(curMatchedStr.length()) :
                    curMatchedStr.substring(c39Index + 1);
            final String cAf39 = testStr.length() > 0 ? testStr.charAt(0) + "" : "";

            if (cAf39.length() > 0 && this._zgHasUniPsLoCRegExp.matcher(cAf39).find()) {
                probability = this._pZg31Or3b50;
            } else {
                probability = lastEnc.equals(DetectedEnc.zg) && hasGreatProb ?
                        this._pZg31Or3b53 : this._pZg31Or3b50;
            }
        } else if (curMatchedStr.contains(" ") || this._spRegExp.matcher(curMatchedStr).find()) {
            probability = this._pC52;
        } else {
            probability = this._pZg31Or3b50;
        }

        return probability;
    }

    private boolean containsZgOnlyAcCombine(String curMatchedStr) {
        if (curMatchedStr.length() > 2 && (this._zgOnlyAc2bOr2cCbRegExp.matcher(curMatchedStr).find() ||
                this._zgOnlyAc2dOr2eCbRegExp.matcher(curMatchedStr).find() || this._zgOnlyAc2fOr30CbRegExp.matcher(curMatchedStr).find() ||
                this._zgOnlyAc32Or36CbRegExp.matcher(curMatchedStr).find() || this._zgOnlyAc39CbRegExp.matcher(curMatchedStr).find() ||
                this._zgOnlyAc37CbRegExp.matcher(curMatchedStr).find() || this._zgOnlyAc3ACbRegExp.matcher(curMatchedStr).find())) {
            return true;
        }

        return false;
    }

    private Optional<DetectorMatch> detectZg3bStart(String curStr,
                                                    DetectedEnc lastEnc,
                                                    String lastStr,
                                                    boolean hasGreatProb) {

        if (curStr.length() < 2) {
            return Optional.empty();
        }

        final char c = curStr.charAt(0);

        if (c != '\u103B' && c != '\u107E' && c != '\u107F' && c != '\u1080' &&
                c != '\u1081' && c != '\u1082' && c != '\u1083' && c != '\u1084') {
            return Optional.empty();
        }

        String curMatchedStr = "";
        boolean pahsinMatched = false;
        boolean aThatMatched = false;

        if (curStr.length() >= 3) {
            List<String> m = DetectorUtils.match(this._zg3bWPahsinDbRegExp, curStr);
            if (m.size() > 0) {
                curMatchedStr = m.get(0);
                pahsinMatched = true;
                final char lastC = curMatchedStr.charAt(curMatchedStr.length() - 1);

                if (lastC == '\u102B' || lastC == '\u102C') {
                    List<String> m2 = DetectorUtils.match(this._zg3bWPahsinDbAndAThatRegExp, curStr);
                    if (m2.size() > 0) {
                        curMatchedStr = m2.get(0);
                        aThatMatched = true;
                    }
                }
            }
        }

        if (curMatchedStr.length() == 0) {
            List<String> m = DetectorUtils.match(this._zg3bWPahsinSgRegExp, curStr);
            if (m.size() > 0) {
                curMatchedStr = m.get(0);
                pahsinMatched = true;
                final char lastC = curMatchedStr.charAt(curMatchedStr.length() - 1);

                if (lastC == '\u102B' || lastC == '\u102C') {
                    List<String> m2 = DetectorUtils.match(this._zg3bWPahsinSgAndAThatRegExp, curStr);
                    if (m2.size() > 0) {
                        curMatchedStr = m2.get(0);
                        aThatMatched = true;
                    }
                }
            }
        }

        if (curMatchedStr.length() == 0) {
            List<String> m = DetectorUtils.match(this._zg3bWCRegExp, curStr);
            if (m.size() > 0) {
                curMatchedStr = m.get(0);
                final char lastC = curMatchedStr.charAt(curMatchedStr.length() - 1);

                if (lastC == '\u102B' || lastC == '\u102C') {
                    List<String> m2 = DetectorUtils.match(this._zg3bWCAndAThatRegExp, curStr);
                    if (m2.size() > 0) {
                        curMatchedStr = m2.get(0);
                        aThatMatched = true;
                    }
                }
            }
        }

        if (curMatchedStr.length() == 0) {
            return Optional.empty();
        }

        final double probability = this.getProbForZg3b(curStr, lastEnc, lastStr, hasGreatProb, curMatchedStr, aThatMatched, pahsinMatched);

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.zg);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);

        return Optional.of(match);
    }

    private double getProbForZg3b(String curStr,
                                  DetectedEnc lastEnc,
                                  String lastStr,
                                  boolean hasGreatProb,
                                  String curMatchedStr,
                                  boolean aThatMatched,
                                  boolean pahsinMatched) {

        double probability;

        if ((lastStr.length() == 0 || lastEnc == DetectedEnc.none) && curMatchedStr.length() == curStr.trim().length()) {
            probability = this._pZg31Or3b95;
        } else if (lastStr.length() == 0 || lastEnc == DetectedEnc.none) {
            probability = this._pZg31Or3b85;
        } else if (curMatchedStr.length() > 2 &&
                (this._zgOnlyCAndAcAfCFor31Or3bRegExp.matcher(curMatchedStr).find() || this.containsZgOnlyAcCombine(curMatchedStr))) {
            probability = this._pZg31Or3b95;
        } else if (pahsinMatched) {
            probability = this._pZg31Or3b95;
        } else if (curMatchedStr.length() == curStr.trim().length() && curMatchedStr.endsWith("\u1039")) {
            probability = this._pZg31Or3b95;
        } else if (aThatMatched || curMatchedStr.contains("\u1039")) {
            final int c39Index = curMatchedStr.indexOf("\u1039");
            final String testStr = c39Index == curMatchedStr.length() - 1 ?
                    curStr.substring(curMatchedStr.length()) :
                    curMatchedStr.substring(c39Index + 1);
            final String cAf39 = testStr.length() > 0 ? testStr.charAt(0) + "" : "";

            if (cAf39.length() != 0 && this._zgHasUniPsLoCRegExp.matcher(cAf39).find()) {
                probability = this._pZg31Or3b50;
            } else {
                probability = lastEnc == DetectedEnc.zg && hasGreatProb
                        ? this._pZg31Or3b53 : this._pZg31Or3b50;
            }
        } else if (curMatchedStr.contains(" ") || this._spRegExp.matcher(curMatchedStr).find()) {
            probability = this._pC52;
        } else {
            probability = this._pZg31Or3b50;
        }

        return probability;
    }

    private Optional<DetectorMatch> detectZgPahsin(String curStr,
                                                   DetectedEnc lastEnc,
                                                   String lastStr,
                                                   boolean hasGreatProb) {

        List<String> m = Collections.emptyList();

        if (curStr.length() > 1) {
            m = DetectorUtils.match(this._zgPahsinDbRegExp, curStr);
        }

        if (m.size() == 0) {
            m = DetectorUtils.match(this._zgPahsinSgRegExp, curStr);
        }

        if (m.size() == 0) {
            return Optional.empty();
        }

        String curMatchedStr = m.get(0);
        boolean aThatMatched = false;

        if (curStr.trim().length() >= curMatchedStr.length() + 2 && !curMatchedStr.contains("\u1039")) {
            final String testStr = curStr.substring(curMatchedStr.length());
            final Optional<DetectorMatch> d = this.detectZg39AThatSufix(testStr);
            if (d.isPresent()) {
                curMatchedStr += d.get().getMatchedString();
                aThatMatched = true;
            }
        }

        double probability;
        if (lastEnc == DetectedEnc.zg || hasGreatProb || lastStr.length() == 0 ||
                lastEnc == DetectedEnc.none || curMatchedStr.length() == curStr.trim().length() || aThatMatched) {
            probability = this._pZgPs95;
        } else {
            probability = this._pZgPs90;
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.zg);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);

        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectZg39AThatSufix(String curStr) {
        List<String> m = DetectorUtils.match(this._zgCAndAThatRegExp, curStr);
        if (m.size() == 0) return Optional.empty();

        final String curMatchedStr = m.get(0);
        if (curStr.trim().length() > curMatchedStr.length()) {
            final String testAcStr = curStr.substring(curMatchedStr.length());
            if (this._zgAllAcAfCRegExp.matcher(testAcStr).find()) {
                return Optional.empty();
            }
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.zg);
        match.setProbability(-1);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);

        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectZgC(String curStr,
                                              DetectedEnc lastEnc,
                                              String lastStr,
                                              boolean hasGreatProb) {

        if (lastEnc != DetectedEnc.zg) {
            boolean isZgStart = false;
            final int cp = curStr.codePointAt(0);
            if (((cp >= 0x1000 && cp <= 0x1021) ||
                    (cp >= 0x1023 && cp <= 0x1027) ||
                    (cp >= 0x1029 && cp <= 0x102A) ||
                    (cp >= 0x1040 && cp <= 0x1049) ||
                    (cp >= 0x104C && cp <= 0x104F) ||
                    (cp >= 0x106A && cp <= 0x106B) ||
                    cp == 0x1086 || cp == 0x108F || cp == 0x1090)) {
                isZgStart = true;
            }
            if (!isZgStart) {
                return Optional.empty();
            }
        }

        List<String> m = DetectorUtils.match(this._zgCAndOptionalRegExp, curStr);
        if (m.size() == 0) {
            return Optional.empty();
        }

        String curMatchedStr = m.get(0);
        boolean aThatMatched = false;

        if (curStr.trim().length() >= curMatchedStr.length() + 2 && !curMatchedStr.contains("\u1039")) {
            final String testStr = curStr.substring(curMatchedStr.length());
            final Optional<DetectorMatch> d = this.detectZg39AThatSufix(testStr);
            if (d.isPresent()) {
                DetectorMatch match = d.get();
                curMatchedStr += match.getMatchedString();
                aThatMatched = true;
            }
        }

        double probability;
        final char c = curMatchedStr.charAt(0);

        if (c == '\u104E' || c == '\u106A' || c == '\u106B' || c == '\u1086' || c == '\u108F' || c == '\u1090') {
            if (lastEnc == DetectedEnc.zg || lastEnc == DetectedEnc.none || hasGreatProb ||
                    lastStr.length() == 0 || curMatchedStr.length() == curStr.trim().length()) {
                probability = this._pC95;
            } else {
                probability = this._pC85;
            }
        } else if (curMatchedStr.contains("\u1039")) {
            probability = this.getProbForZgC39AThat(curStr, lastEnc, lastStr, hasGreatProb, curMatchedStr, aThatMatched);
        } else if (curMatchedStr.contains("\u103A")) {
            probability = this.getProbForZgC3A(curStr, lastEnc, lastStr, hasGreatProb, curMatchedStr, aThatMatched);
        } else if (curMatchedStr.contains(" ") || this._spRegExp.matcher(curMatchedStr).find()) {
            probability = this._pC52;
        } else if (curMatchedStr.contains("\u103D")) {
            if (!curMatchedStr.contains("\u103C") && this._zgCNotCompatWith3dRegExp.matcher(c + "").find()) {
                probability = lastEnc == DetectedEnc.zg && hasGreatProb ? this._pC50 : this._pC20;
            } else {
                probability = lastEnc == DetectedEnc.zg && hasGreatProb ? this._pC54 : this._pC50;
            }
        } else if ((curMatchedStr.length() > 1 && this._zgOnlyCAndAcAfCRegExp.matcher(curMatchedStr).find()) ||
                (this.containsZgOnlyAcCombine(curMatchedStr))) {
            probability = lastEnc == DetectedEnc.zg && hasGreatProb ? this._pC95 : this._pC85;
        } else {
            if (lastEnc == DetectedEnc.zg && hasGreatProb) {
                probability = this._pC54;
            } else {
                probability = this._pC50;
            }
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.zg);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);

        return Optional.of(match);
    }

    private double getProbForZgC39AThat(String curStr,
                                        DetectedEnc lastEnc,
                                        String lastStr,
                                        boolean hasGreatProb,
                                        String curMatchedStr,
                                        boolean aThatMatched) {

        double probability;

        final int c39Index = curMatchedStr.indexOf("\u1039");
        final String testStr = c39Index == curMatchedStr.length() - 1 ?
                curStr.substring(curMatchedStr.length()) :
                curMatchedStr.substring(c39Index + 1);
        final String cAf39 = testStr.length() > 0 ? testStr.charAt(0) + "" : "";

        if (curMatchedStr.equals("\u1004\u103A\u1039")) {
            if (curMatchedStr.length() == curStr.trim().length() && (lastStr.length() == 0 || lastEnc == DetectedEnc.none)) {
                probability = this._pC20;
            } else {
                probability = this._pC50;
            }
        } else if ((curMatchedStr.length() == curStr.trim().length()) ||
                (cAf39.length() != 0 && !this._zgHasUniPsLoCRegExp.matcher(cAf39).find()) ||
                this._zgOnlyCAndAcAfCRegExp.matcher(curMatchedStr).find()) {

            probability = aThatMatched || lastEnc == DetectedEnc.zg || hasGreatProb ?
                    this._pC95 : this._pC85;
        } else if (curMatchedStr.contains(" ") || this._spRegExp.matcher(curMatchedStr).find()) {
            probability = this._pC52;
        } else if (!aThatMatched && (lastStr.length() == 0 || lastEnc == DetectedEnc.none)) {
            probability = this._pC20;
        } else if (lastEnc == DetectedEnc.zg && hasGreatProb) {
            probability = aThatMatched ? this._pC54 : this._pC52;
        } else {
            probability = this._pC50;
        }

        return probability;
    }

    private double getProbForZgC3A(String curStr,
                                   DetectedEnc lastEnc,
                                   String lastStr,
                                   boolean hasGreatProb,
                                   String curMatchedStr,
                                   boolean aThatMatched) {

        double probability;

        final char cBf3a = curMatchedStr.charAt(curMatchedStr.indexOf("\u103A") - 1);

        if (this._zgOnlyCAndAcAfCRegExp.matcher(curMatchedStr).find()) {
            probability = aThatMatched || lastEnc == DetectedEnc.zg || hasGreatProb ?
                    this._pC95 : this._pC85;
        } else if ((lastEnc == DetectedEnc.none || lastStr.length() == 0) &&
                curMatchedStr.length() == 2 && curMatchedStr.length() == curStr.trim().length()) {
            probability = this._pC55;
        } else if (curMatchedStr.contains(" ") || this._spRegExp.matcher(curMatchedStr).find()) {
            probability = this._pC52;
        } else if (this._zgCNotCompat3aRegExp.matcher(cBf3a + "").find()) {
            probability = this.containsZgOnlyAcCombine(curMatchedStr) ? this._pC50 : this._pC20;
        } else if (this.containsZgOnlyAcCombine(curMatchedStr)) {
            probability = hasGreatProb ? this._pC54 : this._pC52;
        } else if (lastEnc == DetectedEnc.zg && hasGreatProb) {
            probability = this._pC52;
        } else {
            probability = _pC50;
        }

        return probability;
    }

    private Optional<DetectorMatch> detectOtherChars(String curStr,
                                                     DetectedEnc lastEnc,
                                                     String lastStr,
                                                     boolean startOfNewChunk) {

        String curMatchedStr = "";
        boolean hasPunctuation = false;
        boolean hasUnDeteactableStart = false;
        int seperatorStart = -1;
        boolean prevIsNewLine = false;

        for (int i = 0; i < curStr.length(); i++) {
            final char c = curStr.charAt(i);

            if (c == ' ' || c == '\t') {
                curMatchedStr += c;
                continue;
            }

            if (c == '\n' || c == '\r') {
                prevIsNewLine = true;
                curMatchedStr += c;
                continue;
            }

            if (prevIsNewLine && !startOfNewChunk && lastEnc != DetectedEnc.none && lastStr.length() > 0 &&
                    (c == '[' || c == '(' || c == '{' || c == '#' || c == '*' || c == '\'' || c == '"' ||
                            c == 'z' || c == 'u' || c == '\u101A' || c == '\u1007' || c == '\u1031' || c == '\u104A' || c == '\u104B')) {

                final String testStr = curStr.substring(i);

                List<String> m = DetectorUtils.match(this._seperatorRegExp, testStr);
                if (m.size() != 0 && curStr.length() > m.get(0).length() && this._mixBlockTestRegExp.matcher(curStr.substring(m.get(0).length())).find()) {
                    seperatorStart = i;
                    break;
                }
            }

            final int cp = (c + "").codePointAt(0);

            if (cp == 0) {
                curMatchedStr += c;
                continue;
            }

            prevIsNewLine = false;

            if (cp == 0x104A || cp == 0x104B) {
                hasPunctuation = true;
                curMatchedStr += c;
                continue;
            }

            if ((lastEnc == null && lastStr.length() == 0) && ((cp >= 0x102B && cp <= 0x1030) ||
                    (cp >= 0x1032 && cp <= 0x1034) ||
                    (cp >= 0x1036 && cp <= 0x103A) ||
                    (cp >= 0x103C && cp <= 0x103E) ||
                    cp == 0x105A ||
                    (cp >= 0x1060 && cp <= 0x1069) ||
                    (cp >= 0x106C && cp <= 0x106D) ||
                    (cp >= 0x1070 && cp <= 0x107D) ||
                    cp == 0x1085 ||
                    (cp >= 0x1086 && cp <= 0x108E) ||
                    (cp >= 0x1093 && cp <= 0x1096))) {
                hasUnDeteactableStart = true;
                curMatchedStr += c;
                continue;
            }

            if ((cp >= 0x1000 && cp <= 0x109F) || (cp >= 0xA9E0 && cp <= 0xA9FF) || (cp >= 0xAA60 && cp <= 0xAA7F)) {
                break;
            }

            curMatchedStr += c;
        }

        if (curMatchedStr.length() == 0) {
            return Optional.empty();
        }

        double probability;

        if (lastStr.length() > 0 && lastEnc != DetectedEnc.none) {
            probability = 1;
        } else if (hasUnDeteactableStart) {
            probability = 0.05;
        } else if (hasPunctuation) {
            probability = curMatchedStr.length() == curStr.length() ? 0.5 : 0.25;
        } else {
            probability = 0;
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.none);
        match.setProbability(probability);
        match.setStart(seperatorStart);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);

        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectUni(String curStr, DetectedEnc lastEnc, String lastStr) {
        String curMatchedStr = "";
        double accProb = 0;
        boolean hasGreatProb = false;
        int seperatorStart = -1;
        boolean startOfNewChuck = true;
        boolean uniDetected = false;

        while (curStr.length() > 0) {
            Optional<DetectorMatch> d = this.detectUniKs(curStr, lastEnc, lastStr + curMatchedStr, hasGreatProb);

            if (!d.isPresent()) {
                d = this.detectUniPahsin(curStr, lastEnc, lastStr + curMatchedStr, hasGreatProb);
            }

            if (!d.isPresent()) {
                d = this.detectUniC(curStr, lastEnc, lastStr + curMatchedStr, hasGreatProb);
            }

            if (!d.isPresent()) {
                d = this.detectUniOnlyCodePoints(curStr);
            }

            if (d.isPresent()) {
                startOfNewChuck = false;
                uniDetected = true;

                if (!hasGreatProb && d.get().getProbability() >= 0.85) {
                    hasGreatProb = true;
                }
            } else {
                d = this.detectOtherChars(curStr, lastEnc, lastStr + curMatchedStr, startOfNewChuck);
                if (d.isPresent() && d.get().getStart() > -1) {
                    seperatorStart = d.get().getStart();
                }
            }

            if (!d.isPresent()) {
                break;
            }

            curMatchedStr += d.get().getMatchedString();
            lastEnc = d.get().getDetectedEnc();
            curStr = curStr.substring(d.get().getMatchedString().length());

            if (d.get().getProbability() > 0) {
                accProb = accProb == 0 ? d.get().getProbability() : (accProb + d.get().getProbability()) / 2;
            }

            if (seperatorStart > -1) {
                break;
            }
        }

        if (curMatchedStr.length() == 0) {
            return Optional.empty();
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(uniDetected || accProb >= 0.5 ? DetectedEnc.uni : DetectedEnc.none);
        match.setProbability(accProb);
        match.setStart(seperatorStart);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);
        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectUniKs(String curStr, DetectedEnc lastEnc, String lastStr, boolean hasGreatProb) {
        if (curStr.length() < 3) {
            return Optional.empty();
        }

        final char c1 = curStr.charAt(0);
        final char c2 = curStr.charAt(1);
        final char c3 = curStr.charAt(2);

        if (c1 != '\u1004' || c2 != '\u103A' || c3 != '\u1039') {
            return Optional.empty();
        }

        if (curStr.length() == 3) {
            DetectorMatch match = new DetectorMatch();
            match.setDetectedEnc(DetectedEnc.uni);
            match.setProbability(this._pUniKs60);
            match.setStart(-1);
            match.setLength(3);
            match.setMatchedString(curStr);
            return Optional.of(match);
        }

        List<String> m = Collections.emptyList();

        if (curStr.length() >= 6 && curStr.charAt(4) == '\u1039') {
            m = DetectorUtils.match(this._uniKsAndPsRegExp, curStr);
        }

        if (m.isEmpty()) {
            m = DetectorUtils.match(this._uniKsAndCRegExp, curStr);
        }

        if (m.isEmpty()) {
            return Optional.empty();
        }

        String curMatchedStr = m.get(0);

        final String test3aStr = curStr.substring(3);

        Optional<DetectorMatch> d = this.detectUniAThatWith31(test3aStr, lastEnc, lastStr + "\u1004\u103A\u1039", hasGreatProb);

        if (!d.isPresent()) {
            d = this.detectUniAThat(test3aStr, lastEnc, lastStr + "\u1004\u103A\u1039", hasGreatProb);
        }

        if (d.isPresent()) {
            curMatchedStr = "\u1004\u103A\u1039" + d.get().getMatchedString();
        }

        double probability;

        if ((lastStr.length() == 0 || lastEnc == DetectedEnc.none)) {
            probability = d.isPresent() ? this._pUniKs80 : this._pUniKs75;
        } else {
            probability = lastEnc == DetectedEnc.uni || d.isPresent() || hasGreatProb ? this._pUniKs95 : this._pUniKs85;
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.uni);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);
        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectUniAThatWith31(String curStr,
                                                         DetectedEnc lastEnc,
                                                         String lastStr,
                                                         boolean hasGreatProb) {

        if (curStr.length() < 4 || (curStr.charAt(0) == '\u1039' && curStr.length() < 6)) {
            return Optional.empty();
        }

        final int i3aStart = curStr.charAt(1) == '\u1039' ? 3 : 1;
        final int max3aLen = curStr.charAt(1) == '\u1039' ? 10 : 8;
        final int actMax3aLen = curStr.length() < max3aLen ? curStr.length() : max3aLen;

        int pos3a = -1;
        int pos31 = -1;

        for (int i = i3aStart; i < actMax3aLen; i++) {
            if (curStr.charAt(i) == '\u1031') {
                pos31 = i;
            }

            if (curStr.charAt(i) == '\u103A') {
                pos3a = i;
                break;
            }
        }

        if (pos3a < 2 || pos31 < 1) {
            return Optional.empty();
        }

        List<String> m;
        if (curStr.charAt(1) == '\u1039') {
            m = DetectorUtils.match(this._uniPs31CAThatRegExp, curStr);
            if (m.isEmpty()) {
                m = DetectorUtils.match(this._uniPs312cAThatRegExp, curStr);
            }
        } else {
            m = DetectorUtils.match(this._uniC31CAThatRegExp, curStr);
            if (m == null) {
                m = DetectorUtils.match(this._uniC312cAThatRegExp, curStr);
            }
        }

        if (m.isEmpty()) {
            return Optional.empty();
        }

        String curMatchedStr = m.get(0);

        if (curStr.trim().length() > curMatchedStr.length()) {
            final String testStr = curStr.substring(curMatchedStr.length());
            if (testStr.length() > 0 && this._uniAllAcAnd60To97RegExp.matcher(testStr).find()) {
                return Optional.empty();
            }
        }

        double probability;

        final String cBf3a = curMatchedStr.charAt(curMatchedStr.indexOf('\u103A') - 1) + "";

        if (curMatchedStr.contains("\u103F") ||
                curMatchedStr.contains("\u102B") ||
                curMatchedStr.contains("\u102C") ||
                curMatchedStr.contains("\u103E") ||
                this.isUniOnlyCodePoint(curMatchedStr.codePointAt(0))) {
            probability = this._pAThat95;
        } else if (this._zgCNotCompat3aRegExp.matcher(cBf3a).find()) {
            probability = hasGreatProb || curMatchedStr.endsWith("\u1037") || curMatchedStr.endsWith("\u1038") ?
                    this._pAThat75 : this._pAThat54;
        } else {
            probability = lastEnc == DetectedEnc.uni && lastStr.length() > 0 && hasGreatProb ? this._pAThat54 : this._pAThat50;
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.uni);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);
        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectUniPahsin(String curStr,
                                                    DetectedEnc lastEnc,
                                                    String lastStr,
                                                    boolean hasGreatProb) {

        if (curStr.length() < 3 || curStr.charAt(1) != '\u1039') {
            return Optional.empty();
        }

        boolean startsWithSgPs = false;

        if (curStr.startsWith("\u100D\u1039\u100D") ||
                curStr.startsWith("\u100D\u1039\u100E") ||
                curStr.startsWith("\u100F\u1039\u100D") ||
                curStr.startsWith("\u100B\u1039\u100C") ||
                curStr.startsWith("\u100B\u1039\u100B")) {
            startsWithSgPs = true;
        }

        if (!startsWithSgPs && (lastStr.length() == 0 || lastEnc != DetectedEnc.uni || !this._uniPsLeftEndRegExp.matcher(lastStr).find())) { // here
            return Optional.empty();
        }

        Optional<DetectorMatch> d = this.detectUniAThatWith31(curStr, lastEnc, lastStr, hasGreatProb);
        if (!d.isPresent()) {
            d = this.detectUniAThat(curStr, lastEnc, lastStr, hasGreatProb);
        }

        String curMatchedStr;

        if (d.isPresent()) {
            curMatchedStr = d.get().getMatchedString();
        } else {
            List<String> m = DetectorUtils.match(this._uniPsRegExp, curStr);

            if (m.isEmpty()) {
                return Optional.empty();
            }

            curMatchedStr = m.get(0);
        }

        double probability;

        if (startsWithSgPs ||
                curMatchedStr.contains("\u100D\u1039\u100D") ||
                curMatchedStr.contains("\u100D\u1039\u100E") ||
                curMatchedStr.contains("\u100F\u1039\u100D") ||
                curMatchedStr.contains("\u100B\u1039\u100C") ||
                curMatchedStr.contains("\u100B\u1039\u100B")) {
            probability = this._pUniPs95;
        } else if (this.isInUniPahsin(curStr, lastStr)) {
            probability = this._pUniPs60;
        } else if (d.isPresent()) {
            if (curMatchedStr.contains("\u1031") && (curMatchedStr.contains("\u102B") || curMatchedStr.contains("\u102C"))) {
                probability = this._pAThat95;
            } else {
                probability = lastEnc == DetectedEnc.uni && hasGreatProb ? this._pUniPs95 : this._pUniPs50;
            }
        } else {
            probability = lastEnc == DetectedEnc.uni && hasGreatProb ? this._pUniPs95 : this._pUniPs50;
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.uni);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);
        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectUniAThat(String curStr,
                                                   DetectedEnc lastEnc,
                                                   String lastStr,
                                                   boolean hasGreatProb) {

        if (curStr.length() < 3 || (curStr.charAt(1) == '\u1039' && curStr.length() < 5)) {
            return Optional.empty();
        }

        final int i3aStart = curStr.charAt(1) == '\u1039' ? 4 : 2;
        final int max3aLen = curStr.charAt(1) == '\u1039' ? 11 : 9;
        final int actMax3aLen = curStr.length() < max3aLen ? curStr.length() : max3aLen;

        int pos3a = -1;

        for (int i = i3aStart; i < actMax3aLen; i++) {
            if (curStr.charAt(i) == '\u103A') {
                pos3a = i;
                break;
            }
        }

        if (pos3a < 2) {
            return Optional.empty();
        }

        List<String> m = curStr.charAt(1) == '\u1039' ? DetectorUtils.match(this._uniPsC2AThatRegExp, curStr) : DetectorUtils.match(this._uniC1C2AThatRegExp, curStr);

        if (m.isEmpty()) {
            return Optional.empty();
        }

        String curMatchedStr = m.get(0);

        if (curStr.trim().length() > curMatchedStr.length()) {
            final String testStr = curStr.substring(curMatchedStr.length());
            if (testStr.length() > 0 && this._uniAllAcAnd60To97RegExp.matcher(testStr).find()) {
                boolean hasM2 = false;
                if (curMatchedStr.endsWith("\u103A")) {
                    final String p1 = curMatchedStr.charAt(curMatchedStr.length() - 2) + "";
                    final String p2 = curStr.substring(curMatchedStr.length());
                    final String testStr2 = p1 + p2;
                    final List<String> m2 = DetectorUtils.match(this._uniC1C2AThatRegExp, testStr2);
                    if (!m2.isEmpty()) {
                        curMatchedStr += m2.get(0).substring(2);
                        hasM2 = true;
                    }
                }

                if (!hasM2) {
                    return Optional.empty();
                }
            }
        }

        double probability;

        final String cBf3a = curMatchedStr.charAt(curMatchedStr.indexOf("\u103A") - 1) + "";

        if (curMatchedStr.charAt(0) == '\u104E' ||
                curMatchedStr.charAt(0) == '\u103F' ||
                curMatchedStr.contains("\u103E") ||
                this.isUniOnlyCodePoint(curMatchedStr.codePointAt(0)) ||
                (curMatchedStr.contains("\u103B") && this._uniOnlyAcAf3bRegExp.matcher(curMatchedStr.substring(curMatchedStr.indexOf("\u103B") + 1)).find()) ||
                this.isUniOnlyCodePoint(curMatchedStr.codePointAt(0))) {
            probability = this._pAThat95;
        } else if (this._zgCNotCompat3aRegExp.matcher(cBf3a).find()) {
            probability = hasGreatProb || curMatchedStr.endsWith("\u1037") || curMatchedStr.endsWith("\u1038") ?
                    this._pAThat75 : this._pAThat54;
        } else {
            probability = lastEnc == DetectedEnc.uni && lastStr.length() != 0 && hasGreatProb ? this._pAThat54 : this._pAThat50;
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.uni);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);
        return Optional.of(match);
    }

    private boolean isUniOnlyCodePoint(int cp) {
        if (cp == 0x1022 || cp == 0x1028 || cp == 0x1035 || cp == 0x103E || cp == 0x103F ||
                (cp >= 0x1050 && cp <= 0x1059) || (cp >= 0x105B && cp <= 0x105F) || (cp >= 0x1098 && cp <= 0x109F) ||
                (cp >= 0xA9E0 && cp <= 0xA9FF) || (cp >= 0xAA60 && cp <= 0xAA7F)) {
            return true;
        }

        return false;
    }

    private boolean isInUniPahsin(String curStr, String lastStr) {
        boolean found = false;

        if ((lastStr + curStr).equals("\u1015\u1010\u1039\u1010\u102c")) {
            return true;
        }

        if ((lastStr + curStr).equals("\u1015\u1010\u1039\u1010\u102c\u1001\u1036")) {
            return true;
        }

        if ((lastStr + curStr).equals("\u1019\u102d\u1010\u1039\u1010\u1030")) {
            return true;
        }

        for (String[] pair : uniPahsinWords) {
            final String leftStr = pair[0];
            final String rightStr = pair[1];

            if (curStr.length() < rightStr.length()) {
                continue;
            }

            if (leftStr.length() > 0 && lastStr.length() < leftStr.length()) {
                continue;
            }

            if (!curStr.startsWith(rightStr)) {
                continue;
            }

            if (leftStr.length() > 0 && !lastStr.endsWith(leftStr)) {
                continue;
            }

            found = true;
        }

        return found;
    }

    private Optional<DetectorMatch> detectUniC(String curStr,
                                               DetectedEnc lastEnc,
                                               String lastStr,
                                               boolean hasGreatProb) {
        if (lastEnc != DetectedEnc.uni) {
            boolean isUniStart = false;
            final int cp = curStr.codePointAt(0);
            if (((cp >= 0x1000 && cp <= 0x102A) ||
                    cp == 0x103F ||
                    (cp >= 0x1040 && cp <= 0x1049) ||
                    (cp >= 0x104C && cp <= 0x104F))) {

                isUniStart = true;
            }
            if (!isUniStart) {
                return Optional.empty();
            }
        }

        final char c = curStr.charAt(0);

        if (c == '\u104C' || c == '\u104D' || c == '\u104F') {
            DetectorMatch match = new DetectorMatch();
            match.setDetectedEnc(DetectedEnc.uni);
            match.setProbability(lastEnc == DetectedEnc.uni && hasGreatProb ? this._pC54 : this._pC50);
            match.setStart(-1);
            match.setLength(1);
            match.setMatchedString(c + "");
        }

        List<String> m = DetectorUtils.match(this._uniCAndOptionalRegExp, curStr);
        if (m.isEmpty()) {
            return Optional.empty();
        }

        Optional<DetectorMatch> d = this.detectUniAThatWith31(curStr, lastEnc, lastStr, hasGreatProb);
        if (!d.isPresent()) {
            d = this.detectUniAThat(curStr, lastEnc, lastStr, hasGreatProb);
        }
        if (!d.isPresent()) {
            d = this.detectUniKsAThat(curStr, lastEnc, lastStr, hasGreatProb);
        }

        if (d.isPresent()) {
            return d;
        }

        final String curMatchedStr = m.get(0);
        double probability;

        if (this.isUniOnlyCodePoint(curMatchedStr.codePointAt(0))) {
            probability = this._pUniCMax;
        } else if (curMatchedStr.contains("\u1031") &&
                curMatchedStr.indexOf("\u1031") + 1 < curMatchedStr.length() &&
                this._uniOnlyAcAf31RegExp.matcher(curMatchedStr.substring(curMatchedStr.indexOf("\u1031") + 1)).find()) {
            probability = this._pUniCMax;
        } else if (curMatchedStr.contains("\u103B") &&
                curMatchedStr.indexOf("\u103B") + 1 < curMatchedStr.length() &&
                this._uniOnlyAcAf3bRegExp.matcher(curMatchedStr.substring(curMatchedStr.indexOf("\u103B") + 1)).find()) {
            probability = this._pUniCMax;
        } else if (curMatchedStr.contains("\u103A")) {
            probability = lastStr.length() == 0 || lastEnc == DetectedEnc.none || !this._uniC1CompatWithAThat.matcher(lastStr).find() ? this._pC20 : this._pC50;
        } else {
            if (curStr.length() > 1) {
                final String testStr = curStr.substring(curMatchedStr.length());
                if (testStr.length() > 0 && this._uniAllAcAnd60To97RegExp.matcher(testStr).find()) {
                    return Optional.empty();
                }
            }

            if ((lastStr.length() == 0 || lastEnc == DetectedEnc.none) &&
                    curMatchedStr.length() == curStr.trim().length() &&
                    (curMatchedStr.contains("\u1031") || curMatchedStr.contains("\u103B"))) {
                probability = this._pC95;
            } else if (curMatchedStr.length() == curStr.trim().length() &&
                    (curMatchedStr.contains("\u1031") || curMatchedStr.contains("\u103B"))) {
                probability = hasGreatProb ? this._pC95 : this._pC85;
            } else if (curMatchedStr.length() == 2 && curMatchedStr.endsWith("\u103A")) {
                if (lastStr.length() == 0 || lastEnc != DetectedEnc.uni || !this._uniCAThatCompatRegExp.matcher(curMatchedStr).find()) {
                    probability = this._pC20;
                } else {
                    probability = this._pC50;
                }
            } else {
                if (lastEnc == DetectedEnc.uni && hasGreatProb) {
                    probability = this._pC54;
                } else {
                    probability = this._pC50;
                }
            }
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.uni);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);
        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectUniOnlyCodePoints(String curStr) {
        String curMatchedStr = "";

        for (char ch : curStr.toCharArray()) {
            String c = ch + "";
            final int cp = c.codePointAt(0);
            if (this.isUniOnlyCodePoint(cp)) {
                curMatchedStr += c;
            } else {
                break;
            }
        }

        if (curMatchedStr.length() == 0) {
            return Optional.empty();
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.uni);
        match.setProbability(1);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);
        return Optional.of(match);
    }

    private Optional<DetectorMatch> detectUniKsAThat(String curStr,
                                                     DetectedEnc lastEnc,
                                                     String lastStr,
                                                     boolean hasGreatProb) {

        if (curStr.length() < 3 || lastStr.length() == 0 || lastEnc == DetectedEnc.none) {
            return Optional.empty();
        }

        int pos3a = -1;

        for (int i = 1; i < 3; i++) {
            if (curStr.charAt(i) == '\u103A') {
                pos3a = i;
                break;
            }
        }

        if (pos3a < 1) {
            return Optional.empty();
        }

        List<String> m = DetectorUtils.match(this._uniCKsAThatRegExp, curStr);

        if (m == null) {
            return Optional.empty();
        }

        if (!this._uniLastCCompatWithKsAThat.matcher(lastStr).find()) {
            return Optional.empty();
        }

        final String curMatchedStr = m.get(0);

        if (curStr.trim().length() > curMatchedStr.length()) {
            final String testStr = curStr.substring(curMatchedStr.length());
            if (testStr.length() > 0 && this._uniAllAcAnd60To97RegExp.matcher(testStr).find()) {
                return Optional.empty();
            }
        }

        double probability;

        final char cBf3a = curMatchedStr.charAt(curMatchedStr.indexOf("\u103A") - 1);

        if (curMatchedStr.charAt(0) == '\u103F' ||
                curMatchedStr.contains("\u103B\u102C") ||
                curMatchedStr.contains("\u103B\u103A") ||
                this.isUniOnlyCodePoint(curMatchedStr.codePointAt(0))) {
            probability = this._pAThat95;
        } else if (this._zgCNotCompat3aRegExp.matcher(cBf3a + "").find()) {
            probability = hasGreatProb || curMatchedStr.endsWith("\u1037") || curMatchedStr.endsWith("\u1038") ? this._pAThat75 : this._pAThat54;
        } else {
            probability = lastEnc == DetectedEnc.uni && lastStr.length() > 0 && hasGreatProb ? this._pAThat54 : this._pAThat50;
        }

        DetectorMatch match = new DetectorMatch();
        match.setDetectedEnc(DetectedEnc.uni);
        match.setProbability(probability);
        match.setStart(-1);
        match.setLength(curMatchedStr.length());
        match.setMatchedString(curMatchedStr);
        return Optional.of(match);
    }
}
