package com.J06.LocalDateTime날짜계산;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://newbedev.com/java-8-localdate-how-do-i-get-all-dates-between-two-dates

/**
 * ■ 날짜 연산 : plusXXX(), minusXXX()
 * 	plusDays(long)
 * 	plusMonths(long)
 * 	plusWeeks(long)
 * 	plusYears(long)
 *
 *  ■ 경과 시간 계산
 * 		java.time.Duration  (경과 시간 객체)
 * 		java.time.Period (경과 일자 객체)
 */

public class DateTime06Main {

	public static void main(String[] args) {

		LocalDate nowDate = LocalDate.now();
		LocalDateTime nowDateTime = LocalDateTime.now();

		LocalDate date1 = LocalDate.of(2024, 2, 28);
		LocalDate date2;
		LocalDateTime datetime1 = LocalDateTime.of(2024, 2, 28, 15, 27, 30);
		LocalDateTime datetime2;

		Duration duration;  // java.time.Duration  (경과 시간 객체)
		Period period;  // java.time.Period (경과 일자 객체)

		Object[] arr = {
				"\n[plusXXX(), minusXXX()]",
				datetime1,
				datetime1.plusDays(1),
				datetime1.plusDays(30),
				datetime1.plusMonths(1),  // plusDays(30) 과는 다르다
				datetime1.plusYears(1),
				datetime1.plusHours(3),
				datetime1.plusMinutes(4),
				// minusXXX() 도 사용방법 동일

				"\n[plus(), minus(), ChronoUnit]",
				datetime1.plus(90, ChronoUnit.DAYS),  // 단위 지정 가능.
				// minus() 도 사용방법 동일

				// ※ 참조: https://cornswrold.tistory.com/489

				"\n[경과시간 계산: Duration]",
				// Duration : 두 '시간' 사이의 간격
				duration = Duration.between(datetime1, nowDateTime),
				"seconds: " + duration.getSeconds() + "s",
				"hours: " + duration.toHours() + "h",

				"\n[경과날짜 계산: Period]",
				// Period : 두 '날짜' 사이의 간격
				period = Period.between(date1, nowDate),  // between(LocalDate, LocalDate)
				period.getYears(),
				period.getMonths(),
				period.getDays(),

				"\n[특정시간단위로 계산: ChronoUnit]",
				"YEARS: " + ChronoUnit.YEARS.between(datetime1, nowDateTime),
				"WEEKS: " + ChronoUnit.WEEKS.between(datetime1, nowDateTime),
				"MINUTES: " + ChronoUnit.MINUTES.between(datetime1, nowDateTime),

				"\n[with() 와 TemporalAdjusters]",
				// 오늘 기준으로 다음달 마지막날
				nowDate.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth()),
				// 오늘을 기준으로 직전 월요일
				nowDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)),
				// 오늘을 기준으로 지난주 월요일
				nowDate.minusWeeks(1L).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)),

		};
		for (var date : arr) System.out.println(date);

		//-----------------------------------
		System.out.println("-".repeat(15));
		LocalDate start = LocalDate.now();
		// 오늘 기준으로 다음달 마지막날
		LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
				.limit(ChronoUnit.DAYS.between(start, end)).collect(Collectors.toList());
		
		System.out.println(dates.size());
		System.out.println(dates);

		System.out.println("\n프로그램 종료");
	} // end main

} // end class

//class DateRange implements Iterable<LocalDate> {
//
//	private final LocalDate startDate;
//	private final LocalDate endDate;
//
//	public DateRange(LocalDate startDate, LocalDate endDate) {
//		// check that range is valid (null, start < end)
//		this.startDate = startDate;
//		this.endDate = endDate;
//	}
//
//	@Override
//	public Iterator<LocalDate> iterator() {
//		return stream().iterator();
//	}
//
//	public Stream<LocalDate> stream() {
//		return Stream.iterate(startDate, d -> d.plusDays(1)).limit(ChronoUnit.DAYS.between(startDate, endDate) + 1);
//	}
//
//	public List<LocalDate> toList() { // could also be built from the stream() method
//		List<LocalDate> dates = new ArrayList<>();
//		for (LocalDate d = startDate; !d.isAfter(endDate); d = d.plusDays(1)) {
//			dates.add(d);
//		}
//		return dates;
//	}
//}