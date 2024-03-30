package org.example;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenCaptureUtility {

     public void takePageScreenshot(WebDriver driver,String name)
     {
         Screenshot screen = new AShot().takeScreenshot(driver);
         BufferedImage bi = screen.getImage();

         File file = new File(System.getProperty("user.dir")+"\\src\\images\\screenshots\\"+name+".png");

         try{
             ImageIO.write(bi,"png",file);
         }
         catch(IOException e){
             e.printStackTrace();
         }
     }

}
