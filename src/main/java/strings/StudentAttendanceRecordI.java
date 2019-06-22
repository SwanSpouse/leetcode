package strings;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {

        int absentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCount += 1;
                if (absentCount > 1) {
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                if (i > 0 && i < s.length() - 1 && s.charAt(i - 1) == 'L' && s.charAt(i + 1) == 'L') {
                    return false;
                }
            }
        }
        return true;
    }
}
