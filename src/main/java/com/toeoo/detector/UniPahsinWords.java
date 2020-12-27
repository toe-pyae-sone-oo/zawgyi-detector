package com.toeoo.detector;

public class UniPahsinWords {

    private static final String[][] uniPahsinWords = {
        {"", "\u100B\u1039\u100C\u102C\u1017\u1039\u1017\u102C"},
        {"\u1000", "\u1000\u1039\u1000\u101B"},
        {"\u1000", "\u1000\u1039\u1000\u102F\u1000\u1019\u103B\u1009\u103A\u1038"},
        {"\u1000", "\u1000\u1039\u1000\u102F\u1006\u1030\u1038"},
        {"\u1000", "\u1005\u1039\u1005\u100A\u103A\u1038"},
        {
            "\u1007\u1031",
            "\u100B\u1039\u100C"
        },
        {
            "\u1013\u102D",
            "\u100B\u1039\u100C\u102C\u1014\u103A"
        },
        {
            "\u1001\u102D",
            "\u100D\u1039\u100D\u102C"
        },
        {
            "\u1002\u102F\u100F\u101D\u102F",
            "\u100D\u1039\u100E\u102D"
        },
        {
            "\u101D\u101A\u101D\u102F",
            "\u100D\u1039\u100E\u102D"
        },
        {"\u1000", "\u100F\u1039\u100B"},
        {"\u1000", "\u100F\u1039\u100C"}, {"\u1000", "\u100F\u1039\u100D"},
        {"\u1000", "\u100F\u1039\u100F"}, {"\u1000", "\u1010\u1039\u1010\u101B"},
        {"\u1000", "\u1010\u1039\u1010\u101D\u102B"}, {"\u1000", "\u1010\u1039\u1010\u102C\u1038"},
        {"\u1000", "\u1010\u1039\u1010\u102E\u1015\u102B"},
        // {
        // "\u1000",
        // "\u1010\u1039\u1010\u1030"
        // },
        {"\u1000", "\u1015\u1039\u1015\u100B\u1039\u100C\u102E"},
        {"\u1000", "\u1015\u1039\u1015\u102D"}, {"\u1000", "\u1019\u1039\u1015\u100A\u103A\u1038"},
        {"\u1000", "\u1019\u1039\u1015\u1010\u103A"},
        {"\u1000", "\u1019\u1039\u1015\u101C\u103D\u1031"},
        {"\u1000", "\u1019\u1039\u1017\u101C\u102C"}, {"\u1000", "\u1019\u1039\u1018\u102C"},
        {"\u1000", "\u1019\u1039\u1019\u1007"},
        {"\u1000", "\u1019\u1039\u1019\u100B\u1039\u100C\u102C\u1014\u103A\u1038"},
        {"\u1000", "\u1019\u1039\u1019\u101D\u102B"},
        {"\u1000", "\u1019\u1039\u1019\u101E\u1000\u102C"},
        // {
        // "\u1001",
        // "\u1010\u1039\u1010\u102C"
        // },
        {"\u1001", "\u1014\u1039\u1010\u102E"}, {"\u1001", "\u1014\u1039\u1013\u102C"},
        {"\u1002", "\u1014\u1039\u1011\u101B"}, {"\u1002", "\u1014\u1039\u1011\u101D\u1004\u103A"},
        {"\u1002", "\u1014\u1039\u1013\u1017\u1039\u1017"},
        {"\u1002", "\u1014\u1039\u1013\u1019\u102C"}, {"\u1002", "\u1014\u1039\u1013\u102C"},
        {"\u1005", "\u1000\u1039\u1000\u1014\u1037\u103A"},
        {"\u1005", "\u1000\u1039\u1000\u101D\u102B\u1000\u103A"},
        {"\u1005", "\u1000\u1039\u1000\u1030"}, {"\u1005", "\u100F\u1039\u100D\u102C\u101C"},
        {"\u1005", "\u100F\u1039\u100D\u102E"},
        {"\u1005", "\u1014\u1039\u1012\u1000\u102F\u1019\u102C"},
        {"\u1005", "\u1014\u1039\u1012\u1000\u1030\u1038"},
        {"\u1005", "\u1014\u1039\u1012\u101B\u102C\u1038"}, {"\u1005", "\u1014\u1039\u1012\u102C"},
        {"\u1005", "\u1014\u1039\u1012\u103C"}, {"\u1005", "\u1019\u1039\u1015\u102C"},
        {"\u1005", "\u1019\u1039\u1019\u1001\u100F\u103A"},
        {"\u1005", "\u1019\u1039\u1019\u1001\u1014\u103A\u1038"},
        // {
        // "\u1006",
        // "\u1010\u1039\u1010\u102C"
        // },
        {"\u1006", "\u1012\u1039\u1012\u1014\u103A"}, {"\u1007", "\u1019\u1039\u1017\u102F"},
        {"\u1007", "\u1019\u1039\u1017\u1030"},
        {"\u1010", "\u1000\u1039\u1000\u1010\u103D\u1014\u103A\u1038"},
        {"\u1010", "\u1000\u1039\u1000\u101E\u102D\u102F\u101C\u103A"},
        {"\u1010", "\u1005\u1039\u1006\u1031"},
        {"\u1010", "\u1019\u1039\u1015\u1012\u102D\u1015\u103A"},
        {"\u1012", "\u1000\u1039\u1001\u102D\u100F"},
        {"\u1012", "\u100F\u1039\u100D\u102C\u101B\u102E"},
        {"\u1012", "\u1014\u1039\u1010\u1005\u102D\u102F\u1014\u102C"},
        {"\u1013", "\u1019\u1039\u1019"}, {"\u1019", "\u1014\u1039\u1010\u101B\u102C\u101A\u103A"},
        {"\u1014", "\u1000\u1039\u1001\u1010\u103A"}, {"\u1014", "\u1014\u1039\u1012"},
        {"\u1015", "\u1000\u1039\u1000\u101C\u102C"},
        {"\u1015", "\u1005\u1039\u1005\u1000\u1039\u1001"},
        {"\u1015", "\u1005\u1039\u1005\u1004\u103A"},
        {"\u1015", "\u1005\u1039\u1005\u100A\u103A\u1038"},
        {"\u1015", "\u1005\u1039\u1005\u1014\u1039\u1010\u101B\u1005\u103A"},
        {"\u1015", "\u1005\u1039\u1005\u101A"},
        {"\u1015", "\u1005\u1039\u1005\u102F\u1012\u1039\u1013\u1031\u101B"},
        {"\u1015", "\u1005\u1039\u1005\u102F\u1015\u1039\u1015\u1014\u103A"},
        {"\u1015", "\u1005\u1039\u1005\u1031\u1000"},
        {"\u1015", "\u1007\u1039\u1007\u102F\u1014\u103A"},
        {"\u1015", "\u1009\u1039\u1005\u1004\u103A"}, {"\u1015", "\u1009\u1039\u1005"},
        {"\u1015", "\u100B\u1039\u100C\u102C\u1014\u103A\u1038"},
        {"\u1015", "\u100F\u1039\u100D\u102D\u1010\u103A"}, {"\u1015", "\u100F\u1039\u100D\u102F"},
        {"\u1015", "\u100F\u1039\u100F\u102C"},
        {"\u1015", "\u1010\u1039\u1010\u1000\u103B\u100A\u103A"},
        {"\u1015", "\u1010\u1039\u1010\u1015\u102D\u102F\u100F\u103A"},
        {"\u1015", "\u1010\u1039\u1010\u1019\u103C\u102C\u1038"},
        {"\u1015", "\u1010\u1039\u1010\u101C\u102C\u1038"},
        // {
        // "\u1015",
        // "\u1010\u1039\u1010\u102C"
        // },
        {"\u1015", "\u1010\u1039\u1010\u1030\u1005"}, {"\u1015", "\u1010\u1039\u1011\u1014\u102C"},
        {"\u1015", "\u1014\u1039\u1014\u1000\u103A"}, {"\u1015", "\u101C\u1039\u101C\u1004\u103A"},
        {"\u1016", "\u1002\u1039\u1002\u102F\u1014\u102E"},
        {"\u1017", "\u1014\u1039\u1013\u1010\u103A"},
        {"\u1002", "\u1014\u1039\u1012\u102D\u102F\u101C\u103A"},
        {"\u1018", "\u100F\u1039\u100D\u102C"}, {"\u1018", "\u1012\u1039\u1012"},
        {"\u1019", "\u1002\u1039\u1002\u1004\u103A"},
        {"\u1019", "\u1002\u1039\u1002\u1007\u1004\u103A\u1038"},
        {"\u1019", "\u1005\u1039\u1006\u1017\u1031\u1012"},
        {"\u1019", "\u1005\u1039\u1006\u101B\u102D\u101A"},
        {"\u1019", "\u1005\u1039\u1006\u1031\u101B"}, {"\u1019", "\u1007\u1039\u1008\u102D\u1019"},
        {"\u1019", "\u1007\u1039\u1008\u1031"}, {"\u1019", "\u1009\u1039\u1005\u1030"},
        {"\u1019", "\u100F\u1039\u100D\u1015\u103A"},
        {"\u1019", "\u100F\u1039\u100D\u102D\u102F\u1004\u103A"},
        {"\u1019", "\u1014\u1039\u1010\u1014\u103A"},
        {"\u1019", "\u1014\u1039\u1010\u101B\u102C\u1038"},
        {"\u1019", "\u1014\u1039\u1010\u101C\u1031\u1038"},
        {"\u1019", "\u1014\u1039\u1013\u102C\u1010\u103A"},
        {"\u1019", "\u101C\u1039\u101C\u102D\u1000\u102C"},
        {"\u101A", "\u1014\u1039\u1010\u101B\u102C\u1038"},
        {"\u101B", "\u1010\u1039\u1010\u1015\u102D\u1010\u103A"},
        {"\u101B", "\u1019\u1039\u1019\u1000\u103A"}, {"\u101C", "\u1000\u1039\u1001\u100F\u102C"},
        {"\u101C", "\u1010\u1039\u1010\u102E\u1010\u103D\u1012\u103A"},
        {"\u101C", "\u1010\u1039\u1010\u1036"}, {"\u101C", "\u1019\u1039\u1015\u102C\u101A\u103A"},
        {"\u101D", "\u1002\u1039\u1002\u1014\u1039\u1010"},
        {"\u101D", "\u1005\u1039\u1005\u1015\u1031\u102B\u1000\u103A"},
        {"\u101D", "\u1010\u1039\u1010\u101B\u102C\u1038"}, {"\u101D", "\u1010\u1039\u1011\u102F"},
        {"\u101E", "\u1000\u1039\u1000\u1010"},
        {"\u101E", "\u1000\u1039\u1000\u1012\u102B\u1014\u103A"},
        {"\u101E", "\u1000\u1039\u1000\u101B\u102C\u1007\u103A"},
        {"\u101E", "\u1000\u1039\u1000\u102C\u101B"},
        {"\u101E", "\u1005\u1039\u1005\u1015\u1014\u103A\u1038"},
        {"\u101E", "\u1009\u1039\u1005\u102C"}, {"\u101E", "\u100F\u1039\u100C\u102C\u1014\u103A"},
        // {
        // "\u101E",
        // "\u1010\u1039\u1010"
        // },
        {"\u101E", "\u1010\u1039\u1011\u1014\u1039\u1010\u101B"}, {"\u101E", "\u1012\u1039\u1012"},
        {"\u101E", "\u1012\u1039\u1013\u102B"}, {"\u101E", "\u1014\u1039\u1010\u102C"},
        {"\u101E", "\u1014\u1039\u1013\u1031"}, {"\u101E", "\u1014\u1039\u1014\u102D"},
        {"\u101E", "\u1015\u1039\u1015\u102C\u101A"}, {"\u101E", "\u1017\u1039\u1017"},
        {"\u101E", "\u1019\u1039\u1015\u1007\u1009\u103A"},
        {"\u101E", "\u1019\u1039\u1017\u1014\u1039\u1013"},
        {"\u101E", "\u1019\u1039\u1017\u1014\u103A"}, {"\u101E", "\u1019\u1039\u1018\u102C"},
        {"\u101E", "\u1019\u1039\u1019\u1010"}, {"\u101E", "\u1019\u1039\u1019\u1014\u103A"},
        {"\u101E", "\u1019\u1039\u1019\u102C\u1012\u1031\u101D"},
        {"\u1029", "\u1010\u1039\u1010\u1015\u1039\u1015"},
        {"\u1021", "\u1000\u1039\u1000\u1015\u1010\u103A"},
        {"\u1021", "\u1000\u1039\u1001\u101B\u102C"},
        {"\u1021", "\u1000\u1039\u1001\u1031\u102C\u1018\u102D\u100F\u102E"},
        {"\u1021", "\u1002\u1039\u1002\u102D\u101B\u1010\u103A"},
        {"\u1021", "\u1010\u1039\u1010\u1014\u1031\u102C"},
        {"\u1021", "\u1010\u1039\u1010\u101F\u102D"}, {"\u1021", "\u1010\u1039\u1011\u102D"},
        {"\u1021", "\u1010\u1039\u1011\u102F\u1015\u1039\u1015\u1010\u1039\u1010\u102D"},
        {"\u1021", "\u1014\u1039\u1010\u101B"},
        {"\u1021", "\u1014\u1039\u1010\u102C\u1015\u102D\u1010\u103A"},
        {"\u1021", "\u1014\u1039\u1010\u1031\u101D\u102B\u101E\u102D"},
        {"\u1021", "\u1014\u1039\u1010\u1031\u102C"}, {"\u1021", "\u1014\u1039\u1012\u1002\u1030"},
        {"\u1021", "\u1014\u1039\u1013"}, {"\u1021", "\u1017\u1039\u1018\u1014\u1039\u1010\u101B"},
        {"\u1018", "\u1014\u1039\u1010\u1031"}, {"\u101D", "\u1014\u1039\u1010\u1036"},
        {"\u1023", "\u1005\u1039\u1006\u102C"},
        {"\u1023", "\u100B\u1039\u100C\u102C\u101B\u102F\u1036"},
        {"\u1023", "\u1010\u1039\u1010\u102D\u101C\u102D\u1004\u103A"},
        {"\u1023", "\u1010\u1039\u1011\u102D"},
        {"\u1023", "\u1012\u1039\u1019\u102D\u1015\u102B\u1012\u103A"},
        {"\u1023", "\u1014\u1039\u1012"},
        {"\u1025", "\u1000\u1039\u1000\u100B\u1039\u100C"},
        {"\u1025", "\u1000\u1039\u1000\u102C"}, {"\u1025", "\u1000\u1039\u1000\u1031\u102C"},
        {"\u1025", "\u1005\u1039\u1005\u102C"}, {"\u1025", "\u100F\u1039\u100F"},
        {"\u1025", "\u1010\u1039\u1010\u101B"}, {"\u1025", "\u1015\u1039\u1015\u102C\u1010\u103A"},
        {"\u1025", "\u1019\u1039\u1019\u1010\u1039\u1010\u1000"},
        {"\u1019", "\u1014\u1039\u1010\u1000"}, {"\u1019", "\u1010\u1039\u1010\u100F\u103A"},
        {"\u1000\u1014", "\u1000\u1039\u1000"}, {"\u1007\u102D", "\u1012\u1039\u1013\u102D"},
        {"\u101A\u102D", "\u1014\u1039\u1012\u103C\u1031"}, {"\u1000\u102D", "\u1005\u1039\u1005"},
        {"\u1000\u102D", "\u1010\u1039\u1010\u102D\u1019"},
        {"\u1000\u102D", "\u1014\u1039\u1014\u101B"},
        {"\u1000\u102F", "\u1000\u1039\u1000\u101C\u1036"},
        {"\u1000\u102F", "\u1000\u1039\u1000\u102C\u1038"},
        {"\u1000\u102F", "\u1000\u1039\u1000\u102D\u102F"},
        {"\u1000\u102F", "\u1000\u1039\u1000\u102F\u1005\u1039\u1005"},
        {"\u1000\u102F", "\u1017\u1039\u1018\u102E\u1038"},
        {"\u1000\u102F", "\u1019\u1039\u1015\u100F\u102E"},
        {"\u1000\u102F", "\u1019\u1039\u1018\u100F\u103A"},
        {"\u1000\u102F", "\u1019\u1039\u1019\u102C\u101B\u102E"},
        {"\u1000\u103C", "\u1010\u1039\u1010\u102D\u1000\u102C"},
        {"\u1000\u103C", "\u1019\u1039\u1019\u102C"},
        {"\u1000\u103D", "\u1000\u1039\u1000\u101B\u102C"}, {"\u1001\u1031", "\u1010\u1039\u1010"},
        {"\u1002\u102D", "\u1007\u1039\u1008\u1000\u102F\u100B\u103A"},
        {"\u1002\u102F", "\u1014\u1039\u1010\u1014\u103A"},
        {"\u1005\u102D", "\u1010\u1039\u1010\u1007"},
        {"\u1005\u102D", "\u1010\u1039\u1010\u102F\u1015\u1039\u1015\u102C\u1012\u103A"},
        {"\u1005\u102D", "\u1014\u1039\u1010\u102C\u1019\u100F\u102D"},
        {"\u1005\u102D", "\u1014\u1039\u1014\u1018\u1031\u102C\u103A"},
        {"\u1007\u101C", "\u1010\u1039\u1010\u102C"},
        {"\u1010\u1004", "\u103A\u1039\u1001\u100F\u102F\u1015\u1039\u1015\u1010\u1039\u1010\u102D"},
        {"\u1010\u102D", "\u1000\u1039\u1000\u1019"}, {"\u1010\u102D", "\u1010\u1039\u1011\u102D"},
        {"\u1010\u102D", "\u1010\u1039\u1011\u102F\u1036"},
        {"\u1012\u102D", "\u1014\u1039\u1014\u1000\u103A\u101E\u1032"},
        {"\u1012\u102F", "\u1000\u1039\u1000\u101B"}, {"\u1012\u102F", "\u1000\u1039\u1001"},
        {"\u1012\u102F", "\u1010\u1039\u1011\u102C"}, {"\u1012\u102F", "\u101C\u1039\u101C\u1018"},
        {"\u1014\u102D", "\u1002\u1039\u1002\u101F\u102D\u1010\u103A"},
        {"\u1014\u102D", "\u1005\u1039\u1005"},
        {"\u1014\u102D", "\u100B\u1039\u100C\u102D\u1010\u1036"},
        {"\u1014\u102D", "\u1017\u1039\u1017\u102C\u1014\u103A"},
        {"\u1014\u102D", "\u1017\u1039\u1017\u102D\u1014\u1039\u1012"},
        {"\u1014\u102D", "\u1019\u1039\u1019\u102D\u1010"},
        {"\u1015\u101B", "\u1014\u1039\u1014\u101D\u102B"},
        {"\u1015\u101D", "\u1010\u1039\u1010\u102D"},
        {"\u1015\u102D", "\u100F\u1039\u100D\u1015\u102B\u1010\u103A"},
        {"\u1015\u102D", "\u1014\u1039\u1014\u1032"}, {"\u1015\u102F", "\u1002\u1039\u1002\u101C"},
        {"\u1015\u102F", "\u1002\u1039\u1002\u102D\u102F\u101C\u103A"},
        {"\u1015\u102F", "\u1005\u1039\u1006\u1014\u103A\u1038"},
        {"\u1015\u102F", "\u1005\u1039\u1006\u102C"},
        {"\u1015\u102F", "\u100F\u1039\u100D\u101B\u102D\u1000\u103A"},
        {"\u1015\u102F", "\u100F\u1039\u100F\u1000"},
        {"\u1015\u102F", "\u100F\u1039\u100F\u102C\u1038"},
        {"\u1015\u102F", "\u100F\u1039\u100F\u1031\u1038\u1019"},
        {"\u1015\u102F", "\u1014\u1039\u1014\u1016\u102F"}, {"\u1015\u102F", "\u1017\u1039\u1017"},
        {"\u1015\u102F", "\u101C\u1039\u101C\u102D\u1004\u103A"},
        {"\u1015\u103C", "\u1000\u1039\u1001\u1012\u102D\u1014\u103A"},
        {"\u1015\u103C", "\u100B\u1039\u100C\u102C\u1014\u103A\u1038"},
        {"\u1017\u101C", "\u1000\u1039\u1000\u102C\u101B"},
        {"\u1017\u102D", "\u1014\u1039\u1012\u102F"},
        {"\u1017\u102D", "\u1014\u1039\u1012\u1031\u102C"}, {"\u1017\u102F", "\u1012\u1039\u1013"},
        {"\u1017\u103B", "\u1002\u1039\u1003\u1019"},
        {"\u1017\u103B", "\u1009\u1039\u1005\u1010\u102C\u1038"},
        {"\u1017\u103B", "\u1010\u1039\u1010\u102D"}, {"\u1017\u103C", "\u101F\u1039\u1019"},
        {"\u1018\u102F", "\u1019\u1039\u1019\u1005\u102D\u102F\u1038"},
        {"\u1018\u102F", "\u1019\u1039\u1019\u101B\u102C"},
        {"\u1019\u102D", "\u1005\u1039\u1006\u102C"},
        // {
        // "\u1019\u102D",
        // "\u1010\u1039\u1010\u1030"
        // },
        {"\u1019\u102D", "\u101C\u1039\u101C\u102C"},
        {"\u1019\u102F", "\u1000\u1039\u1001\u1015\u102B\u100C\u103A"},
        {"\u1019\u102F", "\u100B\u1039\u100C\u1031\u102C"}, {"\u1019\u102F", "\u1010\u1039\u1010"},
        {"\u1019\u1031", "\u1010\u1039\u1010\u102C"},
        {"\u1019\u103E", "\u1000\u1039\u1001\u101B\u102F"},
        {"\u101A\u102F", "\u1010\u1039\u1010\u102C"}, {"\u101A\u102F", "\u1010\u1039\u1010\u102D"},
        {"\u101E", "\u1010\u1039\u1010\u102D"}, {"\u101E", "\u1010\u1039\u1010\u100c\u102c\u1014"},
        {"\u101E", "\u1010\u1039\u1010\u1017\u1031\u1012"},
        {"\u101E", "\u1010\u1039\u1010\u1018\u102C\u1002"}, {"\u101E", "\u1010\u1039\u1010\u1019"},
        {"\u101E", "\u1010\u1039\u1010\u101D\u102B"}, {"\u101B\u101F", "\u1014\u1039\u1010\u102C"},
        {"\u101B\u102D", "\u1000\u1039\u1001\u102C"},
        {"\u101B\u102F", "\u1000\u1039\u1001\u1005\u102D\u102F\u1038"},
        {"\u101C\u102D", "\u1019\u1039\u1019\u102C"},
        {"\u101C\u102D", "\u1019\u1039\u1019\u1031\u102C\u103A"},
        {"\u101D\u1004", "\u103A\u1039\u1000\u1014\u1039\u1010"},
        {"\u101D\u1004", "\u103A\u1039\u1000\u101D\u102F\u1010\u1039\u1010\u102D"},
        {"\u101D\u101E", "\u1014\u1039\u1010"}, {"\u101D\u102D", "\u1005\u1039\u1005"},
        {"\u101D", "\u1007\u1039\u1007\u1014\u103A\u1038"},
        {"\u101D\u102D", "\u1007\u1039\u1007\u102C"}, {"\u101E\u1019", "\u1002\u1039\u1002"},
        {"\u101E\u101B", "\u1000\u1039\u1001\u1014\u103A"},
        {"\u101E\u101B", "\u1007\u1039\u1008\u102C\u101A\u103A"},
        {"\u101E\u102D", "\u1000\u1039\u1001\u102C"},
        {"\u101E\u102D", "\u1009\u1039\u1007\u102D\u102F\u1038"},
        {"\u101E\u102D", "\u1012\u1039\u1013"}, {"\u101E\u102D", "\u1014\u1039\u1013\u1031\u102C"},
        {"\u101E\u102D", "\u1015\u1039\u1015\u1036"},
        {"\u101E\u102F", "\u1010\u1039\u1010\u1014\u103A"}, {"\u101E\u102F", "\u1012\u1039\u1013"},
        {"\u1015\u101B", "\u1014\u1039\u1010"}, {"\u101E\u1031", "\u1010\u1039\u1010\u102C"},
        {"\u101E\u103D", "\u1010\u1039\u1010\u1015\u1010\u103A"},
        {"\u1021\u1004", "\u103A\u1039\u1002\u102F\u1010\u1039\u1010\u102D\u102F\u101B\u103A"},
        {"\u1021\u1014", "\u1010\u1039\u1010"}, {"\u1021\u101C", "\u1007\u1039\u1007\u102E"},
        {"\u1025\u1015", "\u1005\u1039\u1006\u1031\u1012"},
        {"\u1025\u1015", "\u1007\u1039\u1008\u102C\u101A\u103A"},
        {"\u1027\u1000", "\u1014\u1039\u1010"}, {"\u1019\u1010", "\u1002\u1039\u1002"},
        {"\u1019\u1031", "\u1010\u1039\u1010\u101A\u103B"},
        {"\u1000\u102C\u1019", "\u1010\u1039\u1010"}, {"\u1005\u1010\u102F", "\u1010\u1039\u1011"},
        {"\u100C\u102C\u1014", "\u1014\u1039\u1010\u101B"},
        {"\u1010\u102D\u101B", "\u1005\u1039\u1006\u102C\u1014\u103A"},
        {"\u1012\u1031\u101E", "\u1014\u1039\u1010\u101B"},
        {"\u1014\u101D\u1000", "\u1019\u1039\u1019"}, {"\u1015\u100B\u102D", "\u1005\u1039\u1005"},
        {"\u1015\u1012\u102F", "\u1019\u1039\u1019\u102C"},
        {"\u1015\u101B\u102D", "\u1000\u1039\u1001\u101B\u102C"},
        {"\u1015\u101B\u102D", "\u1005\u1039\u1006\u1031\u1012"},
        {"\u1015\u103C\u102D", "\u1010\u1039\u1010\u102C"},
        {"\u1015\u103C\u102F", "\u1017\u1039\u1017"},
        {"\u1017\u103B\u102F", "\u1015\u1039\u1015\u1010\u103A"},
        {"\u1017\u103C\u102C", "\u101F\u1039\u1019\u100F"},
        {"\u1017\u103C\u102C", "\u101F\u1039\u1019\u102E"},
        {"\u1017\u103C\u102D", "\u1005\u1039\u1006\u102C"},
        {"\u1002", "\u1014\u1039\u1013\u102D\u102F\u101B\u103A"},
        {"\u101A\u1031\u102C", "\u1000\u1039\u1001\u1019"},
        {"\u101D\u102D\u101E", "\u1007\u1039\u1007\u1014\u102E"},
        {"\u103F", "\u1014\u1039\u1010\u101B\u102C"},
        {"\u101E\u1019\u102F", "\u1005\u1039\u1005\u100A\u103A\u1038"},
        {"\u101E\u1019\u102F", "\u1012\u1039\u1012\u101B\u102C"},
        {"\u101E\u1019\u102F", "\u1015\u1039\u1015\u102C\u1012\u103A"},
        {"\u101E\u102D\u1004", "\u103A\u1039\u1002\u102F\u1010\u1039\u1010\u101B"},
        {"\u101E\u102F\u101D", "\u100F\u1039\u100F"},
        {"\u101E\u1031\u102C", "\u1015\u1039\u1015\u101A\u102D\u102F"},
        {"\u101E\u103B\u103E", "\u1010\u1039\u1010\u101B"},
        {"\u1021\u1012\u102D", "\u1014\u1039\u1014\u102C\u1012\u102B\u1014\u103A"},
        {"\u1021\u1013\u102D", "\u1015\u1039\u1015\u102C\u101A\u103A"},
        {"\u1021\u101A\u102F", "\u1010\u1039\u1010"}, {"\u1021\u101B\u101F", "\u1010\u1039\u1010"},
        {"\u1021\u101B\u102D", "\u1014\u1039\u1012\u1019\u102C"},
        {"\u1021\u102C\u1002", "\u1014\u1039\u1010\u102F"},
        {"\u1021\u102C\u1011", "\u1017\u1039\u1017\u100F"},
        {"\u1021\u102C\u101D", "\u1007\u1039\u1007\u1014\u103A\u1038"},
        {"\u1025\u1015\u1031", "\u1000\u1039\u1001\u102C"},
        {"\u1005\u102C\u101B\u102D", "\u1010\u1039\u1010"},
        {"\u1007\u102C\u1010\u102D", "\u1015\u1039\u1016\u102D\u102F\u101C\u103A"},
        {"\u1013\u102C\u1014\u103D", "\u1014\u1039\u1010\u101B\u102E"},
        {"\u1015\u100B\u102D\u1015", "\u1000\u1039\u1001"},
        {"\u1015\u100B\u102D\u101E", "\u1014\u1039\u1013\u102C"},
        {"\u1019\u102D\u101C\u102D", "\u1014\u1039\u1012"},
        {"\u1000", "\u1014\u1039\u1010\u101B\u102D\u1000\u103A"},
        {"\u101D\u102B\u100F\u102D", "\u1007\u1039\u1007"},
        {"\u101F\u102D\u1019\u101D", "\u1014\u1039\u1010\u102C"},
        {"\u1015\u102B\u1019\u1031\u102C", "\u1000\u1039\u1001"},
        {"\u1000\u102F", "\u1010\u1039\u1010\u101B\u102C"},
        {"\u1019\u102D", "\u1010\u1039\u1010\u102F"}, {"\u101E", "\u1010\u1039\u1010\u102F"},
        {"\u1010", "\u1014\u1039\u1014\u102F"}, {"\u1005", "\u100F\u1039\u100D\u102C\u1038"},
        {"\u101A\u103B\u102C\u101D", "\u1005\u1039\u1005"},
        {
            "\u1016\u1031\u102C",
            "\u1020\u1039\u100B\u1017\u1039\u1017\u102C"
        },
        {
            "\u101B\u1015\u103A",
            "\u100B\u1039\u100C\u102C\u1014\u103A"
        },
        {
            "\u101E\u1004",
            "\u103A\u1039\u1001\u102B\u101B\u1000\u1039\u1001\u1014\u1039\u1013\u102C"
        },
        {
            "\u1021\u1018\u102D",
            "\u1007\u1039\u1008\u102C"
        },
        {
            "\u1019",
            "\u1025\u1039\u1007\u101B\u102E"
        },
        {
            "\u1000",
            "\u1019\u1039\u1018\u1031\u102C\u1007"
        },
        {
            "\u1010",
            "\u1019\u1039\u1017\u101D\u1010\u102E"
        },
        {
            "\u1021\u1014",
            "\u1014\u1039\u1010\u101B"
        },
        {
            "\u1021",
            "\u1002\u1039\u1002\u1019\u101F\u102C"
        },
        {
            "\u1002",
            "\u1014\u1039\u1011\u101D\u102B"
        },
        {
            "\u1015",
            "\u100F\u1039\u100D\u102D\u1010"
        },
        {
            "\u1019",
            "\u1025\u1039\u1007\u1030"
        }
    };


    public static String[][] getWords() {
        return uniPahsinWords;
    }
}
