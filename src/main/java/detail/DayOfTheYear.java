package detail;

public class DayOfTheYear {

    public boolean isLeapYear(int year) {
        return year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
    }

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int count = 0;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    count += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    count += 30;
                    break;
                case 2:
                    count += isLeapYear(year) ? 29 : 28;
                    break;
            }
        }
        return count + day;
    }
}
