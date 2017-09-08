package org.yqian.HelloWorldWebScheduler;
import java.io.IOException;import java.io.InputStream;
import org.springframework.beans.factory.annotation.Value;import org.springframework.context.annotation.Configuration;import org.springframework.context.annotation.PropertySource;import org.springframework.scheduling.annotation.EnableScheduling;import org.springframework.scheduling.annotation.Scheduled;
@Configuration@PropertySource("classpath:cfg/command.properties")@EnableSchedulingpublic class HelloWorldScheduler {
@Value("${command}")private String command;
@Scheduled(cron = "*/10 * * * * *")public void executeCommand() {System.out.println("The command is " + this.command);try {final Process p = Runtime.getRuntime().exec("cmd /c " + this.command);final InputStream inStream = p.getInputStream();int c;while((c = inStream.read()) != -1) {System.out.print((char) c);}
System.out.println("Command run");} catch (IOException e) { } }}
