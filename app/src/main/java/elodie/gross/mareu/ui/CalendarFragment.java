package elodie.gross.mareu.ui;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;

import java.util.Calendar;

public class CalendarFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
    }
}
 /***
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
