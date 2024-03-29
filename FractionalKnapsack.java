import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack
{
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
		Arrays.sort(arr , (a,b)->{
			double sa = (double)((double)a.value/(double)a.weight);
			double sb = (double)((double)b.value/(double)b.weight);
			return sa < sb ? 1 : -1;
		});

		double profit = 0.0;
		for(Item i : arr)
			{
				int v = i.value;
				int currw = i.weight;
				if(W>currw)	
				{
					profit = profit + v;
					W = W - currw;
				}
				else
				{
					double unitPriceOfItem = 1.0*(i.value/(1.0*i.weight));
					double profitOfThisItem = unitPriceOfItem * W;
					profit+=profitOfThisItem;
					W=0; //After accomodating this item we are not left with any capacity
					break;
				}
			}
		return profit;
    }
}