public class Time {

    /*
    Converts the number of minutes to a formatted string indicating
    the number of hours and minutes.
     */
    public static String convert(int minutes) {
        if (minutes < 0) {
            return "Invalid";
        } else if  (minutes == 1) {
            return "1 minute";
        } else if (minutes == 0) {
            return "0 minutes";
        }

        int hours = minutes / 60;
        String hour_str = "";
        if (hours != 0) {
            if (hours == 1) {
                hour_str = "1 hour";
            } else {
                hour_str = hours + " hours";
            }
        }

        int minute = minutes % 60;
        String minute_str = "";
        if (minute != 0) {
            if (minute == 1) {
                minute_str = "1 minute";
            } else {
                minute_str = minute + " minutes";
            }
        }

        if (hour_str.length() == 0) {
            return minute_str;
        } else if (minute_str.length() == 0) {
            return hour_str;
        }
        return hour_str + " and " + minute_str;

    }

    public static void main(String[] args) {

        System.out.println(convert(10)); // expected: "10 minutes"
        System.out.println(convert(127)); // expected: "2 hours and 7 minutes"
        System.out.println(convert(453)); // "7 hours and 33 minutes"
        System.out.println(convert(360)); // "6 hours"
        System.out.println(convert(61));
        System.out.println(convert(1));
        System.out.println(convert(0));
        System.out.println(convert(-4));

    }
}

