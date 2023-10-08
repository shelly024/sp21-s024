package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

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

        AList a = new AList(); AList tme = new AList();
        int[] lista={1000,2000,4000,8000,16000,32000,64000,128000};
        for (int num=0;num < lista.length;num+=1){
            a.addLast(lista[num]);
            AList t = new AList();
            Stopwatch sw = new Stopwatch();
            for(int xh=0;xh<lista[num];xh+=1){
                t.addLast(1);
            }
            double timeInSeconds = sw.elapsedTime();
            tme.addLast(timeInSeconds);

        }

        printTimingTable(a,tme,a);
    }
}
