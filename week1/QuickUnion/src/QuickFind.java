/**
 * Quick Find Implementation
 * Created by lixunrong on 2/8/15.
 */
public class QuickFind {
    private int[] id;

    public QuickFind(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind uf = new QuickFind(N);
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

    /*
        check if the p and q element have the same id
    */
    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    /*
        Change all entries with id[p] to id[q]
    */
    public void union(int p, int q){
        validate(p);
        validate(q);
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    private void validate(int p){
        int N  = id.length;
        if(p < 0 || p >= N){
            throw new IndexOutOfBoundsException("Your input is not between 0 and " + N);
        }
    }
}
