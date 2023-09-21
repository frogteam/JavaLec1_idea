package com.J06.LocalDateTime날짜계산;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://newbedev.com/java-8-localdate-how-do-i-get-all-dates-between-two-dates

/**
 *
 * plusDays(long)
 * plusMonths(long)
 * plusWeeks(long)
 * plusYears(long)
 */


// 두개의 LocalDate 사이의 날짜 구하기 

public class DateTime06Main {

	public static void main(String[] args) {

		LocalDateTime now = LocalDateTime.now();

		// plusXXX(), minuxXXX()
		LocalDateTime[] arr = {
				now,
				now.plusDays(1),
				now.plusDays(30),
				now.plusMonths(1),  // plusDays(30) 과는 다르다
				now.plusYears(1),
				now.plusHours(3),
				now.plusMinutes(4),
				//now.plus(10, Temporal.)
				
				// minusXXX() 도 동일하다
		};
		for (var date : arr) System.out.println(date);

		// with

		//-----------------------------------
		System.out.println("-".repeat(15));
		LocalDate start = LocalDate.now();
		// 오늘 기준으로 다음달 마지막날
		LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
				.limit(ChronoUnit.DAYS.between(start, end)).collect(Collectors.toList());
		
		System.out.println(dates.size());
		System.out.println(dates);

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