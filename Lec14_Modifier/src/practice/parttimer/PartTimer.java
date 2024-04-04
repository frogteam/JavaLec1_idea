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
        this(nickName);  // 생성자 위임 : 먼저 호출할 생성자 지정.  생성자 안에서 첫번째 문장으로 실행되어야 한다
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

    // 근무시간에 따른 급여계산
    public int calcTotalWage(int hour) {
        totalWage = HOUR_RATE * hour;
        return totalWage;
    }

    // 근무시간 + 상여금에 따른 급여계산
    public int calcTotalWage(int hour, int bonus) {
        totalWage = HOUR_RATE * hour + bonus;
        return totalWage;
    }


} // end cldass
