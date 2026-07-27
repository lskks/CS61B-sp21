// This file is not graded

package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private static final String notes = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final double CONCERT = 440.0;

    public static void main(String[] args) {
        GuitarString[] keyboards = new GuitarString[37];
        for (int i = 0; i < keyboards.length; i++) {
            double frequency = CONCERT * Math.pow(2, (i - 24) / 12.0);
            keyboards[i] = new GuitarString(frequency);
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                for (int i = 0; i < notes.length(); i++) {
                    if (notes.charAt(i) == key) {
                        keyboards[i].pluck();
                    }
                }
            }

            double sample = 0;
            for (GuitarString keyboard : keyboards) {
                sample += keyboard.sample();
                keyboard.tic();
            }

            StdAudio.play(sample);
        }
    }
}