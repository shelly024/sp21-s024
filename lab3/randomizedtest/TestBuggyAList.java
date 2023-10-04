package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing a=new AListNoResizing();
        BuggyAList b=new BuggyAList();
        int[] number={4,5,6};
        for(int i=0;i<number.length;i+=1){
            a.addLast(number[i]);
            b.addLast(number[i]);
        }
        //*for(int i=0;i<number.length;i+=1){a.removeLast();b.removeLast();if(a.equals(b)){System.out.print("success");}else{System.out.print("fail");}//
        assertEquals(a.size(), b.size());
        assertEquals(a.removeLast(), b.removeLast());
    }


    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Broken = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size1 = Broken.size();
                assertEquals(size,size1);
                System.out.println("size: " + size + size1);
            }

            if (L.size() >= 1 && Broken.size() >= 1){
                if (operationNumber == 2){
                    L.getLast();
                    Broken.getLast();
                    assertEquals(L.getLast(),Broken.getLast());
                }

                if (operationNumber == 3){
                    assertEquals(L.removeLast(),Broken.removeLast());
                }
            }
        }

    }
}
