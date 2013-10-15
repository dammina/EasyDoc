package org.eclipse.recommenders.extdoclogin.views;


import java.io.File;
import java.util.LinkedList;

/**
 * Contains some methods to list files and folders from a directory
 *
 * @author Dammina Sahabandu
 */
public class ListFilesUtil {
	public static LinkedList<String> filelist=new LinkedList<>();
	public static String files="";

	/**
	 * List all the files and folders from a directory
	 * @param directoryName to be listed
	 */
	public void listFilesAndFolders(String directoryName){

		File directory = new File(directoryName);

		//get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList){
			System.out.println(file.getName());
		}
	}

	/**
	 * List all the files under a directory
	 * @param directoryName to be listed
	 */
	public void listFiles(String directoryName){

		File directory = new File(directoryName);

		//get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList){
			if (file.isFile()){
				System.out.println(file.getName());
			}
		}
	}

	/**
	 * List all the folder under a directory
	 * @param directoryName to be listed
	 */
	public void listFolders(String directoryName){

		File directory = new File(directoryName);

		//get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList){
			if (file.isDirectory()){
				System.out.println(file.getName());
			}
		}
	}

	/**
	 * List all files from a directory and its subdirectories
	 * @param directoryName to be listed
	 */
	public void listFilesAndFilesSubDirectories(String directoryName){

		File directory = new File(directoryName);

		//get all the files from a directory
		File[] fList = directory.listFiles();

		for (File file : fList){
			if (file.isFile()){
//				System.out.println(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("/")+1));
				String ftype=file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")+1);
				if(ftype.equalsIgnoreCase("java") || ftype.equalsIgnoreCase("mf") || ftype.equalsIgnoreCase("xml")){
					filelist.add(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("/")+1));
					files+=(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("/")+1));
					files+=("\n");
				}
			} else if (file.isDirectory()){
				listFilesAndFilesSubDirectories(file.getAbsolutePath());
			}
		}
	}

	public void runmeth (String directory){

		ListFilesUtil listFilesUtil = new ListFilesUtil();

//		final String directoryLinuxMac ="/Users/loiane/test";

		//Windows directory example
		final String directoryWindows =directory;

		listFilesUtil.listFilesAndFilesSubDirectories(directoryWindows);
	}
}
