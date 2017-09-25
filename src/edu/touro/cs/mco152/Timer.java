package edu.touro.cs.mco152;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

interface IMailer{
    public void sendMail(String to, String subject, String msg);
}

class Mailer implements IMailer{

    @Override
    public void sendMail(String to, String subject, String msg) {
//TODO
    }
}

interface IClock{
    LocalDateTime now();
}

class Clock implements IClock{ // Design Pattern Adapter
    public LocalDateTime now(){
        return LocalDateTime.now(); // example of a Factory method design patern
    }
}

class ClockMailer
{
    private IMailer mailer;
    private IClock clock;
    ClockMailer(IMailer mailer, IClock clock ){
        this.clock = clock;
        this.mailer = mailer;
    }

    public void start(){
        while (true){
            if (clock.now().equals(LocalDateTime.of(LocalDate.now(),LocalTime.MIDNIGHT)))           {
mailer.sendMail(null,null,null);
            }

        }
    }
}

public class Timer {

    public Timer(ElapsedTimeClockI etc){ // c-tor dependency injection Timer is dependent on ElapsedTimeClockI
        clock = etc;
    }
    private long startMs;
    private long stopMs;
    private boolean isRunning;
    private ElapsedTimeClockI clock;

    public void start() {
        isRunning = true;
        startMs = clock.currentTimeMillis();
    }

    public void stop() {
        if (! isRunning)
            throw new IllegalStateException("Stop can only be called when timer is running");
        isRunning = false;
        stopMs = clock.currentTimeMillis();
    }

    public void reset() {
        startMs = clock.currentTimeMillis();
    }

    public long getElapsedTime() {
        return (! isRunning ? stopMs : clock.currentTimeMillis()) - startMs;
    }
}
