/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduletests;

import java.io.File;

/**
 *
 * @author smitj
 */
public class RemoveDirectory {
    
    public static void main(String[] args) {
        // store file path
        String filepath = "D:\\LEARNING\\COLLAGE\\SAM6\\PROJECT\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\MyECommerce\\img\\shop\\products\\1";
        File file = new File(filepath);

        // call deleteDirectory function to delete
        // subdirectory and files
        RemoveDirectory r = new RemoveDirectory();
        r.deleteDirectory(file);

        // delete main GFG folder
        file.delete();
        
    }
    
    public void deleteDirectory(File file) {
        // store all the paths of files and folders present
        // inside directory
        for (File subfile : file.listFiles()) {
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }
            // delete files and empty subfolders
            subfile.delete();
        }
    }
    
}
