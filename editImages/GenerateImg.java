package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GenerateImg {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java -jar generate_img.jar <input_file_name> <output_file_name> <width> <height>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];
        int scaledWidth = Integer.parseInt(args[2]);
        int scaledHeight = Integer.parseInt(args[3]);

        if (inputFileName.length() > 0) {
            try {
                Image src = ImageIO.read(new File(inputFileName));
                BufferedImage bufferedImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
                bufferedImage.getGraphics().drawImage(src, 0, 0, scaledWidth, scaledHeight, null);

                File outputfile = new File(outputFileName);
                String[] strTokenArray = outputFileName.split(".");
                String fileExtension = strTokenArray.length > 0 ? strTokenArray[strTokenArray.length - 1] : "png";
                ImageIO.write(bufferedImage, fileExtension, outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
