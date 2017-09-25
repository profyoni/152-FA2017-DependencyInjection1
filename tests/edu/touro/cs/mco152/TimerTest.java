package edu.touro.cs.mco152;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.plugin.dom.exception.InvalidStateException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// imitation clock...pretends to behave like a clock
class MockClock implements ElapsedTimeClockI{

    MockClock(long ... vals){
        returnValues = vals;
    }
    private int counter = 0;
    private long returnValues[];

    @Override
    public long currentTimeMillis() {
        return returnValues[counter++];
    }
}

public class TimerTest {
    private Timer timer;
    @BeforeEach
    public void initEach(){
        ElapsedTimeClockI clock = new MockClock(13, 1016, -1);
        timer = new Timer( clock );
    }
    @Test
    void getElapsedTimeWhenStartStopShouldBeTimeInterval() {
        timer.start();
        timer.stop();

        assertEquals(1003, timer.getElapsedTime());
    }

    @Test
    void stopBeforeStartSHouldThrowInvalidStateException(){
        try{
            timer.stop();
            fail("No exception thrown");
        }
        catch(IllegalStateException ise){
        }
    }





}
