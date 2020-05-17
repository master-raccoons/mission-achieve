import java.util.*;

public class LongestSleep
{
public static void main(String args[]) {
    
    String S = "Sun 01:10-23:00@Sat 01:00-23:40@" +
            "Wed 01:00-23:60@Thu 01:00-23:60@" +
            "Fri 01:00-23:60@"+
            "Mon 01:00-23:60@Tue 01:00-23:60"
            ;
    String slots[] = S.split("@");
    Set<String> daysList=new TreeSet<>();
    for(Days d: Days.values() ) {
        for (int i = 0; i < slots.length; i++) {
            if(slots[i].startsWith(d.name()))
            daysList.add(slots[i]);
     }
    }

    int remHr = 0;
    int remMin = 0;
    int sleepMins = 0;
    int prevHrs=0;
    int prevMin=0;
    String prev=null;
        for(Days eDay: Days.values())
        {

            boolean flag=true;

            for (String day:daysList)
            {

                String d = day.substring(0, 3);
                if(day.startsWith(eDay.name()))
                {
                    flag=false;

                    if(prev!=null && !prev.equals(d)) {
                        remHr+= 23 - prevHrs;
                        remMin+= 60 - prevMin;
                        prevHrs=0;
                        prevMin=0;
                    }
                    int sHrTime = Integer.parseInt(day.substring(4, 6)) - prevHrs;
                    int sMinTime = Integer.parseInt(day.substring(7, 9)) - prevMin;

                    int eHrTime = Integer.parseInt(day.substring(10, 12));
                    int eMinTime = Integer.parseInt(day.substring(13, 15));

                    int scheduleMin=((sHrTime + remHr) * 60 + sMinTime + remMin);

                    sleepMins = Math.max(scheduleMin, sleepMins);

                    remHr=0;
                    remMin=0;
                    prevHrs = eHrTime;
                    prevMin = eMinTime;
                    prev=d;

                }
            }
            if(flag) {
                remHr = remHr + 24;
            }
        }
    sleepMins = Math.max(((23-prevHrs+remHr) * 60  + 60-prevMin), sleepMins);

    System.out.println(sleepMins);
    System.out.println(sleepMins/60f);

}

}
 enum Days
{
    Mon,Tue,Wed,Thu,Fri,Sat,Sun;
        }
