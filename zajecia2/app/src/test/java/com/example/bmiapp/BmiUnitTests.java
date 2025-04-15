package com.example.bmiapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.bmiapp.ui.bmi.BmiFragment;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BmiUnitTests {
    BmiFragment bmiFragment;

    @Before
    public void setUp() {
        bmiFragment = new BmiFragment();
    }
    @Test
    public void calculateBmi_result_displays_NIEDOWAGA_text() {
        assertEquals("This parameters should generate NIEDOWAGA text", "NIEDOWAGA", bmiFragment.calculateBMI(35, 1.75));
    }
    @Test
    public void calculateBmi_result_NOT_displays_NIEDOWAGA_text() {
        assertNotEquals("This parameters should NOT generate NIEDOWAGA text", "NIEDOWAGA", bmiFragment.calculateBMI(100, 1.75));
    }

}