import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class ParkingSlot {

    public static void main(String ar[])
    {
        System.out.println("---no of Parking slots needed to perfectly park cars ---");
        int arr[][]={{0,80},{10,80},{20,30},{30,80},{40,80},{50,80},{65,80},{80,90}};
        int max=1;
        //Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int end=arr[0][1];
        Queue<Integer> parkingQueue=new LinkedList<>();
        parkingQueue.add(end);
        for(int i=1;i<arr.length;i++)
        {
            Iterator it=parkingQueue.iterator();
            while(it.hasNext())
            {
                int num=Integer.parseInt(it.next()+"");
                if(num<=arr[i][0])
                {
                    it.remove();
                }
            }
            parkingQueue.add(arr[i][1]);
            max=Math.max(max,parkingQueue.size());
         }
          System.out.println(max);
        }



}
