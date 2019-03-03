class FW 
{
    static long[] ft; 
	public FW(int n) 
	{ 
		ft = new long[n+1]; 
	} 
	public static long rsq(int b) 
	{ // returns RSQ(1, b)
		long sum = 0; 
		for (; b != 0; b -= (b & (-b)))
		{	
			sum += ft[b];
		}
		return sum; 
	}
	public static long rsq(int a, int b) 
	{ 
		return rsq(b) - (a == 1 ? 0 : rsq(a - 1)); 
	}

	public static void adjust(int k, long v) 
	{ // note: n = ft.size() - 1
		for (; k < (long)ft.length; k += (k & (-k))) 
		{
			ft[k] += v; 
		}
	}
	public static void adjust(int k) 
	{
		long v;
		if(rsq(k,k) == 0)
		{
			v = 1;
		}
		else
		{
			v = -1;
		}
		for(; k < ft.length; k += (k & (-k)))
		{
			ft[k] += v;
		}
	}
}
class UnionFind
{
    private int[] parents;
	//This following tells you how many nodes are connected to the array
	private int[] rankArray;
    UnionFind(int n)
    {
        parents = new int[n + 1];
		rankArray = new int[n+1];
        for(int i = 0; i < n; i++)
        {
            parents[i] = i;
			rankArray[i] = 1;
        }
    }

    int find(int a)
    {
        //This compresses your search tree (making it only 1 root), and does what it normally does
		while(!(a == array[a]))
		{
			array[a] = array[array[a]];
			a = array[a];
		}
        return a;
    }

    void union(int a , int b)
    {
        int p = find(a);
        int q = find(b);
        if(rankArray[p] < rankArray[q])
        {
            rankArray[q] += rankArray[p];
			array[p] = q;
        }
		else
		{
			rankArray[p] += rankArray[q];
			array[q] = p;
		}
    }

    boolean connected(int a, int b)
    {
        return find(a) == find(b);
    }
}