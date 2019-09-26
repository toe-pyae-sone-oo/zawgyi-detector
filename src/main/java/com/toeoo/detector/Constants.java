package com.toeoo.detector;

public class Constants {
    public static final String rCForAThat = "\u1000-\u1002\u1004\u1005\u1007\u1009\u100A\u100B\u100C\u100F\u1010\u1012\u1014-\u101F\u1020\u1025";

    // Zg
    public static final String rSp = " \u00A0\u1680\u2000-\u200D\u202F\u205F\u2060\u3000\uFEFF";
    public static final String rZg3b = "\u103B\u107E-\u1084";
    public static final String rZgUpC = "\u1000-\u1021\u1023-\u1027\u1029\u102A\u1040-\u1049\u104C-\u104F\u106A\u106B\u1086\u108F\u1090";
    public static final String rZgPsLoC = "\u1060-\u1063\u1065-\u1069\u106C\u106D\u1070-\u107C\u1085\u1093\u1096";
    public static final String rZgPsSgC = "\u106E\u106F\u1091\u1092\u1097";
    public static final String rZgAcAfC = "\u102B-\u1030\u1032-\u1034\u1036-\u103A\u103C\u103D\u105A\u107D\u1087-\u108A\u108E\u1094\u1095";
    public static final String rZgAcKsAfC = "\u1064\u108B-\u108E";
    public static final String rZgC1For3a = "\u1000-\u1021\u1023\u1025\u1027\u1040\u1044\u106A\u106B\u1086\u108F\u1090";
    public static final String rZgOnlyCAndAcAfC = rZgAcKsAfC + "\u1033\u1034\u105A\u106A\u106B\u107D\u1086-\u108A\u108F\u1090\u1094\u1095";

    public static final String rZgPsDbG = "[" + rZgUpC + "]([" + rSp + "]*[" + rZgAcAfC + rZgAcKsAfC + "])*[" + rSp + "]*[" + rZgPsLoC + "]";

    public static final String rZgCAndOpG = "[" + rZgUpC + "]([" + rSp + "]*[" + rZgAcAfC + rZgAcKsAfC + "])*";
    public static final String rZgPsSgAndOpG = "[" + rZgPsSgC + "]([" + rSp + "]*[" + rZgAcAfC + rZgAcKsAfC + "])*";
    public static final String rZgPsDbAndOpG = rZgPsDbG + "([" + rSp + "]*[" + rZgAcAfC + rZgAcKsAfC + "])*";
    public static final String rZgCAndAThatG = "[" + rCForAThat + "](\u1039\u103A\u102C\u1038|\u1039\u1038|\u1039\u1037|\u1037\u1039|\u1039)";


    // Uni
    public static final String rUniC = "\u1000-\u102A\u103F\u1040-\u1049\u104E";
    public static final String rUniPsUpC = "\u1000-\u102A\u103F\u1040-\u1049";
    public static final String rUniPsLoC = "\u1000-\u101C\u101E-\u1022\u1027\u103F";
    public static final String rUniC1BfAThat = "\u1000-\u1023\u1025\u1027\u1029\u103F\u1040\u1044\u104E";

    public static final String rUniAcAf31G = "[\u102D\u102E]?[\u102F\u1030]?[\u102B\u102C]?\u103A?[\u1032\u1036]?[\u102B\u102C]?\u103A?\u1037?[\u102B\u102C]?\u103A?\u1038?";


    // AThat suffix
    public static final String rUni312cAThatSuffixG = "[\u103B\u103C]?\u103E?\u1031[\u102B\u102C](\u1037\u103A|\u103A[\u1037\u1038]?)";
    public static final String rUniC31CAThatSuffixG = "[\u103B\u103C]?\u103E?\u1031[\u102B\u102C]?[" + rCForAThat + "](\u1037\u103A|\u103A[\u1037\u1038]?)";
    public static final String rUniC1C2AThatSuffixG = "[\u103B\u103C]?(\u103D\u103E|[\u103D\u103E])?[\u102D\u102E]?[\u102F\u1030]?[\u102B\u102C]?[" + rCForAThat + "](\u1037\u103A|\u103A[\u1037\u1038]?)";

    public static final String rUniKsAThatSuffixG = "(\u103A[\u103B\u103C]|[\u103B\u103C]\u103A)[\u102B\u102C][\u1037\u1038]?";
}
