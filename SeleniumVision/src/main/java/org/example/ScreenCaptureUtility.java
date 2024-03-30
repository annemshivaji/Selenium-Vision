package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;


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

    public void takeElementScreenshot(WebDriver driver,String name, WebElement element)
    {
        Screenshot screen = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
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
