import java.util.*;

public class UnionFind {
    //union find array
    static int[] uf;
    //array of sizes for each goup
    static int[] sz;
    //use hm for keeping track of sizes
    //only keeps track of unions > 1
    static HashMap<Integer, Integer> hm;
    //total number of unions
    static int GROUPSN;


    static int find(int i){
        int x = i;
        while(uf[i]!=i)
            x = uf[i];

        //path compression
        while(x!=i){
            int next = uf[i];
            uf[i] = x;
            x = next;
        }

        return x;
    }


    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        //combind smaller group under the bigger one
        if(px!=py){
            if(sz[px]>sz[py]){
                uf[py] = uf[px];
                sz[px] += sz[py];

                int sx = 1, sy = 1;
                if(hm.containsKey(py)) sy = hm.get(py);
                if(hm.containsKey(px)) sx = hm.get(px);
                hm.put(px, sx+sy);
            } else {
                uf[px] = uf[px];
                sz[py] += sz[px];

                int sx = 1, sy = 1;
                if(hm.containsKey(py)) sy = hm.get(py);
                if(hm.containsKey(px)) sx = hm.get(px);
                hm.put(py, sx+sy);
            }
        }
        GROUPSN--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int testCases = sc.nextInt();
        for (int n=0; n<testCases; ++n) { 
            int citiesN = sc.nextInt();
            GROUPSN = citiesN;
            int pairs = sc.nextInt();
            
            uf = new int[citiesN];
            sz = new int[citiesN];
            hm = new HashMap<>(citiesN);
            
            for(int i=0; i<citiesN; i++) uf[i] = i;
            Arrays.fill(sz, 1);
            
            for(int i=0; i< pairs; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                
                union(a,b);
            }
            
            System.out.println(GROUPSN-1);
           
        }
    }
}

/*
Smaple input 
2
5
3
0 1
1 2
3 4
2
1
0 1
*/