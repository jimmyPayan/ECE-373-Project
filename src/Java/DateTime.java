import java.text.SimpleDateFormat;
import java.util.Date;  

public class DateTime {

    public static String time = "";
    public static String date = "";
    public static String forecastDaysAhead = "";
    
/*
    public DateTime(){
        if(time.isBlank() && date.isBlank()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");  
            Date dateobj = new Date(); 
            String temp = formatter.format(dateobj);
            String[] temparr= temp.split(" ");
            date = temparr[0];
            time = temparr[1];
        }

    }
         */
    public DateTime(){
        if(time.isBlank() && date.isBlank()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");  
            Date dateobj = new Date(); 
            String temp = formatter.format(dateobj);
            String[] temparr= temp.split(" ");
            date = temparr[0];
            time = temparr[1];

        }
        DateGUI dategui = new DateGUI();
        dategui.placeOnPanel();
        dategui.placeOnScreen();

    }

    public static void getData(String days, String hour){
        DateTime.time = String.valueOf(Integer.valueOf(DateTime.time) + hour);
        DateTime.forecastDaysAhead = days;
        

    }

    //public static void main(String[] args){
    //    DateTime datetime = new DateTime(); 
    //}




}
