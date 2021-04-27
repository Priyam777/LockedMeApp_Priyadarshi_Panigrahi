package lockedmeapp;
import java.util.*;
import java.lang.*;
import java.io.*;

public class LockedMeApp {
	public static void main(String args[]) {
		//For displaying the menu details
		Menu.menuDetails();
		//For continuous user interaction till the user quits by pressing 5
		looper();
}
	
	//For displaying the list of files in ascending order
	public static void filesList() {
		//Setting the root directory
		String dirName="/Java";
		File f=null;
		try {
			f=new File(dirName);
			String listFiles[]=f.list();
			
			//To display the list of files in ascending order we use a TreeSet 
			//collection class which displays the results in ascending order
			//by default
			TreeSet<String> files=new TreeSet<String>();
			System.out.println("Existing list of files in Ascending order");
			for(int i=0;i<listFiles.length;i++) {
				files.add(listFiles[i]);
				System.out.println(listFiles[i]);
			}
			}catch(Exception e) {
			System.out.println(e);
		}
		}
	
	
	//To add a certain file provided by the user
	public static void fileAdd() {
		String fName;
		System.out.println("Enter the name of the file that you want to enter:");
		Scanner sc =new Scanner(System.in);
		fName=sc.nextLine();
		try {
			File f=new File(fName);
			if(!f.exists()) f.createNewFile();
			System.out.println("File added successfully");
		}catch(IOException e) {
			System.out.println(e);
		}
		
		}
	
	//To delete a file by user input
	public static void fileDelete() {
		String fName;
		System.out.println("Enter the name of the file that you want to delete:");
		Scanner sc =new Scanner(System.in);
		fName=sc.nextLine();
		File f1=null;
		boolean found=false;
		String fileToDelete;
		
		String dirName="/Java";
		try {
			
			f1=new File(dirName);
			String listFiles[]=f1.list();
			for(int i=0;i<listFiles.length;i++) {
				if(listFiles[i].toUpperCase().compareTo(fName.toUpperCase())==0) {
					fileToDelete=listFiles[i];
					File fDelete=new File(fileToDelete);
					fDelete.delete();
					System.out.println("File deleted successfully");
				    found =true;
					
				}else continue;
			}
			if(found==false)
			System.out.println("File doesn't exist");	
		}catch(Exception e) {
			System.out.println(e);
		}
		}
	
	
	//To search a file provided by user as input
		public static void fileSearch()	{
			String fName;
			System.out.println("Enter the name of the file that you want to search:");
			Scanner sc =new Scanner(System.in);
			fName=sc.nextLine();
			File f1=null;
			boolean found=false;
			String dirName="/Java";
			try {
				
				f1=new File(dirName);
				String listFiles[]=f1.list();
				for(int i=0;i<listFiles.length;i++) {
					
					if(listFiles[i].toUpperCase().compareTo(fName.toUpperCase())==0) {
						
						System.out.println("File exists");
					    found =true;
						
					}else continue;
				}
				if(found==false)
				System.out.println("File doesn't exist");	
				
			}catch(Exception e) {
				System.out.println(e);
			}
		
}
			
			
		
		//To display the menu and for continuous user interaction until user quits
		//the application by pressing 5
		public static void looper() {
			try {
			int choice;
			
			do {
				
			
				System.out.println("Please enter your choice:");
				
				Scanner sc =new Scanner(System.in);
				
				choice =sc.nextInt();
				switch(choice) {
				case 1:
					filesList();
				    break;
				case 2:
					fileAdd();
					break;
				case 3:
					fileDelete();
					break;
				case 4:
				    fileSearch();
				    break;
				case 5:
					System.out.println("exiting from application");
					System.exit(0);
					break;
				default:
				
					{System.out.println("Please enter a number between 1 to 4"
							+ " or 5 to quit the application");
					Menu.menuDetails();
					looper();
					return;
					}

		}
			
		}while(choice!=5);
}catch(Exception e) {
	System.out.println("Please enter a number between 1 to 4"
			+ " or 5 to quit the application");
	Menu.menuDetails();
	looper();
}
}
}
			
		
		
		
	
	
	

