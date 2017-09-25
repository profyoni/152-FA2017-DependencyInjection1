package edu.touro.cs.mco152;

interface ElapsedTimeClockI{
    long currentTimeMillis();
}

class NIST_ElapsedTimeClock implements ElapsedTimeClockI{
    @Override
    public long currentTimeMillis() {
        return 0; // TODO connect to NIST server and pull the time
    }
}

class ElapsedTimeClock implements ElapsedTimeClockI{
    public long currentTimeMillis(){
        return System.currentTimeMillis();
    }
}
class ElapsedTimeClock2 implements ElapsedTimeClockI{
    public long currentTimeMillis(){
        return System.nanoTime() / 1_000_000;
    }
}

public class Main{        }

