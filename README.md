HW2: Due Monday Sept 25
Using the code from class as a starting point (https://github.com/profyoni/152-FA2017-DependencyInjection1) 
Create a new gmail account (do not use your current account)
Write a program (class ClockMailer) that sends an email to you (at your regular email) when the clock strikes midnight
Inject into your ClockMailer two objects: one object implements IClock and another which implements IMailer as follows
Interface IClock { LocalDateTime now()}
Interface IMailer {void sendMail(String to, String subject; String message)
