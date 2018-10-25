import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<List<Integer>> list = new ArrayList<List<Integer>>();


        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        temp.add(9);

        list.add(temp);

        temp = new ArrayList<>();

        temp.add(0);
        temp.add(0);
        temp.add(0);

        list.add(temp);

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        temp.add(1);

        list.add(temp);

        int m = list.size();
        int n = list.get(0).size();



        int[][] dfs = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dfs[i][j] = list.get(i).get(j);
            }
        }

//        int[][] M = new int[][]{{ 3 , 3 , 1 , 0 },
//            { 3 , 0 , 3 , 3 },
//            { 2 , 3 , 0 , 3 },
//            { 0 , 3 , 3 , 3 }
//        };

        System.out.println(minPath(m,dfs));
    }

    private static int minPath(int N, int[][] M) {

        int s , d=-1 ; // source and destination
        int V = N*N+2;
        Graph g = new Graph(V);

        // create graph with n*n node
        // each cell consider as node
        int k = 1 ; // Number of current vertex
        s = 1 ; // Number of current vertex
        for (int i =0 ; i < N ; i++)
        {
            for (int j = 0 ; j < N; j++)
            {
                if (M[i][j] != 0)
                {
                    // connect all 4 adjacent cell to
                    // current cell
                    if ( g.isSafe ( i , j+1 , M, N ) )
                        g.addEdge ( k , k+1 );
                    if ( g.isSafe ( i , j-1 , M, N ) )
                        g.addEdge ( k , k-1 );
                    if (j< N-1 && g.isSafe ( i+1 , j , M, N ) )
                        g.addEdge ( k , k+N );
                    if ( i > 0 && g.isSafe ( i-1 , j , M, N ) )
                        g.addEdge ( k , k-N );
                }

//                // source index
//                if( M[i][j] == 1 )
//                    s = k ;



                // destination index
                if (M[i][j] == 9)
                    d = k;
                k++;
            }
        }

        // find minimum moves
        return g.BFS (s, d) ;

    }

    static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        Graph(int V) {
            this.V = V ;
            adj = new LinkedList[V];
            for(int i=0;i<V;i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int d) {
            adj[s].add(d);
            adj[d].add(s);
        }

        public int BFS(int s, int d) {
            if(s == d)
                return 0;

            int[] level = new int[V];
            for(int i=0;i<V;i++) {
                level[i] = -1;
            }

            Queue<Integer> queue = new LinkedList<>();
            level[s] = 0;
            queue.add(s);



            while(!queue.isEmpty()) {
                s = queue.peek();
                queue.remove();


                for(int i=0;i<adj[s].size();i++) {
                    if(level[i] < 0 || level[i] > level[s] + 1 ) {
                        level[i] = level[s] + 1 ;
                        queue.add(i);
                    }
                }

            }

            return level[d];

        }


        boolean isSafe(int i, int j, int M[][], int N)
        {
            if ((i < 0 || i >= N) ||
                    (j < 0 || j >= N ) || M[i][j] == 0)
                return false;
            return true;
        }

    }
}
