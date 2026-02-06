# polymnia
A custom harmonic intonation calculator for musical exploration

## REST API -- Tuning Protocol
Framework: Java spring. A dockerfile available for building an image.

### Request
#### Required:

"harmony" : an array of interval objects

    "harmony": [
        {"semitones": -6},
        {"semitones": 0},
        {"semitones": 6},
        {"semitones": 11},
        {"semitones": 14}
    ]

"tuningSet" : an array of intervals with "ratio" property defined

    "tuningSet": [
        {"semitones": 7, "ratio": 1.5},
        {"semitones": 5, "ratio": 1.33333},
        {"semitones": 11, "ratio": 1.875}
    ]

#### Optional:

"anchor" : a float defining the exact frequency of the anchor note (interval with semitones = 0)


### Response:

The "harmony" object is transformed into by adding "ratio" and "cents" properties. These properties show how the distance of each interval from the anchor in relative terms.

If the "anchor" property is defined in the request, an array is returned with the exact frequencies of the newly tuned harmony.

### Example Request and Response
REQUEST

    {
        "harmony": [
            {"semitones": -6},
            {"semitones": 0},
            {"semitones": 6},
            {"semitones": 11},
            {"semitones": 14}
        ],
        "tuningSet": [
            {"semitones": 7, "ratio": 1.5}
        ],
        "anchor": 100
    }

RESPONSE

    {  
        "harmony": [
            {
                "semitones": -6,
                "ratio": 0.7023319615912208,
                "cents": -611.7300051923247
            },
            {
                "semitones": 0,
                "ratio": 1.0,
                "cents": 0.0
            },
            {
                "semitones": 6,
                "ratio": 1.423828125,
                "cents": 611.7300051923246
            },
            {
                "semitones": 11,
                "ratio": 1.8984375,
                "cents": 1109.775004326937
            },
            {
                "semitones": 14,
                "ratio": 2.25,
                "cents": 1403.9100017307749
            }
        ],
        "tuningSet": [
            {
                "semitones": 7,
                "ratio": 1.5,
                "cents": 701.9550008653874
            }
        ],
        "tuningType": null,
        "calcType": null,
        "anchor": 100.0,
        "frequencies": [
            70.23319615912207,
            100.0,
            142.3828125,
            189.84375,
            225.0
        ]
    }