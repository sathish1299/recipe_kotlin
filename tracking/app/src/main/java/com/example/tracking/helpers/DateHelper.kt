package com.example.tracking.helpers

import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit

object DateHelper {

    private val CALENDAR_DATE_FORMAT = "yyyy-MM-dd"
    private val ENCRYPTION_DATE_FORMAT = "yyyy-MM-dd"
    private val READABLE_DATE_FORMAT = "MM-dd-yyyy"
    val BORN_DATE_FORMAT ="LLLL dd ,yyyy"
    val AGE_DOB_FORMAT = "dd-mm-yyyy"
    val AGE_SLASH_FORMAT = "dd/mm/yyyy"
    val FULL_CAL_FORMAT = "dd/MM/yyyy"

    private val EXPENSE_DATA_FORMAT = "MMM dd,yyyy"
    private val CASE_UPDATE_DATE_FORMAT = "dd-MMM-yyyy"
    private val YEAR_DATE_FORMAT = "MMM dd yyyy - ha"
    private val MONTH_DATE_FORMAT = "MMMM dd"
    private val EVENT_CREATE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
    private const val DATE_TIME_FORMAT = "yyyy-MM-dd_HH:mm:ss"
    private val FULL_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    private val CURRNET_YEAR = "yyyy"
    private val DATE_YEAR = "dd yyyy"
    private val LENGTH_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"


    private const val DAY_WITH_DATE = "EEE dd"
    public const val HOUR = "h:mma"

    private const val HOUR_MINUTE = "h:mm"
    private const val HOUR_MINUTE_TEXT = "h:mm"
    private const val MILLISECS = "mm"
    private const val Hour_div = "h"
    private const val Minute_div = "mm"
    private const val Meridian_div = "a"
    private val FILTER_FORMAT = "MM/dd/yyyy hh:mm a"
    private val HOUR_MINUTE_SECONDS = "hh:mm:ss a"

    private val DOB_FORMAT = "MM/dd/yy"
    private val SLASHED_FORMAT = "MM/dd/yy"

    private val BIRTHDATE_FORMAT = "yyyy-MM-dd"

    private val SERVICE_FORMAT = "yyyy-MM-dd hh:mm:ss"

    private val EXP_READABLE = "MM/yyyy"
    private val EXP_SERVER = "MMyyyy"

    private val IMG_FILE_NAME_FORMAT = "'IMG'-MM-dd-yyyy"

    private val DOCUMENT_CREATE_DATE_FORMAT = "MMM dd,yyyy"
    private val DOCUMENT_MONTHYEAR_FORMAT = "MMMM yyyy"

    private val GRAPH_XAXIS = "E\ndd"
    private val ONLY_DATE = "dd"
    private var ONLY_MONTH = "MMMM"
    private val GRAPH_DATE_YEAR = "dd MMM\nyyyy"

    private val DAY_NAME_AND_DATE = "E\ndd"
    private val CREDIT_CARD_DATE_FORMAT = "MM/yy"
    private val MONTH_AND_YEAR_FORMAT = "mm-yy"


//    fun getDateFromTZ(tzString: String): Date {
//        val sdf = SimpleDateFormat(READABLE_DATE_FORMAT, Locale.getDefault())
//        //sdf.timeZone = TimeZone.getTimeZone("UTC")
//        return sdf.parse(tzString)
//    }
//

    fun getHourfromSeconds(hour: String): String {
        val result = hour.toInt() / 3600;
        return result.toString()
    }

    fun getMinutefromSeconds(minutes: String): String {
        val result = (minutes.toInt() % 3600) / 60;
        return result.toString()
    }

