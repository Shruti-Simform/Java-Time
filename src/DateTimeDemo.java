import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeDemo {
    public void localDateMethod() {
        System.out.println("---Local Date---");
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        LocalDate tomorrow = date.plusDays(1);
        System.out.println(date);
        System.out.println(yesterday);
        System.out.println(tomorrow);

        LocalDate leap1 = LocalDate.of(2016, 05, 30);
        System.out.println(leap1.isLeapYear());

        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getYear());
        System.out.println(date.lengthOfMonth());
        System.out.println(leap1.getDayOfYear());
    }

    public void localTimeMethod() {
        System.out.println("---Local Time---");
        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(time.plusHours(5));
        System.out.println(time.plusMinutes(30));
        System.out.println(time.plusNanos(300));
        System.out.println(time.getMinute());
        System.out.println(time.minusHours(3));
        System.out.println(time.compareTo(time.plusMinutes(5)));
    }

    public void localDateTimeMethod() {
        System.out.println("---Local Date Time---");
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(dt.format(dtf));
        System.out.println(dt.plusHours(2).format(dtf));
    }

    public void offsetTimeMethod() {
        System.out.println("---Offset Time---");
        OffsetTime offset = OffsetTime.now();
        System.out.println(offset);
        System.out.println(offset.getHour());
        System.out.println(offset.getMinute());
        System.out.println(offset.getSecond());
    }

    public void offsetDateTimeMethod() {
        System.out.println("---Offset Date Time---");
        OffsetDateTime offset = OffsetDateTime.now();
        System.out.println(offset);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(offset.format(dtf));
        System.out.println(offset.getOffset());
        System.out.println(offset.getMonth());
        System.out.println(offset.getMinute());
    }

    public void zoneOffsetMethod() {
        System.out.println("---Zone Offset---");
        ZoneOffset zone = ZoneOffset.ofHoursMinutes(5, 30);
        System.out.println("Asia/Calcutta : " + zone);
        System.out.println(zone.getRules());
        System.out.println("Total seconds in time zone : " + zone.getTotalSeconds());
    }

    public void zoneIDMethod() {
        System.out.println("---Zone ID---");
        ZoneId zone1 = ZoneId.of("Asia/Kolkata");
        ZoneId zone2 = ZoneId.of("Asia/Tokyo");
        ZoneId zone3 = ZoneId.of("US/Eastern");
        LocalTime time1 = LocalTime.now(zone1);
        LocalTime time2 = LocalTime.now(zone2);
        LocalTime time3 = LocalTime.now(zone3);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
    }

    public void zonedDateTimeMethod() {
        System.out.println("---Zoned Date Time---");
        Scanner sc = new Scanner(System.in);
        System.out.print("Year : ");
        int year = sc.nextInt();
        System.out.print("Month : ");
        int month = sc.nextInt();
        System.out.print("Day : ");
        int dayOfMonth = sc.nextInt();
        System.out.print("Hour : ");
        int hour = sc.nextInt();
        System.out.print("Minute : ");
        int minute = sc.nextInt();
        System.out.print("Second : ");
        int second = sc.nextInt();
        LocalDateTime ldt = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        ZoneId india = ZoneId.of("Asia/Kolkata");
        ZonedDateTime zone11 = ZonedDateTime.of(ldt, india);
        System.out.println("Indian Standard Time Zone: " + zone11.format(dtf));
        ZoneId est11 = ZoneId.of("US/Eastern");
        ZonedDateTime zone21 = zone11.withZoneSameInstant(est11);
        System.out.println("Eastern Standard Time Zone : " + zone21.format(dtf));
    }

    public void durationMethod() {
        System.out.println("---Duration---");
        Duration duration = Duration.between(LocalTime.NOON, LocalTime.MAX);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toHours());
        System.out.println(duration.toDays());
    }

    public void yearMethod() {
        System.out.println("---Year---");
        Year year = Year.now();
        System.out.println(year);
        System.out.println("Is a leap year ? " + year.isLeap());
        Year year2 = Year.of(2018);
        System.out.println("Is this year after 2018 ? " + year.isAfter(year2));
        System.out.println("Year after 3 years from now : " + year.plusYears(3));
    }
}
