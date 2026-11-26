class Tuple
{
    int health;
    int row;
    int col;
    public Tuple(int health, int row, int col)
    {
        this.health=health;
        this.row=row;
        this.col=col;
    }
}
class Solution 
{
    public boolean findSafeWalk(List<List<Integer>> grid, int health) 
    {
        int row=grid.size();
        int col=grid.get(0).size();
        int[][] maze=new int[row][col];
        if(health-grid.get(0).get(0)<=0)
        return false;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.health-b.health);
        pq.offer(new Tuple(health-grid.get(0).get(0),0,0));
        maze[0][0]=health-grid.get(0).get(0);
        int[] delr=new int[]{-1,0,1,0};
        int[] delc=new int[]{0,1,0,-1};
        while(!pq.isEmpty())
        {
            Tuple temp=pq.poll();
            int crow=temp.row;
            int ccol=temp.col;
            int hp=temp.health;
           
            if(hp==0)
            continue;
            if(crow==row-1&&ccol==col-1)
            return true;
            for(int i=0;i<4;i++)
            {
                int newr=crow+delr[i];
                int newc=ccol+delc[i];
                if(newr>=0&&newr<row&&newc<col&&newc>=0&&maze[newr][newc]<hp-grid.get(newr).get(newc))
                {
                    maze[newr][newc]=hp-grid.get(newr).get(newc);
                    pq.offer(new Tuple(hp-grid.get(newr).get(newc),newr,newc));
                }
            }


        }
        return false;
    }
}