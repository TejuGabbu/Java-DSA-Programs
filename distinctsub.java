class Solution {
    public int numDistinct(String s, String t) 
    {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for(int i = 0 ; i<n ; i++)
        {
            Arrays.fill(dp[i] , -1);
        }
        return recur(s , t , 0 , 0 , dp);
    }
    public int recur(String s , String t , int i , int j , int dp[][])
    {
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int take = 0;
        if(s.charAt(i)==t.charAt(j))
        {
            take = recur(s , t , i+1 , j+1 ,dp);
        }
        int not = recur(s , t , i+1 , j , dp);

        return dp[i][j] = take+not;
    }
}