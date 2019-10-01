package com.example.unittesting;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StringUtilsTest {
    public  StringUtils stringUtils;

    @Before
    public void setup(){
        stringUtils = new StringUtils();
    }

    @Test
    public void testIfConcatTwoStringsReturnsCorrect(){
        final String testS1 = "Hello";
        final String testS2 = "World";
        final String expectedResult = "Hello World";

        assertEquals(expectedResult, stringUtils.concatTwoStrings(testS1, testS2));
    }

    @Test
    public void TestIsStringProperLengthReturnTrue(){
        final String testStringLongerThenFour = "qwert";
        assertTrue(stringUtils.isStringProperLength(testStringLongerThenFour));
    }

    @Test
    public void TestIsStringProperLengthReturnFalse(){
        final String testStringLessThenFour = "qwe";
        assertFalse(stringUtils.isStringProperLength(testStringLessThenFour));
    }

    @Test
    public void testGetQueryUrlReturnsProperURL(){
        final String testSchema = "https";
        final String testBaseURL = "randomuser.me";
        final String testPath = "api";
        final String testQuery = "results";
        final String expectedResult = "https://randomuser.me/api/?results";
        URLUtils mockURLUtil = mock(URLUtils.class);
        Mockito.when(mockURLUtil.makeURL
                (testSchema, testBaseURL, testPath)).thenReturn("https://randomuser.me/api");
        stringUtils = new StringUtils(mockURLUtil);

        assertEquals(expectedResult,stringUtils.getQueryUrl(testQuery, testSchema, testBaseURL, testPath));
    }

    @Test
    public void testPrintURLToConsoleIfURLUtilRunsAtMostThreeTimes(){
        URLUtils mockURLUtil = mock(URLUtils.class);
        final int testTimesToRun = 3;
        final String testUrl = "test";
        stringUtils = new StringUtils(mockURLUtil);
        stringUtils.printURLToConsole(testUrl, testTimesToRun);
        verify(mockURLUtil, atMost(3)).displayURL(testUrl);
    }
}
