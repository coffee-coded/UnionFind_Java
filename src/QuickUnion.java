public class QuickUnion {
    private int[] id;
    private int[] sz;
    public void QuickUnionUF(int N) {
        id = new int[N];
        sz=new int [N];
        for (int i = 0; i < N; i++) {
            {id[i] = i;
            sz[i]=1;}
        }
    }

    private int root(int i) {
        while (i != id[i]){
            id[i]=id[id[i]];  //Path compression
            i = id[i];}
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void Union(int p, int q) {

        int i = root(p);
        int j = root(q);
        if(sz[i]<sz[j]) {
            id[i] = j;
            sz[j]+=sz[i];
        }
        else{
            id[j]=i;
            sz[i]+=sz[j];
        }

    }
}