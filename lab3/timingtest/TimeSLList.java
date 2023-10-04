package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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

    public static void timeGetLast() {
        AList a = new AList();AList tim = new AList();AList ops = new AList();
        int[] lista={1000,2000,4000,8000,1600,3200,6400,12800};
        for (int num=0;num < lista.length;num+=1){
            a.addLast(lista[num]);
            SLList slis = new SLList(45);
            for(int l=0;l<lista[num];l+=1){
                slis.addLast(1);
            }
            Stopwatch sw = new Stopwatch();
            for(int m=0;m<10000;m+=1){
                slis.getLast();}
            double timeInSeconds = sw.elapsedTime();
            tim.addLast(timeInSeconds);
            ops.addLast(10000);
        }
        printTimingTable(a, tim, ops);
    }
}
