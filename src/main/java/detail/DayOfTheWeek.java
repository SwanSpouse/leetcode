package detail;

class DayOfTheWeek {

    public String[] week = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public boolean isLeapYear(int year) {
        if(year % 100 == 0 ) {
            return year % 400 == 0 ;
         }
         return year % 4 == 0;
    }

    public String dayOfTheWeek(int day, int month, int year) {
        int countDays = 0 ;
        for(int i = 1971; i < year; i ++) {
            countDays += isLeapYear(i) ? 366 : 365;
        }
        // 计算月份
        for(int i = 1; i < month; i ++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                countDays += 31;
                break;
                case 2:
                countDays += isLeapYear(year) ? 29: 28;
                break;
                default:
                countDays += 30;
                break;
            }
        }
        // 计算日期
        countDays += day-1;
        // 1971年1月1日 星期五
        return week[(countDays + 5) % 7];
    }
}