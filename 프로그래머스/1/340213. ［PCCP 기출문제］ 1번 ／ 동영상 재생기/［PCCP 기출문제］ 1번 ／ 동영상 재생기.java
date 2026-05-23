class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = timeToSecond(video_len);
        int posSec = timeToSecond(pos);
        int opStartSec = timeToSecond(op_start);
        int opEndSec = timeToSecond(op_end);

        if (posSec >= opStartSec && posSec <= opEndSec) {
            posSec = opEndSec;
        }
        for (String command : commands) {
            if (command.equals("prev")) {
                posSec -= 10;
                if (posSec < 0) posSec = 0;
            } else if (command.equals("next")) {
                posSec += 10;
                if (posSec > videoLenSec) posSec = videoLenSec;
            }

            if (posSec >= opStartSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }

        return secondToTime(posSec);
    }

    private int timeToSecond(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String secondToTime(int second) {
        int m = second / 60;
        int s = second % 60;
        return String.format("%02d:%02d", m, s);
    }
}