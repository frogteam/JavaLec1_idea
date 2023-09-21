package practice.parttimer;

public class PartTimer {

    private static final int HOUR_RATE = 9_860;  // 시급
    public static int TOTAL_PART_TIMERS = 0;   // 전체 직원수

    private String nickName;
    private String workPlace = "113동";
    private int totalWage = 0;

    public PartTimer(String nickName) {
        this.nickName = nickName;
        TOTAL_PART_TIMERS++;
    }

    public PartTimer(String nickName, String workPlace){
        this(nickName);
        this.workPlace = workPlace;
    }

    public String getNickName() {
        return nickName;
    }

    public int getTotalWage() {
        return totalWage;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public int calcTotalWage(int hour) {
        totalWage = HOUR_RATE * hour;
        return totalWage;
    }

    public int calcTotalWage(int hour, int bonus) {
        totalWage = HOUR_RATE * hour + bonus;
        return totalWage;
    }


} // end cldass
