package br.com.casadocodigo.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

// java.time new API date
public class Cap10 {
    public static void main(String[] args) {
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        System.out.println("Next month");
        System.out.println(nextMonth);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Now date and time");
        System.out.println(dateTime);

        LocalTime time = LocalTime.now();
        System.out.println("Now time");
        System.out.println(time);

        LocalDate date = LocalDate.now();
        System.out.println("Now date");
        System.out.println(date);

        LocalDateTime dateAndTime = date.atTime(time);
        System.out.println("Date + time");
        System.out.println(dateAndTime);

        ZonedDateTime dateWithHourAndTimeZone =
                dateAndTime.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println("With time zone");
        System.out.println(dateWithHourAndTimeZone);

        LocalDateTime withoutTimeZone = dateWithHourAndTimeZone.toLocalDateTime();
        System.out.println("Without time zone");
        System.out.println(withoutTimeZone);

        LocalDate dataAgo = LocalDate.now().withYear(1988);
        System.out.println("Get");
        System.out.println(dataAgo.getYear());

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("Conditions");
        System.out.println(today.isBefore(tomorrow));
        System.out.println(today.isAfter(tomorrow));
        System.out.println(today.isEqual(tomorrow));

        System.out.println("Today is day: " + MonthDay.now().getDayOfMonth());

        YearMonth yearMonth = YearMonth.from(date);
        System.out.println("Month and year");
        System.out.println(yearMonth.getMonth() + "/" + yearMonth.getYear());

        System.out.println(LocalDate.of(2014, 12, 25));
        System.out.println(LocalDate.of(2014, Month.DECEMBER, 25));

        Locale pt = new Locale("pt");

        System.out.println("Print format");
        System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, pt));
        System.out.println(Month.DECEMBER.getDisplayName(TextStyle.SHORT, pt));

        System.out.println("Day of week: " + date.getDayOfWeek());

        LocalDateTime localDateTime = LocalDateTime.now();
        String result = localDateTime.format(DateTimeFormatter.ISO_TIME);
        System.out.println("Formatting");
        System.out.println(result);
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MM/yy")));

        long days = ChronoUnit.DAYS.between(tomorrow, today);
        long months = ChronoUnit.MONTHS.between(tomorrow, today);
        long years = ChronoUnit.YEARS.between(tomorrow, today);
        System.out.println("Difference between days");
        System.out.println(days + " " + months + " " + years);

        Period period = Period.between(tomorrow, today);
        System.out.println("Period");
        System.out.println(period);
        if (period.isNegative()) {
            period = period.negated();
        }
        System.out.println(period);


        Duration duration = Duration.between(dateAndTime, localDateTime);
        System.out.println("Duration");
        System.out.println(duration);
        if (duration.isNegative()) {
            duration = duration.negated();
        }
        System.out.println(duration);
    }
}
