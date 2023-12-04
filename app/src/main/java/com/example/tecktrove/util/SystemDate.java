package com.example.tecktrove.util;


import java.util.Calendar;

/**
 * Helper class to get the system date.
 * The class allows to replace the system date with a predefined date.
 * This feature is useful for performing automatic checks.
 */
public class SystemDate {

    protected SystemDate() { }

    private static SimpleCalendar stub;


    /**
     * Sets a specific date as the system date.
     * This date is returned by {@link SystemDate#now()}.
     * If {@code null} is set instead of a default date then the actual system date is returned
     *
     * @param stubDate the returned date
     */
    protected static void setStub(SimpleCalendar stubDate) {
        stub = stubDate;
    }

    /**
     * Removes the stem
     */
    protected static void removeStub() {
        stub = null;
    }


    /**
     * Returns the system's date or one
     * predetermined date where it has been set
     * by {@link SystemDate#setStub}.
     * @return system's date
     */
    public static SimpleCalendar now() {
        return stub == null ? new SimpleCalendar(Calendar.getInstance()) : stub;
    }
}

