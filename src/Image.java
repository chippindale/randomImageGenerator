import sun.jvm.hotspot.ui.SysPropsPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by admin on 05/07/2017.
 */
public class Image {
    public static void main (String[] args){
        BufferedImage image = new BufferedImage(100,100, BufferedImage.TYPE_INT_RGB);
        Color[] colors = generateColour(image.getHeight() * image.getWidth());
//        Arrays.sort(colors);
        bubbleSort(colors);
        for(int row = 0; row < image.getWidth(); row++){
            for (int column = 0; column < image.getHeight() ; column++){
                image.setRGB(row,column,colors[row*column].getRGB());
            }
        }
        File imageFile = new File("test.png");
        try {
            ImageIO.write(image,"png", imageFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static Color[] generateColour(int amount){
        Random rand = new Random();
        Color[] colors = new Color[amount];
        for(int i =0; i< amount; i++){
            colors[i] = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        }
        return colors;
    }

    public static void bubbleSort(Color[] inColors){
        Color temp = new Color(255,255,255);
        for(int i = 0; i < inColors.length; i++){
            for(int x = 0; x < inColors.length -1; x++){
                if (inColors[x].getRGB() > inColors[x+1].getRGB()){
                    temp = inColors[x];
                    inColors[x] = inColors[x+1];
                    inColors[x+1]=temp;
                }
            }
        }
    }

}
