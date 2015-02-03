import java.util.LinkedList;

// -------------------------------------------------------------------------
/**
 *  Driver class that runs the project
 *
 *  @author Mack Hasz (mrh17)
 *  @version Jul 29, 2014
 */
public class driver
{
    @SuppressWarnings({ "javadoc", "unchecked" })
    public static void main (String[] args) {
        LinkedList<Integer> setA[] = new LinkedList[1];
        String[] namesA = {"1"};

        LinkedList<Integer> setB[] = new LinkedList[3];
        String[] namesB = {"1", "2", "3"};

        LinkedList<Integer> setC[] = new LinkedList[6];
        String[] namesC = {"R", "S", "T", "U", "V", "W"};

        LinkedList<Integer> setD[] = new LinkedList[9];
        String[] namesD = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        LinkedList<Integer> setE[] = new LinkedList[9];
        String[] namesE = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        LinkedList<Integer> setF[] = new LinkedList[16];
        String[] namesF = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                            "11", "12", "13", "14", "15", "16"};

        LinkedList<Integer> setG[] = new LinkedList[14];
        String[] namesG = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                            "K", "L", "M", "N"};

        for (int i = 0; i < setA.length; i++) {
            setA[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < setB.length; i++) {
            setB[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < setC.length; i++) {
            setC[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < setD.length; i++) {
            setD[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < setE.length; i++) {
            setE[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < setF.length; i++) {
            setF[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < setG.length; i++) {
            setG[i] = new LinkedList<Integer>();
        }

        // null set
        Graph A = new Graph(setA, namesA);

        // {1,2,3} = {0,1,2}
        // (1,2)
        setB[0].add(1);
        setB[1].add(0);
        // (2,3)
        setB[1].add(2);
        setB[2].add(1);

        Graph B = new Graph(setB, namesB);

        // {R,S,T,U,V,W} = {0,1,2,3,4,5}
        // (R,S)
        setC[0].add(1);
        setC[1].add(0);
        // (S,T)
        setC[1].add(2);
        setC[2].add(1);
        // (S,V)
        setC[1].add(4);
        setC[4].add(1);
        // (S,W)
        setC[1].add(5);
        setC[5].add(1);
        // (R,S)
        setC[3].add(4);
        setC[4].add(3);

        Graph C = new Graph(setC, namesC);

        // {A,B,C,D,E,F,G,H,I} = {0,1,2,3,4,5,6,7,8}
        // (A,E)
        setD[0].add(4);
        setD[4].add(0);
        // (B,C)
        setD[1].add(2);
        setD[2].add(1);
        // (B,D)
        setD[1].add(3);
        setD[3].add(1);
        // (C,E)
        setD[2].add(4);
        setD[4].add(2);
        // (D,F)
        setD[3].add(5);
        setD[5].add(3);
        // (E,G)
        setD[4].add(6);
        setD[6].add(4);
        // (E,H)
        setD[4].add(7);
        setD[7].add(4);
        // (F,G)
        setD[5].add(6);
        setD[6].add(5);
        // (G,I)
        setD[6].add(8);
        setD[8].add(6);
        // (H,I)
        setD[7].add(8);
        setD[8].add(7);

        Graph D = new Graph(setD, namesD);

        // {A,B,C,D,E,F,G,H,I} = {0,1,2,3,4,5,6,7,8}
        // (A,E)
        setE[0].add(4);
        setE[4].add(0);
        // (B,C)
        setE[1].add(2);
        setE[2].add(1);
        // (B,D)
        setE[1].add(3);
        setE[3].add(1);
        // (C,E)
        setE[2].add(4);
        setE[4].add(2);
        // (D,F)
        setE[3].add(5);
        setE[5].add(3);
        // (E,G)
        setE[4].add(6);
        setE[6].add(4);
        // (E,H)
        setE[4].add(7);
        setE[7].add(4);
        // (F,G)
        setE[5].add(6);
        setE[6].add(5);
        // (G,I)
        setE[6].add(8);
        setE[8].add(6);
        // (H,I)
        setE[7].add(8);
        setE[8].add(7);
        // (C,G)
        setE[2].add(6);
        setE[6].add(2);
        // (A,C)
        setE[0].add(2);
        setE[2].add(0);

        Graph E = new Graph(setE, namesE);

        // {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
        // = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}
        // (1,2)
        setF[0].add(1);
        setF[1].add(0);
        // (2,3)
        setF[1].add(2);
        setF[2].add(1);
        // (2,4)
        setF[1].add(3);
        setF[3].add(1);
        // (2,5)
        setF[1].add(4);
        setF[4].add(1);
        // (3,6)
        setF[2].add(5);
        setF[5].add(2);
        // (4,7)
        setF[3].add(6);
        setF[6].add(3);
        // (4,8)
        setF[3].add(7);
        setF[7].add(3);
        // (5,9)
        setF[4].add(8);
        setF[8].add(4);
        // (7,10)
        setF[6].add(9);
        setF[9].add(6);
        // (7,11)
        setF[6].add(10);
        setF[10].add(6);
        // (7,12)
        setF[6].add(11);
        setF[11].add(6);
        // (9,13)
        setF[8].add(12);
        setF[12].add(8);
        // (13,14)
        setF[12].add(13);
        setF[13].add(12);
        // (13,15)
        setF[12].add(14);
        setF[14].add(12);
        // (13,16)
        setF[12].add(15);
        setF[15].add(12);

        Graph F = new Graph(setF, namesF);

        // {A,B,C,D,E,F,G,H,I,J,K,L,M,N} = {0,1,2,3,4,5,6,7,8,9,10,11,12,13}
        // (A,B)
        setG[0].add(1);
        setG[1].add(0);
        // (B,L)
        setG[1].add(11);
        setG[11].add(1);
        // (C,G)
        setG[2].add(6);
        setG[6].add(2);
        // (C,M)
        setG[2].add(12);
        setG[12].add(2);
        // (D,E)
        setG[3].add(4);
        setG[4].add(3);
        // (D,G)
        setG[3].add(6);
        setG[6].add(3);
        // (D,M)
        setG[3].add(12);
        setG[12].add(3);
        // (E,F)
        setG[4].add(5);
        setG[5].add(4);
        // (E,G)
        setG[4].add(6);
        setG[6].add(4);
        // (E,N)
        setG[4].add(13);
        setG[13].add(4);
        // (F,G)
        setG[5].add(6);
        setG[6].add(5);
        // (F,N)
        setG[5].add(13);
        setG[13].add(5);
        // (I,J)
        setG[8].add(9);
        setG[9].add(8);
        // (J,K)
        setG[9].add(10);
        setG[10].add(9);
        // (K,L)
        setG[10].add(11);
        setG[11].add(10);
        // (M,N)
        setG[12].add(13);
        setG[13].add(12);

        Graph G = new Graph(setG, namesG);

        System.out.println("Testing if graph A is bipartite");
        System.out.println();
        if (A.testBipartite()) {
            System.out.println("Graph A is bipartite");
        } else {
            System.out.println("Graph A is not bipartite");
        }
        System.out.println();

        System.out.println("Testing if graph B is bipartite");
        System.out.println();
        if (B.testBipartite()) {
            System.out.println("Graph B is bipartite");
        } else {
            System.out.println("Graph B is not bipartite");
        }
        System.out.println();

        System.out.println("Testing if graph C is bipartite");
        System.out.println();
        if (C.testBipartite()) {
            System.out.println("Graph C is bipartite");
        } else {
            System.out.println("Graph C is not bipartite");
        }
        System.out.println();


        System.out.println("Testing if graph D is bipartite");
        System.out.println();
        if (D.testBipartite()) {
            System.out.println("Graph D is bipartite");
        } else {
            System.out.println("Graph D is not bipartite");
        }
        System.out.println();

        System.out.println("Testing if graph E is bipartite");
        System.out.println();
        if (E.testBipartite()) {
            System.out.println("Graph E is bipartite");
        } else {
            System.out.println("Graph E is not bipartite");
        }
        System.out.println();

        System.out.println("Testing if graph F is bipartite");
        System.out.println();
        if (F.testBipartite()) {
            System.out.println("Graph F is bipartite");
        } else {
            System.out.println("Graph F is not bipartite");
        }
        System.out.println();

        System.out.println("Testing if graph G is bipartite");
        System.out.println();
        if (G.testBipartite()) {
            System.out.println("Graph G is bipartite");
        } else {
            System.out.println("Graph G is not bipartite");
        }
        System.out.println();

    }
}