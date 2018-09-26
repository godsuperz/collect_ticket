package com.super223.utils;

import com.super223.common.constant.Const;

import java.time.LocalDate;

/**
 * 日期工具箱
 * @author superz
 */
public class DateUtil {
    public static LocalDate Condition2Date(Integer condition){
        Integer currYear = LocalDate.now().getYear();
        Integer currMonth = LocalDate.now().getMonthValue();
        Integer currDayOfYear = LocalDate.now().getDayOfYear();
        Integer currDayOfMonth = LocalDate.now().getDayOfMonth();
        switch (condition){
            case 0 :
                return null;
            case 1 :
                if (currDayOfYear + Const.WEEK <= Const.YEAR) {
                    return LocalDate.ofYearDay(currYear, currDayOfYear + Const.WEEK);
                } else {
                    return LocalDate.ofYearDay(currYear++, Const.WEEK - (Const.YEAR - currDayOfYear));
                }

            case 2 :
                if (currMonth + 1 <= 12){
                    return LocalDate.of(currYear, currMonth++, currDayOfMonth);
                } else {
                    return LocalDate.of(currYear++, (currMonth + 1) - 12, currDayOfMonth);
                }
            case 3 :
                if (currMonth + 3 <= 12){
                    return LocalDate.of(currYear, currMonth++, currDayOfMonth);
                } else {
                    return LocalDate.of(currYear++, (currMonth + 3) - 12, currDayOfMonth);
                }
            case 4 :
                if (currMonth + 12 <= 12){
                    return LocalDate.of(currYear, currMonth++, currDayOfMonth);
                } else {
                    return LocalDate.of(currYear++, (currMonth + 12) - 12, currDayOfMonth);
                }
            case 5 :
                return LocalDate.of(currYear++, currMonth, currDayOfMonth);
            default:
                break;
        }
        return null;
    }
}
