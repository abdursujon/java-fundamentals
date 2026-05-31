import java.time.*;
import java.time.format.*;
/**
 * Date and Time API in Java
 *
 * 1. LocalDate
 * 2. LocalTime
 * 3. LocalDateTime
 * 4. ZonedDateTime
 * 5. DateTimeFormatter
 * 6. Period
 * 7. Duration
 */
public class DateTimeAPI {
    public static void main(String[] args){

        // 1. LocalDate - date only
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getDayOfWeek());
        System.out.println(today.plusDays(10));
        System.out.println(today.minusMonths(2));
        LocalDate birthDay = LocalDate.of(1999, 12, 5);
        System.out.println(birthDay);

        // 2. LocalTime - time only
        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println("hour: " + time.getHour());
        System.out.println("min: " + time.getMinute());
        System.out.println("second: " + time.getSecond());
        System.out.println("add hours: " + time.plusHours(2));
        System.out.println("minus minute: " + time.minusMinutes(5));


        // 3. LocalDateTime - date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("date and time: " + dateTime);
        System.out.println(dateTime.plusDays(5).minusHours(2));

        // 4. ZonedDateTime - date, time and timezone
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        ZonedDateTime america = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(america);
        ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyo);
        ZonedDateTime beijing= ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(beijing);

        // 5. DateTimeFormatter - format dates
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        System.out.println(today.format(dateFormatter));
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        System.out.println(time.format(timeFormatter));
        DateTimeFormatter dateAndTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss a");
        System.out.println(dateTime.format(dateAndTimeFormatter));

        // 6. Period - difference between dates
        LocalDate start = LocalDate.of(1999, 2, 18);
        LocalDate end = LocalDate.now();
        Period livedSoFar = Period.between(start, end);
        System.out.println("Lived so far: " + livedSoFar.getYears() + " years, " + livedSoFar.getMonths() + " months, " + livedSoFar.getDays() + " days");

        // 7. Duration - difference between times
        LocalTime startTime = LocalTime.of(17, 0);
        LocalTime endTime = LocalTime.of(19, 0);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println(duration.toHours() + " hours, " + duration.toMinutesPart() + " minutes");
    }

}
