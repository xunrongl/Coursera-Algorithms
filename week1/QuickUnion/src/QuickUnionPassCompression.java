/**
 * Created by lixunrong on 2/13/15.
 */

public class QuickUnionPassCompression {
    private int[] id;
    private int[] size;

    public QuickUnionPassCompression(int N){
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int p){
        validate(p);
        int proot = p;
        while (proot != id[proot]){
            proot = id[proot];
        }
        while (p != proot){
            int tmp = p;
            p = id[p];
            id[tmp] = proot;
        }
        return proot;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int a = root(p);
        int b = root(q);
        id[a] = b;
    }

    private void validate(int p){
        int N  = id.length;
        if(p < 0 || p >= N){
            throw new IndexOutOfBoundsException("Your input is not between 0 and " + N);
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionPassCompression uf = new QuickUnionPassCompression(N);
        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + "-" + q + '\t');

            for (int i = 0; i < N; i++) {
                StdOut.print(uf.id[i] + " ");
            }
        }
    }
}