    fun getStandardFormat(date: String): String {
        try {

            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                LENGTH_FORMAT, Locale.US
            )
            val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                EXPENSE_DATA_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)

        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }
    fun getStandardDateFormat(date: String): String {
        try {

            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                LENGTH_FORMAT, Locale.US
            )
            val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = DateUtils.getRelativeTimeSpanString(date.getTime() , Calendar.getInstance().getTimeInMillis(), DateUtils.MINUTE_IN_MILLIS);
            return expectedDateFormat.toString()

        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getDateinWords(date: String):String{

        try{

        val cal = Calendar.getInstance()
        // Date date = new Date();
        val dateFormat = SimpleDateFormat(
            ENCRYPTION_DATE_FORMAT, Locale.US
        )
        val date = dateFormat.parse(date)
        cal.time = date
        val expectedDateFormat = SimpleDateFormat(
            BORN_DATE_FORMAT, Locale.US
        )
        return expectedDateFormat.format(cal.time)

    } catch (e: ParseException) {
        e.printStackTrace()
        return ""
    }


    }

    fun getFormat(milliSeconds: Long): String {
        val formatter = SimpleDateFormat(ENCRYPTION_DATE_FORMAT, Locale.US)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }

    fun getMilliSecondToRedableDateFormat(milliSeconds: Long): String {
        val formatter = SimpleDateFormat(EXPENSE_DATA_FORMAT, Locale.US)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds * 1000
        return formatter.format(calendar.time)
    }
    fun getMilliSecondToRedableDateFormats(milliSeconds: Long): String {
        val formatter = SimpleDateFormat(YEAR_DATE_FORMAT, Locale.US)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds * 1000
        return formatter.format(calendar.time)
    }

//    fun getMilliSecondToRedableDateFormat(milliSeconds: Long): String {
//        val formatter = SimpleDateFormat(EXPENSE_DATA_FORMAT, Locale.US)
//        val calendar = Calendar.getInstance()
//        calendar.timeInMillis = milliSeconds*1000
//        return formatter.format(calendar.time)
//    }
//
//    fun getMilliSecondToConnectionDateFormat(milliSeconds: Long): String {
//        val formatter = SimpleDateFormat(CONNECTION_DATE_FORMAT)
//        val calendar = Calendar.getInstance()
//        calendar.timeInMillis = milliSeconds*1000
//        return formatter.format(calendar.time)
//    }
//
//    fun getCurrentTimeInMillis() : Long {
//        return System.currentTimeMillis()
//    }


    fun getFormattedDate(calDate: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                CALENDAR_DATE_FORMAT, Locale.US
            )
            val date = dateFormat.parse(calDate)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                ENCRYPTION_DATE_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getDateinLetters(dob: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                DOB_FORMAT, Locale.US
            )
            val date = dateFormat.parse(dob)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                BIRTHDATE_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getDateFromString(date: String): Date {

        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(
            DOB_FORMAT, Locale.US
        )


        return dateFormat.parse(date)

    }

    fun getPatternFromDate(pattern: String): String {
//        yyyy-MM-dd HH:mm
        val formatter = DateTimeFormatter.ofPattern(pattern)
        val current = LocalDateTime.now().format(formatter)
        return current
    }

    fun getMonthDayString(date: String): String {

        try {

            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                FULL_DATE_FORMAT, Locale.US
            )
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");
            val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                DAY_WITH_DATE, Locale.US
            )
            return expectedDateFormat.format(cal.time)

        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getHourFromFullDate(date: Date): String {
        try {
            val cal = Calendar.getInstance()

            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                HOUR_MINUTE, Locale.US
            )
            //val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                HOUR, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getHourFromDate(date: Date): String {
        try {
            val cal = Calendar.getInstance()

            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                HOUR_MINUTE, Locale.US
            )
            //val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                DATE_TIME_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getFilterFormatnew(date: Date): String {

        try {
            val cal = Calendar.getInstance()
            val dateFormat = SimpleDateFormat(
                HOUR_MINUTE, Locale.US
            )
            //val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                FILTER_FORMAT, Locale.US
            )
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }


    fun getHourFromString(date: String): String {
        try {

            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                HOUR, Locale.US
            )
            val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                Hour_div, Locale.US
            )
            return expectedDateFormat.format(cal.time)

        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getMinuteFromString(date: String): String {
        try {

            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                HOUR, Locale.US
            )
            val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                Minute_div, Locale.US
            )
            return expectedDateFormat.format(cal.time)

        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getMeridianFromString(date: String): String {
        try {

            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                HOUR, Locale.US
            )
            val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                Meridian_div, Locale.US
            )
            return expectedDateFormat.format(cal.time)

        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }


    }

    fun getHourFromFullDateWithoutMeridian(date: Date): String {
        try {
            val cal = Calendar.getInstance()

            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                HOUR_MINUTE, Locale.US
            )
            //val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                HOUR_MINUTE, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getHourFromMilliSecs(milliSeconds: Long): String {
        try {
            val cal = Calendar.getInstance()

            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                MILLISECS, Locale.US
            )
            //val date = dateFormat.parse(date)
            cal.time = Date(milliSeconds)
            val expectedDateFormat = SimpleDateFormat(
                HOUR_MINUTE_TEXT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getHourFromFullDateMinusMinute(date: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                HOUR_MINUTE, Locale.US
            )
            val date = dateFormat.parse(date)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                HOUR, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getSlashedDate(calDate: String): String {

        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                CALENDAR_DATE_FORMAT, Locale.US
            )
            val date = dateFormat.parse(calDate)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                DOB_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getTimeFromMills(timeInMillis: Long): String? {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val simpleFormat = SimpleDateFormat(DateHelper.DATE_TIME_FORMAT, Locale.getDefault())
        return simpleFormat.format(calendar.time)
    }

    fun getServiceData(service: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                SERVICE_FORMAT, Locale.US
            )
            val date = dateFormat.parse(service)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                READABLE_DATE_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getFilterCalendar(calDate: String): Calendar {
        val cal = Calendar.getInstance()
        try {
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                READABLE_DATE_FORMAT, Locale.US
            )
            val date = dateFormat.parse(calDate)
            cal.time = date
            return cal
        } catch (e: ParseException) {
            e.printStackTrace()
            return cal
        }
    }

    fun getEndFilterCalendar(calDate: String): Calendar {
        val cal = Calendar.getInstance()
        try {
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                READABLE_DATE_FORMAT, Locale.US
            )
            val date = dateFormat.parse(calDate)
            cal.time = date
            cal.set(Calendar.HOUR, 12)
            return cal
        } catch (e: ParseException) {
            e.printStackTrace()
            return cal
        }
    }

    fun getMonthDateFormat(timeStr: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                ENCRYPTION_DATE_FORMAT, Locale.US
            )
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");
            val date = dateFormat.parse(timeStr)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                MONTH_DATE_FORMAT, Locale.US
            )

            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getOnlyDateYear(timeStr: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                ENCRYPTION_DATE_FORMAT, Locale.US
            )
            val date = dateFormat.parse(timeStr)
            cal.time = date
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");

            val expectedDateFormat = SimpleDateFormat(
                DATE_YEAR, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getEncryptionFormat(calendar: Calendar): String {
        val dateFormat = SimpleDateFormat(
            ENCRYPTION_DATE_FORMAT, Locale.US
        )

        return dateFormat.format(calendar.time)
    }

    fun getFilterFormat(calendar: Calendar): String {
        val expectedDateFormat = SimpleDateFormat(
            FILTER_FORMAT, Locale.US
        )
        return expectedDateFormat.format(calendar.time)
    }

    fun getEndFilterFormat(calendar: Calendar): String {
        val expectedDateFormat = SimpleDateFormat(
            FILTER_FORMAT, Locale.US
        )
        return expectedDateFormat.format(calendar.time)
    }

    fun getTodayDate(): String {
        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(
            CASE_UPDATE_DATE_FORMAT, Locale.US
        )
        dateFormat.timeZone = TimeZone.getTimeZone("UTC");

        return dateFormat.format(cal.time)

    }

    fun getTodayFullFormatDate(): String {
        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(
            FULL_DATE_FORMAT, Locale.US
        )
        dateFormat.timeZone = TimeZone.getTimeZone("UTC");
        return dateFormat.format(cal.time)
    }

    fun getday(): String {
        val cal = Calendar.getInstance()
//        cal.add(Calendar.DATE, count)
        val dateFormat = SimpleDateFormat(
            FULL_DATE_FORMAT, Locale.US
        )
        dateFormat.timeZone = TimeZone.getTimeZone("UTC");
        return dateFormat.format(cal.time)
    }

    fun getDateFromFullDate(day: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(FULL_DATE_FORMAT)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");

            val date = dateFormat.parse(day)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                CASE_UPDATE_DATE_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

    }

    fun getDateForFullCalendar(day: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(FULL_DATE_FORMAT, Locale.US)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");

            val date = dateFormat.parse(day)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                FULL_CAL_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getDailyLogDate(day: String): String {
        try {
            val cal = Calendar.getInstance()
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(CASE_UPDATE_DATE_FORMAT)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");

            val date = dateFormat.parse(day)
            cal.time = date
            val expectedDateFormat = SimpleDateFormat(
                MONTH_DATE_FORMAT, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }

    fun getHourMinuteSeconds(day: Long): String {
        try {
            val cal = Calendar.getInstance()
            cal.timeInMillis = day
            val expectedDateFormat = SimpleDateFormat(
                HOUR_MINUTE_SECONDS, Locale.US
            )
            return expectedDateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }
    }


    fun getCurrentYear(): String {
        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(
            CURRNET_YEAR, Locale.US
        )
        return dateFormat.format(cal.time)

    }

    fun getYearFromString(fulldate: String): String {
        val cal = Calendar.getInstance()

        val dateFormat = SimpleDateFormat(FULL_DATE_FORMAT)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC");

        val date = dateFormat.parse(fulldate)

        cal.time = date


        return dateFormat.format(cal.get(Calendar.YEAR))

    }

    fun getExpReadable(expCal: Calendar): String {
        val dateFormat = SimpleDateFormat(
            EXP_READABLE, Locale.US
        )
        return dateFormat.format(expCal.time)
    }

    fun getExpServer(expCal: Calendar): String {
        val dateFormat = SimpleDateFormat(
            EXP_SERVER, Locale.US
        )
        return dateFormat.format(expCal.time)
    }

    fun getImageFileName(): String {
        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(
            IMG_FILE_NAME_FORMAT, Locale.US
        )
        return dateFormat.format(cal.time)
    }

    fun getDocumentMonthYear(createdDate: String?): String {
        try {
            createdDate?.let {
                val cal = Calendar.getInstance()
                // Date date = new Date();
                val dateFormat = SimpleDateFormat(
                    DOCUMENT_CREATE_DATE_FORMAT, Locale.US
                )
                val date = dateFormat.parse(it)
                cal.time = date
                val expectedDateFormat = SimpleDateFormat(
                    DOCUMENT_MONTHYEAR_FORMAT, Locale.US
                )
                return expectedDateFormat.format(cal.time)
            }
        } catch (e: ParseException) {
            return ""
        }
        return ""
    }

    fun parseFromCreatedDate(createdDate: String?): Long? {
        try {
            createdDate?.let {
                // Date date = new Date();
                val dateFormat = SimpleDateFormat(
                    FULL_DATE_FORMAT, Locale.US
                )
                val date = dateFormat.parse(it)
                return date?.time
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    fun calendarFromBirthData(birthDate: String): Calendar {
        val cal = Calendar.getInstance()
        try {
            // Date date = new Date();
            val dateFormat = SimpleDateFormat(
                FULL_DATE_FORMAT
            )
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");
            val date = dateFormat.parse(birthDate)
            cal.time = date
            return cal
        } catch (e: ParseException) {
            e.printStackTrace()
            return cal
        }

    }

    fun calendarFromString(birthDate: String): Calendar {
        val cal = Calendar.getInstance()
        try {
//            Date date = new Date();
            val dateFormat = SimpleDateFormat(FULL_CAL_FORMAT, Locale.US)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");
            val date = dateFormat.parse(birthDate)
            cal.time = date
            cal.timeZone = TimeZone.getTimeZone("UTC")
            return cal
        } catch (e: ParseException) {
            e.printStackTrace()
            return cal
        }
    }

    fun calendarFromFullFormat(birthDate: String): Calendar {
        val cal = Calendar.getInstance()
        try {
//            Date date = new Date();
            val dateFormat = SimpleDateFormat(FULL_DATE_FORMAT, Locale.US)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");
            val date = dateFormat.parse(birthDate)
            cal.time = date
            cal.timeZone = TimeZone.getTimeZone("UTC")
            return cal
        } catch (e: ParseException) {
            e.printStackTrace()
            return cal
        }

    }


    //Feb 10,2020
    fun getDateFromCreatedDateString(createdDate: String?): Date? {
        createdDate?.let {
            try {
                val dateFormat = SimpleDateFormat(
                    EXPENSE_DATA_FORMAT, Locale.US
                )
                return dateFormat.parse(it)
            } catch (exp: ParseException) {
                exp.printStackTrace()
                return null
            }
        }
        return null
    }


    fun getTodayTimeInMillis(hour: Int, minute: Int, second: Int): Long {
        val calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = hour
        calendar[Calendar.MINUTE] = minute
        calendar[Calendar.SECOND] = second
        return calendar.timeInMillis
    }

    fun getHourFromTimeInMills(time: Long): Int {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = time
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

    fun getFrequencyMillis(frequencyPosition: Int): Long {
        var timeInMillis: Long = 0
        when (frequencyPosition) {
            0 -> timeInMillis = TimeUnit.HOURS.toMillis(1)
            1 -> timeInMillis = TimeUnit.HOURS.toMillis(2)
            2 -> timeInMillis = TimeUnit.HOURS.toMillis(4) + TimeUnit.MINUTES.toMillis(30)
            3 -> timeInMillis = TimeUnit.HOURS.toMillis(6)

        }
        return timeInMillis
    }

    fun getCalendarFromTZ(dateString: String?): Calendar? {
        dateString?.let {
            val dateFormat = SimpleDateFormat(
                FULL_DATE_FORMAT, Locale.US
            )
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");
            val date = dateFormat.parse(it)
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar
        }
        return null

    }

    fun getGraphXAxisDate(dateTime: String?): String {
        val calendar = getCalendarFromTZ(dateTime)
        calendar?.let {
            val expectedDateFormat = SimpleDateFormat(
                GRAPH_XAXIS, Locale.US
            )
            return expectedDateFormat.format(calendar.time)
        }
        return "NA"
    }

    fun getRange(startCal: Calendar, endCal: Calendar): String {
        val startDateFormat = SimpleDateFormat(
            ONLY_DATE, Locale.US
        )
        startDateFormat.timeZone = TimeZone.getTimeZone("UTC");
        val startString = startDateFormat.format(startCal.time)

        val endDateFormat = SimpleDateFormat(
            GRAPH_DATE_YEAR, Locale.US
        )
        val endString = endDateFormat.format(endCal.time)
        return "${startString} - ${endString}"
    }

    fun getGraphDate(cal: Calendar): String {

        val endDateFormat = SimpleDateFormat(
            GRAPH_DATE_YEAR, Locale.US
        )
        val endString = endDateFormat.format(cal.time)

        return endString
    }

    fun getMonthFromCal(cal: Calendar): String {
        val startDateFormat = SimpleDateFormat(
            ONLY_MONTH, Locale.US
        )
        val startString = startDateFormat.format(cal.time)

        return startString
    }

    fun getDateAlone(dateTime: String?): Int {
        val cal = getCalendarFromTZ(dateTime)
        cal?.let {
            val dateFormat = SimpleDateFormat(
                ONLY_DATE, Locale.US
            )
            dateFormat.timeZone = TimeZone.getTimeZone("UTC");
            return dateFormat.format(cal.time).toIntOrNull() ?: 0
        }
        return 0
    }

    fun getDayNameAndDate(cal: Calendar): String {
        val dateFormat = SimpleDateFormat(
            DAY_NAME_AND_DATE, Locale.US
        )
        dateFormat.timeZone = TimeZone.getTimeZone("UTC");
        return dateFormat.format(cal.time)
    }

    fun validateCardExpiryDate(expiryDate: String): Boolean {
        return expiryDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}".toRegex())
    }


    fun validateCardExpiredorNot(expiryDate: String): Boolean {

        val creditCardFormat = SimpleDateFormat(CREDIT_CARD_DATE_FORMAT, Locale.getDefault())
        val converttoDate = creditCardFormat.parse(expiryDate)
        val validate = converttoDate.before(getCurrentMonthandYear())

        return validate
    }

    fun stringToDate(s: String?): Date {
        val sdf = SimpleDateFormat("mm-yy", Locale.getDefault())
        val convertDate = sdf.parse(s)
        return convertDate
    }

    fun getCurrentMonthandYear(): Date {
        val sdf = SimpleDateFormat(CREDIT_CARD_DATE_FORMAT, Locale.getDefault())
        val date = Date()
        val currentMonthandYear = sdf.format(date)
        val convertDate = sdf.parse(currentMonthandYear)
        return convertDate
    }
    fun getAge(bornDate:String, diedDate:String): Int {
        var bornDate1: Date? = null
        var diedDate1: Date? = null
        val inputFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH)
        val date: LocalDate = LocalDate.parse(bornDate, inputFormatter)
        val formattedDate = outputFormatter.format(date)
      val date1: LocalDate = LocalDate.parse(diedDate, inputFormatter)
        val formattedDate1 = outputFormatter.format(date1)

       /* val sdf = SimpleDateFormat("dd/MM/yyyy")
         bornDate1 = sdf.parse(formattedDate)
        diedDate1 = sdf.parse(formattedDate1)*/
      /*  try {
            bornDate1 = sdf.parse(bornDate)
            diedDate1 = sdf.parse(diedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
*/
        if (date == null) return 0

       /* val dob = Calendar.getInstance()
        val dod = Calendar.getInstance()

        dob.time = date
        dod.time = date1

        val year = dob[Calendar.YEAR]
        val month = dob[Calendar.MONTH]
        val day = dob[Calendar.DAY_OF_MONTH]

        dob[year, month + 1] = day

        var age = dod[Calendar.YEAR] - dob[Calendar.YEAR]

        if (dod[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }



        return age*/

        return Period.between(
            date,
            date1
        ).years
    }
}