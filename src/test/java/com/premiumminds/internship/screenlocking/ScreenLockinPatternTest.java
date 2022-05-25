package com.premiumminds.internship.screenlocking;

import com.premiumminds.internship.screenlocking.exceptions.ErrorMessage;
import com.premiumminds.internship.screenlocking.exceptions.ScreenLockinException;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2022.
 */
@RunWith(JUnit4.class)
public class ScreenLockinPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public ScreenLockinPatternTest() {
  };

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();


  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()  throws InterruptedException, ExecutionException, TimeoutException {
    Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(3, 2);
    Integer result = count.get(10, TimeUnit.SECONDS);
    assertEquals(result.intValue(), 5);
  }

  @Test
  public void ScreenLockinPatternTestPointOutOfRange() throws InterruptedException, ExecutionException, TimeoutException {
    expectedEx.expect(ScreenLockinException.class);
    expectedEx.expectMessage(ErrorMessage.SCREEN_POINT_OUT_OF_RANGE.label);
    // TODO -> Can we do multiple numbers like in Spock?
    Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(0, 2);
    Integer result = count.get(1, TimeUnit.SECONDS);

    // Check Exception Message
  }

  @Test
  public void ScreenLockinPatternTestInvalidLength() throws InterruptedException, ExecutionException, TimeoutException {
    expectedEx.expect(ScreenLockinException.class);
    expectedEx.expectMessage(ErrorMessage.INVALID_PATTERN_LENGTH.label);
    // TODO -> Can we do multiple numbers like in Spock?
    Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(1, 0);
    Integer result = count.get(1, TimeUnit.SECONDS);

    // Check Exception Message
  }

  @Test
  public void ScreenLockinPatternTestFirst1Length5Test() throws InterruptedException, ExecutionException, TimeoutException {
    Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(1, 5);
    Integer result = count.get(10, TimeUnit.SECONDS);
    assertEquals(result.intValue(), 8,776); // Used "https://github.com/delight-im/AndroidPatternLock"
  }
}