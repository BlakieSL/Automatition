package src;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import java.io.IOException;
import java.time.LocalTime;
import org.sikuli.script.Pattern;

public class AutoLogic {
    public void execute(){
        ImagePath.add("C:\\GitProjects\\AutomatitionDemo\\AutomatitionProject\\imgs");
        LocalTime time = LocalTime.now();
        try {
            openClass("Test.png");
            /*
            if(time.isAfter(LocalTime.of(10,22))
                    && time.isBefore(LocalTime.of(10,25))){
                openClass("NAI.png");
            } else if(time.isAfter(LocalTime.of(14,7))
                        && time.isBefore(LocalTime.of(14,10))){
                openClass("MUL.png");
            } else if(time.isAfter(LocalTime.of(15,52))
                        && time.isBefore(LocalTime.of(15,55))){
                openClass("PRI.png");
            } else if(time.isAfter(LocalTime.of(17,37))
                        && time.isBefore(LocalTime.of(17,40))){
                openClass("APBD.png");
            }
            else{
                openClass("Test.png");
            }

             */
        } catch (FindFailed | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void openClass(String imgPath) throws FindFailed, InterruptedException {
        Screen s = new Screen();
        App.open("C:\\Users\\user\\AppData\\Local\\Microsoft\\Teams\\current\\Teams.exe");
        Thread.sleep(3000);
        Pattern fullScreenButton = new Pattern("FullScreen.png").similar(0.8f);
        if (s.exists(fullScreenButton, 3) != null) {
            System.out.println("Window is not fullscreen");
            s.click(fullScreenButton);
            Thread.sleep(1000);
        } else {
            System.out.println("Window is full-size");
        }

        try {
            s.click(new Pattern("HOME.png").similar(0.8f));
            s.click(new Pattern("HOME.png").similar(0.8f));
        }
        catch (FindFailed e) {
            s.click(new Pattern("HOME2.png").similar(0.8f));
            s.click(new Pattern("HOME2.png").similar(0.8f));
        }

        Thread.sleep(1000);

        s.click(imgPath);
        s.click("Connect.png");
        Thread.sleep(1000);
        s.click("Mute.png");
        Thread.sleep(1000);
        s.click("ConnectNow.png");

        Thread.sleep((5000));

        s.click("Leave.png");
        try {
            s.wait("CloseWin.png", 5);
            s.click("CloseWin.png");
        } catch (FindFailed e) {
            System.out.println("Could not find the post-meeting close button.");
            e.printStackTrace();
        }
    }
}