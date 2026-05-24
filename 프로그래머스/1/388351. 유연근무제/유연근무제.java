class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            int limitTime = calculateLimitTime(schedules[i]);
            boolean isEligible = true;

            for (int j = 0; j < 7; j++) {
                int currentDay = (startday + j - 1) % 7 + 1;

                if (currentDay == 6 || currentDay == 7) {
                    continue;
                }

                if (timelogs[i][j] > limitTime) {
                    isEligible = false;
                    break;
                }
            }

            if (isEligible) {
                answer++;
            }
        }

        return answer;
    }

    private int calculateLimitTime(int schedule) {
        int hour = schedule / 100;
        int minute = schedule % 100;

        minute += 10;
        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }

        return hour * 100 + minute;
    }
}