package de.dixi.app;


import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    void test01(){
        String s = StringUtils.leftPad("4", 3, "0");
        System.out.println(s);
    }


}
