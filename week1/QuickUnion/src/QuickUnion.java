/**
 * Quick Union Implementation
 * Created by lixunrong on 2/8/15.
 */
public class QuickUnion {
    private int[] id;

    public QuickUnion(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnion uf = new QuickUnion(N);
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
        while (id[p] != p){
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    //change the root of p point to the root of q
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
}
