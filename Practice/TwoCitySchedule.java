import java.util.Arrays;
import java.util.Comparator;

public class TwoCitySchedule
{
    public static void main(String ar[])
    {

            int[][] costs = {{30, 100}, {30, 200}, {40, 50}, {30, 900}};

            System.out.println(twoCitySchedCost(costs));




    }

    public static  int twoCitySchedCost(int[][] costs) {
        int cityA = costs.length / 2;
        int cityB = cityA;
        int totalCost = 0;

        for (int i = 0; i < costs.length; i++) {
            int dif = Math.abs(costs[i][0] - costs[i][1]);
            for (int j = 0; j < costs.length; j++) {

                if (dif > Math.abs(costs[j][0] - costs[j][1])) {
                    dif = Math.abs(costs[j][0] - costs[j][1]);
                    int temp = costs[i][0];
                    int temp1 = costs[i][1];
                    costs[i][0] = costs[j][0];
                    costs[i][1] = costs[j][1];
                    costs[j][0] = temp;
                    costs[j][1] = temp1;

                }
            }

        }


        for (int i = 0; i < costs.length; i++)
        {
            int index = i;
            if (cityB > 0 && (costs[i][0] > costs[index][1] || cityA <= 0))
            {
                totalCost += costs[index][1];
                cityB--;
            }
            else if (cityA > 0 && (costs[index][1] > costs[index][0] || cityB <= 0)) {
                totalCost+= costs[index][0];
                cityA--;
            }
        }

return totalCost;
    }


}
