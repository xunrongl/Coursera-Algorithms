/**
 * Weighted Quick Union Implementation
 * Created by lixunrong on 2/8/15.
 */
public class WeightedQuickUnion {
    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int N){
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnion uf = new WeightedQuickUnion(N);
        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.print(p + "-" + q + '\t');

            for (int i = 0; i < N; i++) {
                StdOut.print(uf.id[i] + " ");
            }
            StdOut.println();
        }
    }

    public int root(int p){
        validate(p);
        int proot = p;
        while(proot != id[p]){
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int a = root(p);
        int b = root(q);
        if (a == b) return;
        if (size[a] > size[b]){
            id[b] = a;
            size[a] += size[b];
        }
        else{
            id[a] = b;
            size[b] += size[a];
        }
    }

    private void validate(int p){
        int N  = id.length;
        if(p < 0 || p >= N){
            throw new IndexOutOfBoundsException("Your input is not between 0 and " + N);
        }
    }
}
