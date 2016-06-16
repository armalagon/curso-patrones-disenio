package ni.com.armalagon.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class CalendarBuilder {
    private Calendar calendar;

    private CalendarBuilder(final Date value) {
        calendar = GregorianCalendar.getInstance();
        calendar.setTime(value);
    }

    private CalendarBuilder(final Calendar value) {
        this(value.getTime());
    }

    public CalendarBuilder removeTime() {
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return this;
    }

    public CalendarBuilder firstSaturday() {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek < Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 7 - dayOfWeek);
        }
        return this;
    }

    public CalendarBuilder lastSaturday() {
        firstSaturday();

        Calendar lastDay = CalendarBuilder.of(calendar).lastDayOfMonth().build();

        calendar.add(Calendar.DAY_OF_MONTH, 7*4);
        if (calendar.after(lastDay)) {
            calendar.add(Calendar.DAY_OF_MONTH, -7);
        }

        return this;
    }

    public CalendarBuilder lastDayOfMonth() {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return this;
    }

    public CalendarBuilder toSaturday(int i) {
        if (i < 0 || i > 5) {
            throw new IllegalArgumentException("El # de sabado esta fuera de rango");
        }
        if (i == 0) {
            return this;
        }

        firstSaturday();

        Calendar lastDay = CalendarBuilder.of(calendar).lastDayOfMonth().build();

        calendar.add(Calendar.DAY_OF_MONTH, (i - 1)*7);
        if (i == 5 && calendar.after(lastDay)) {
            throw new IllegalArgumentException("El mes no tiene 5 sabados");
        }

        return this;
    }

    public Calendar build() {
        return calendar;
    }

    public static CalendarBuilder of(Date value) {
        return new CalendarBuilder(value);
    }

    public static CalendarBuilder of(Calendar value) {
        return new CalendarBuilder(value);
    }
}
