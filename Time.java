public class Time {

    /*
    Converts the number of minutes to a formatted string indicating
    the number of hours and minutes.

    This class is easy to understand because:
    1) It is well commented. The comments explain the logic behind the code.
        For example, the comments in lines 20, 35, 48, 57 and 60 explain why certain branches exist
        (e.g. handling singular vs. plural words, handling invalid input, or separating the “hour” and “minute” portions).
        The structure of the code is also sequential and intuitive:
        it first handles edge cases, then computes hours, then computes remaining minutes, and finally builds the result.

    2) The variable names are meaningful and descriptive.
        For example, the variables hours, remain_minute, hour_str, and minute_str are intuitive and self-explanatory.
        Readers don't have to guess what the variables mean.
     */

    public static String convert(int minutes) {
        // handle edge cases for invalid input and special cases (0 minutes and 1 minute)
        if (minutes < 0) {
            return "Invalid";
        } else if  (minutes == 1) {
            return "1 minute";
        } else if (minutes == 0) {
            return "0 minutes";
        }

        // calculate the number of hours
        // construct the hour portion of final output string
        int hours = minutes / 60;
        String hour_str = "";
        if (hours != 0) {
            if (hours == 1) {
                // handle singular hour
                hour_str = "1 hour";
            } else {
                hour_str = hours + " hours";
            }
        }

        // calculate the number of minutes
        // construct the minute portion of the final output string
        int remain_minute = minutes % 60;
        String minute_str = "";
        if (remain_minute != 0) {
            if (remain_minute == 1) {
                // handle singular minute
                minute_str = "1 minute";
            } else {
                minute_str = remain_minute + " minutes";
            }
        }

        // return the final string
        if (hour_str.isEmpty()) {
            // only need minute_str if the input is less than an hour
            return minute_str;
        } else if (minute_str.isEmpty()) {
            // only need the hour_str if there's no outstanding minutes after converted to hour
            return hour_str;
        }
        return hour_str + " and " + minute_str;

    }

    public static void main(String[] args) {

        System.out.println(convert(10)); // expected: "10 minutes"
        System.out.println(convert(127)); // expected: "2 hours and 7 minutes"
        System.out.println(convert(453)); // "7 hours and 33 minutes"
        System.out.println(convert(360)); // "6 hours"
        System.out.println(convert(61)); // "1 hour and 1 minute"
        System.out.println(convert(1)); // "1 minute"
        System.out.println(convert(0)); // "0 minutes"
        System.out.println(convert(-4)); // "Invalid"
    }
}

