package com.snippets.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootVueApplicationTests {

    @Test
    public void contextLoads() {
    }

    private List<Integer> EIList = new ArrayList<>();

    @Test
    public void test() {
        int N = 38; // the total number of nodes in the level, including the gateways
        int L = 79; // the number of links
        int E = 3; // the number of exit gateways

        int count = Math.max(N, L);
        System.err.println("N - " + N);
        System.err.println("L - " + L);
        System.err.println("E - " + E);

        int[][] N1N2 = {
                {28, 36},
                {0, 2},
                {3, 34},
                {29, 21},
                {37, 35},
                {28, 32},
                {0, 10},
                {37, 2},
                {4, 5},
                {13, 14},
                {34, 35},
                {27, 19},
                {28, 34},
                {30, 31},
                {18, 26},
                {0, 9},
                {7, 8},
                {18, 24},
                {18, 23},
                {0, 5},
                {16, 17},
                {29, 30},
                {10, 11},
                {0, 12},
                {15, 16},
                {0, 11},
                {0, 17},
                {18, 22},
                {23, 24},
                {0, 7},
                {35, 23},
                {22, 23},
                {1, 2},
                {0, 13},
                {18, 27},
                {25, 26},
                {32, 33},
                {28, 31},
                {24, 25},
                {28, 35},
                {21, 22},
                {4, 33},
                {28, 29},
                {36, 22},
                {18, 25},
                {37, 23},
                {18, 21},
                {5, 6},
                {19, 20},
                {0, 14},
                {35, 36},
                {9, 10},
                {0, 6},
                {20, 21},
                {0, 3},
                {33, 34},
                {14, 15},
                {28, 33},
                {11, 12},
                {12, 13},
                {17, 1},
                {18, 19},
                {36, 29},
                {0, 4},
                {0, 15},
                {0, 1},
                {18, 20},
                {2, 3},
                {0, 16},
                {8, 9},
                {0, 8},
                {26, 27},
                {28, 30},
                {3, 4},
                {31, 32},
                {6, 7},
                {37, 1},
                {37, 24},
                {35, 2}
        };

        boolean[][] array = new boolean[count][];
        for (int i = 0; i < count; ++i) {
            array[i] = new boolean[count];
        }

        for (int i = 0; i < L; i++) {
            int N1 = N1N2[i][0]; // N1 and N2 defines a link between these nodes
            int N2 = N1N2[i][1];
            array[N1][N2] = true;
            array[N2][N1] = true;
        }

        for (boolean[] anArray : array) {
            System.err.println(Arrays.toString(anArray));
        }

        EIList = Arrays.asList(0, 18, 28);
        int[] SIArray = {37, 35, 2, 1, 17};

        // game loop
        for (int SI : SIArray) {
//            int SI = aSIArray; // The index of the node on which the Skynet agent is positioned this turn

            System.err.println("SI - " + SI);

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            int EI = EIList.get(0);
            int temp = Math.abs(SI - EI);
            for (Integer i : EIList) {
                if (temp > Math.abs(SI - i))
                    EI = i;
            }

            int index = 0;
            boolean flag = true;
            while (index < count && flag) {
                int dex = EI - index;
                if (dex > 0 && array[SI][dex]) {
                    System.out.println(SI + " " + dex);
                    array[SI][dex] = false;
                    flag = false;
                }
                dex = EI + index;
                if (dex < count && array[SI][dex]) {
                    System.out.println(SI + " " + dex);
                    array[SI][dex] = false;
                    flag = false;
                }
                index++;
            }
        }
    }

}
