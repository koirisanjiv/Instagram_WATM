package com.instagram.utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.instagram.testCases.BaseClass;

public class FindFileAndRename {
	// TAKE ACTION ON THE DOWNLOAD FILES
	public Logger logger = LogManager.getLogger(this.getClass());
	
	public void actionOnDownloadedFiles(String newfileName) {
			StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
			String callerMethodName = stackTrace[2].getMethodName();
			logger.info("Caller methods name: " + callerMethodName);
			
			// Now, visit and rename the most recently downloaded file
	        File folder = new File(BaseClass.fileLocation);
	        File[] listOfFiles = folder.listFiles();

	        if (listOfFiles != null && listOfFiles.length > 0) {
	            // Sort files by last modified date in descending order (latest file first)
	            Arrays.sort(listOfFiles, Comparator.comparingLong(File::lastModified).reversed());

	            // Get the latest file
	            File latestFile = listOfFiles[0];

	            // Print the latest file name for debugging
	            logger.info("Latest downloaded file: " + latestFile.getName());

	            // Rename the latest file
	            File renamedFile = new File(BaseClass.fileLocation + "/"+newfileName);
//	            if (latestFile.renameTo(renamedFile)) {
//	                System.out.println("File renamed successfully");
//	            } else {
//	                System.out.println("Failed to rename the file");
//	            }
	            
	            try {
	                // Use Files.move to rename the file
	                Files.move(latestFile.toPath(), renamedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	                System.out.println("File renamed successfully to: " + renamedFile.getName());
	            } catch (Exception e) {
	                logger.warn("Failed to rename the file: " + e.getMessage());
	                e.printStackTrace();
	            }
	            
	        } else {
	            System.out.println("No files found in the download directory");
	        }
}
}