package io.github.vampirestudios.molecularcraft.utils;

public class TimeHelper {
    public static final float DAYS_IN_A_YEAR = 365.25F;
    public static final int HOURS_IN_A_DAY = 24;
    public static final float HOURS_IN_A_YEAR = DAYS_IN_A_YEAR * HOURS_IN_A_DAY;
    public static final int MINUTES_IN_AN_HOUR = 60;
    public static final long MINUTES_IN_A_DAY = HOURS_IN_A_DAY * MINUTES_IN_AN_HOUR;
    public static final float MINUTES_IN_A_YEAR = HOURS_IN_A_YEAR * MINUTES_IN_AN_HOUR;
    public static final int SECONDS_IN_A_MINUTE = 60;
    public static final float SECONDS_IN_A_YEAR = MINUTES_IN_A_YEAR * SECONDS_IN_A_MINUTE;
    public static final long SECONDS_IN_A_DAY = MINUTES_IN_A_DAY * SECONDS_IN_A_MINUTE;
    public static final long SECONDS_IN_AN_HOUR = MINUTES_IN_AN_HOUR * SECONDS_IN_A_MINUTE;
}
