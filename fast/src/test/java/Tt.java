import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yuantongqin
 * 2019/8/1
 */
public class Tt {

    @Test
    public void ss(){

        LocalDate localDate = LocalDate.of(2019, 7, 27);
        LocalDateTime now = localDate.atTime(1, 0, 0);


        LocalDateTime now1 = localDate.atTime(0, 0, 0);

        System.out.println(now);
        System.out.println(now1);
        System.out.println(now.isAfter(now1));
        System.out.println(now.isBefore(now1));
        System.out.println(now.isEqual(now1));

        LocalDateTime m = now.plusMonths(1);
        LocalDateTime time = now.withYear(2019).withMonth(9);
        System.out.println(time);
        System.out.println(m.isBefore(LocalDateTime.now()));
        int second = m.getSecond();
        System.out.println(second);

        int year = now.withYear(10).getDayOfYear();
        System.out.println(year);
        System.out.println(m.toInstant(ZoneOffset.of("+8")).toEpochMilli());

    }

    @Test
    public void sa(){

        LocalDate localDate = LocalDate.of(2019, 7, 27);
        LocalDateTime now = localDate.atTime(1, 0, 0);

        LocalDate localDate1 = LocalDate.of(2014, 12, 27);
        LocalDateTime now1 = localDate1.atTime(1, 0, 0);

        System.out.println(now.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(now1.toInstant(ZoneOffset.of("+8")).toEpochMilli());


    }

    /**
     * 1564160400000
     * 1380214800000
     */


}
