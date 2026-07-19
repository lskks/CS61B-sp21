package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.*;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Integer> opCounts = new AList<>();
        AList<Double> times = new AList<>();
        for (int i = 0;i <= 8;i++) {
            int n = (int) (1000 * Math.pow(2, i));
            Ns.addLast(n);
            opCounts.addLast(n);
            double timeInSecs = doAddLast(n);
            times.addLast(timeInSecs);
        }

        printTimingTable(Ns, times, opCounts);
    }

    private static double doAddLast(int times) {
        AList<Integer> arr = new AList<>();
        Stopwatch sw = new Stopwatch();
        for (int i = 0;i < times;i++) {
            arr.addLast(i);
        }
        return sw.elapsedTime();
    }
}
