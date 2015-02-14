/**
 * Created by lixunrong on 2/13/15.
 */
public class QuickFind {
    private int[] id;

    public QuickFind(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
        return;
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

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind uf = new QuickFind(N);
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
