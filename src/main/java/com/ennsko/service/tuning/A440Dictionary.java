package com.ennsko.service.tuning;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class A440Dictionary {
    
    public static final Map<String, Double> NOTE_TO_FREQUENCY;

    static {
        Map<String, Double> m = new HashMap();

        m.put("C0", 16.35);
        m.put("C#0", 17.32); m.put("Db0", 17.32);
        m.put("D0", 18.35);
        m.put("D#0", 19.45); m.put("Eb0", 19.45);
        m.put("E0", 20.60);
        m.put("F0", 21.83);
        m.put("F#0", 23.12); m.put("Gb0", 23.12);
        m.put("G0", 24.50);
        m.put("G#0", 25.96); m.put("Ab0", 25.96);
        m.put("A0", 27.50);
        m.put("A#0", 29.14); m.put("Bb0", 29.14);
        m.put("B0", 30.87);

        m.put("C1", 32.70);
        m.put("C#1", 34.65); m.put("Db1", 34.65);
        m.put("D1", 36.71);
        m.put("D#1", 38.89); m.put("Eb1", 38.89);
        m.put("E1", 41.20);
        m.put("F1", 43.65);
        m.put("F#1", 46.25); m.put("Gb1", 46.25);
        m.put("G1", 49.00);
        m.put("G#1", 51.91); m.put("Ab1", 51.91);
        m.put("A1", 55.00);
        m.put("A#1", 58.27); m.put("Bb1", 58.27);
        m.put("B1", 61.74);

        m.put("C2", 65.41);
        m.put("C#2", 69.30); m.put("Db2", 69.30);
        m.put("D2", 73.42);
        m.put("D#2", 77.78); m.put("Eb2", 77.78);
        m.put("E2", 82.41);
        m.put("F2", 87.31);
        m.put("F#2", 92.50); m.put("Gb2", 92.50);
        m.put("G2", 98.00);
        m.put("G#2", 103.83); m.put("Ab2", 103.83);
        m.put("A2", 110.00);
        m.put("A#2", 116.54); m.put("Bb2", 116.54);
        m.put("B2", 123.47);

        m.put("C3", 130.81);
        m.put("C#3", 138.59); m.put("Db3", 138.59);
        m.put("D3", 146.83);
        m.put("D#3", 155.56); m.put("Eb3", 155.56);
        m.put("E3", 164.81);
        m.put("F3", 174.61);
        m.put("F#3", 185.00); m.put("Gb3", 185.00);
        m.put("G3", 196.00);
        m.put("G#3", 207.65); m.put("Ab3", 207.65);
        m.put("A3", 220.00);
        m.put("A#3", 233.08); m.put("Bb3", 233.08);
        m.put("B3", 246.94);

        m.put("C4", 261.63);
        m.put("C#4", 277.18); m.put("Db4", 277.18);
        m.put("D4", 293.66);
        m.put("D#4", 311.13); m.put("Eb4", 311.13);
        m.put("E4", 329.63);
        m.put("F4", 349.23);
        m.put("F#4", 369.99); m.put("Gb4", 369.99);
        m.put("G4", 392.00);
        m.put("G#4", 415.30); m.put("Ab4", 415.30);
        m.put("A4", 440.00);
        m.put("A#4", 466.16); m.put("Bb4", 466.16);
        m.put("B4", 493.88);

        m.put("C5", 523.25);
        m.put("C#5", 554.37); m.put("Db5", 554.37);
        m.put("D5", 587.33);
        m.put("D#5", 622.25); m.put("Eb5", 622.25);
        m.put("E5", 659.25);
        m.put("F5", 698.46);
        m.put("F#5", 739.99); m.put("Gb5", 739.99);
        m.put("G5", 783.99);
        m.put("G#5", 830.61); m.put("Ab5", 830.61);
        m.put("A5", 880.00);
        m.put("A#5", 932.33); m.put("Bb5", 932.33);
        m.put("B5", 987.77);

        m.put("C6", 1046.50);
        m.put("C#6", 1108.73); m.put("Db6", 1108.73);
        m.put("D6", 1174.66);
        m.put("D#6", 1244.51); m.put("Eb6", 1244.51);
        m.put("E6", 1318.51);
        m.put("F6", 1396.91);
        m.put("F#6", 1479.98); m.put("Gb6", 1479.98);
        m.put("G6", 1567.98);
        m.put("G#6", 1661.22); m.put("Ab6", 1661.22);
        m.put("A6", 1760.00);
        m.put("A#6", 1864.66); m.put("Bb6", 1864.66);
        m.put("B6", 1975.53);

        m.put("C7", 2093.00);
        m.put("C#7", 2217.46); m.put("Db7", 2217.46);
        m.put("D7", 2349.32);
        m.put("D#7", 2489.02); m.put("Eb7", 2489.02);
        m.put("E7", 2637.02);
        m.put("F7", 2793.83);
        m.put("F#7", 2959.96); m.put("Gb7", 2959.96);
        m.put("G7", 3135.96);
        m.put("G#7", 3322.44); m.put("Ab7", 3322.44);
        m.put("A7", 3520.00);
        m.put("A#7", 3729.31); m.put("Bb7", 3729.31);
        m.put("B7", 3951.07);

        m.put("C8", 4186.01);
        m.put("C#8", 4434.92); m.put("Db8", 4434.92);
        m.put("D8", 4698.63);
        m.put("D#8", 4978.03); m.put("Eb8", 4978.03);
        m.put("E8", 5274.04);
        m.put("F8", 5587.65);
        m.put("F#8", 5919.91); m.put("Gb8", 5919.91);
        m.put("G8", 6271.93);
        m.put("G#8", 6644.88); m.put("Ab8", 6644.88);
        m.put("A8", 7040.00);
        m.put("A#8", 7458.62); m.put("Bb8", 7458.62);
        m.put("B8", 7902.13);

        NOTE_TO_FREQUENCY = Collections.unmodifiableMap(m);
    }
}
