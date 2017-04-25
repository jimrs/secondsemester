/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv.network;

import java.io.*;
import java.net.*;

/**
 *
 * @author maresj29
 */
public class Main {

    public static final String IMAGE_URL = "http://www.japan-guide.com/thumb/XYZeXYZe3009_375.jpg";
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL(IMAGE_URL);
        InputStream imageInputStream = url.openStream();
        FileOutputStream fileOutputStream = new FileOutputStream("img.jpg");
        
        int bytesRead;
        byte[] buffer = new byte[1024];
        while( (bytesRead = imageInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);   // zapsat do souboru pole buffer od pozice 0 do bytesRead
        }
        
        imageInputStream.close();
        fileOutputStream.close();
    }
    
}
