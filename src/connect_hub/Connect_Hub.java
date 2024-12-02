/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect_hub;

import connect_hub.ContentCreation.*;
import java.util.Map;

/**
 *
 * @author bibos_bz87qw5
 */
public class Connect_Hub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PostDatabase postDatabase = new PostDatabase("C:\\Users\\bibos_bz87qw5\\OneDrive\\Desktop\\Connect_Hub\\posts.json");


        Post post3 = new Post("author8", "Second post caption", "path/to/photo2.jpg");

        postDatabase.addOrUpdateContent(post3.getId(), post3);

        // Save content to the file
        //postDatabase.saveContent();

        // Confirm that the posts were added and saved
        System.out.println("Finished adding and saving posts. Check posts.json file.");
        
    }
}

    
    
