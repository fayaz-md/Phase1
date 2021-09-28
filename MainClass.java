import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
class FilesOperation {
	String folder;;
	Scanner sc;
	FilesOperation()
	{
		folder="C:\\Users\\Dell\\Desktop\\My repsoitory";
		sc=new Scanner(System.in);
	}
	public void welcome() {
		
		System.out.println("Virtual Key for Your Repositories");
		System.out.println("--------Developer Details---------");
		System.out.println("Name : Mohammed Fayaz");
	}
	public void retrieveFiles()
	{
		String fileNames[];
		File file=new File(folder);  
		fileNames=file.list();
		for(String name:fileNames)
		{
			File file1=new File(folder+"\\"+name);
			if(!file1.isDirectory())
			System.out.println(name);
		}
	}
	public void searchFile()
	{
		System.out.println("Enter the file name");
		String fileName=sc.next();
		File file=new File(folder+"\\"+fileName);
		if(file.exists())
		{
			System.out.println("File exist.....");
		}
		else {
			System.out.println("File doesn't exist");
		}
	}
	public void addFile()
	{
		System.out.println("Enter the file name");
		String fileName=sc.next();
		try {
		File file=new File(folder);
		File file1=new File(folder+"\\"+fileName);
		if(file1.exists())
		{
			System.out.println("File already exists");
		}
		else {
		FileOutputStream fos=new FileOutputStream(file+"\\"+fileName);
		fos.close();
		System.out.println("File added successfully....");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void deleteFile()
	{
		String name;
		System.out.println("Enter the file to be deleted ");
		name=sc.next();
		File file=new File(folder+"\\"+name);
		if(file.exists())
		{
			file.delete();
			System.out.println("File deleted successfully......");
		}
		else {
			System.out.println("File doesn't exist");
		}
	}
	
}
public class MainClass
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch;
		Scanner sc=new Scanner(System.in);
		FilesOperation fop=new FilesOperation();
		fop.welcome();
		do {
			
			System.out.println("1. Retrieve files in Ascending Order\n2.Business Level Operation");
			System.out.println("3.Exit\nEnter your choice");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1: fop.retrieveFiles();
						break;
				case 2: 
					int ch1;
					do {
						System.out.println("1. Add a File");
						System.out.println("2. Delete a File");
						System.out.println("3. Search a File");
						System.out.println("4. Go back to Main Menu");
						System.out.println("Please select ");
						ch1=sc.nextInt();
						switch(ch1)
						{
							case 1: fop.addFile(); 
								break;
							case 2:
									fop.deleteFile();
								break;
							case 3: fop.searchFile();
								break;
							case 4:
								break;
							default: System.out.println("Please select valid option");
						}
					}while(ch1!=4);
						break;
				case 3:
					System.out.println("-----------Thank You------------");
					System.exit(0);
				default: System.out.println("Please select valid option");
			}
		}while(ch!=3);
	}
}