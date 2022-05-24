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


  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()  throws InterruptedException, ExecutionException, TimeoutException {
    Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(3, 2);
    Integer result = count.get(10, TimeUnit.SECONDS);
    assertEquals(result.intValue(), 5);
  }

  @Test(expected=ScreenLockinException.class)
  public void ScreenLockinPatternTestPointOutOfRange() throws InterruptedException, ExecutionException, TimeoutException {
    // TODO -> Can we do multiple numbers like in Spock?
    try{
      Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(0, 2);
      Integer result = count.get(1, TimeUnit.SECONDS);
    } catch (ScreenLockinException e){
      assertEquals(e.getErrorMessage(), ErrorMessage.SCREEN_POINT_OUT_OF_RANGE);
    }
  }

  // TODO -> Test that throws error

  @Test
  public void ScreenLockinPatternTestFirst1Length5Test() throws InterruptedException, ExecutionException, TimeoutException {
    Future<Integer> count  = new ScreenLockinPattern().countPatternsFrom(1, 5);
    Integer result = count.get(10, TimeUnit.SECONDS);
    assertEquals(result.intValue(), 8,776); // Used "https://github.com/delight-im/AndroidPatternLock"
  }
}