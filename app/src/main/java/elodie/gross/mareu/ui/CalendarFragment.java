package elodie.gross.mareu.ui;
import java.util.Calendar;

public class CalendarFragment {


        public static boolean sameTime(Calendar firstTime, Calendar secondTime) {
            if (firstTime.get(Calendar.HOUR_OF_DAY) == secondTime.get(Calendar.HOUR_OF_DAY))
                return firstTime.get(Calendar.MINUTE) == secondTime.get(Calendar.MINUTE);

            return false;
        }

        public static boolean beforeOrSameTime(Calendar firstTime, Calendar secondTime) {
            if (firstTime.get(Calendar.HOUR_OF_DAY) < secondTime.get(Calendar.HOUR_OF_DAY))
                return true;
            if (firstTime.get(Calendar.HOUR_OF_DAY) == secondTime.get(Calendar.HOUR_OF_DAY))
                return firstTime.get(Calendar.MINUTE) <= secondTime.get(Calendar.MINUTE);

            return false;
        }

        public static boolean beforeTime(Calendar firstTime, Calendar secondTime) {
            if (firstTime.get(Calendar.HOUR_OF_DAY) < secondTime.get(Calendar.HOUR_OF_DAY))
                return true;
            if (firstTime.get(Calendar.HOUR_OF_DAY) == secondTime.get(Calendar.HOUR_OF_DAY))
                return firstTime.get(Calendar.MINUTE) < secondTime.get(Calendar.MINUTE);

            return false;
        }

        public static boolean afterOrSameTime(Calendar firstTime, Calendar secondTime) {
            if (firstTime.get(Calendar.HOUR_OF_DAY) > secondTime.get(Calendar.HOUR_OF_DAY))
                return true;
            if (firstTime.get(Calendar.HOUR_OF_DAY) == secondTime.get(Calendar.HOUR_OF_DAY))
                return firstTime.get(Calendar.MINUTE) >= secondTime.get(Calendar.MINUTE);

            return false;
        }

        public static boolean afterTime(Calendar firstTime, Calendar secondTime) {
            if (firstTime.get(Calendar.HOUR_OF_DAY) > secondTime.get(Calendar.HOUR_OF_DAY))
                return true;
            if (firstTime.get(Calendar.HOUR_OF_DAY) == secondTime.get(Calendar.HOUR_OF_DAY))
                return firstTime.get(Calendar.MINUTE) > secondTime.get(Calendar.MINUTE);

            return false;
        }

        private static int compareTime(Calendar firstTime, Calendar secondTime){
            if (firstTime.get(Calendar.HOUR_OF_DAY) == secondTime.get(Calendar.HOUR_OF_DAY))
                if (firstTime.get(Calendar.MINUTE) == secondTime.get(Calendar.MINUTE))
                    return 0;
                else if (firstTime.get(Calendar.MINUTE) > secondTime.get(Calendar.MINUTE))
                    return 1;
                else
                    return -1;
            else if (firstTime.get(Calendar.HOUR_OF_DAY) > secondTime.get(Calendar.HOUR_OF_DAY))
                return 1;
            else
                return -1;
        }
    }
}
