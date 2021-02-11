package miniProject;
import java.util.*;
import java.io.*;
public class XMLParser {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FileReader fin = null;
		FileWriter fout = null;
		XMLString x;
		Scanner f;
		String fname, fpath, tpath, wd = "", tag, content;
		int ch, k = 0, n = 0 ;
		char c;
		System.out.println("Enter the File Name (without .xml)");
		fname = sc.next();
		fpath = "C:\\Users\\HP\\Desktop\\adobe interview projects\\XML JSON Parser (1)\\src\\miniProject\\" + fname + ".xml";
		System.out.println(fpath);
		tpath = "C:\\Users\\HP\\Desktop\\adobe interview projects\\XML JSON Parser (1)\\src\\miniProject\\" + fname + ".txt";
		System.out.println(tpath);
		System.out.print("Parsing " + fname + ".xml");
		while(n!=5) {
			System.out.print(" .");
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			n++;
		}
		System.out.println();
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(fname +".xml PARSED SUCCESSFULLY !");
		try {
			Thread.sleep(500);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(fname + ".txt FILE CREATED SUCCESSFULLY");
		System.out.println();
		try {
			fin = new FileReader(fpath);
			fout = new FileWriter(tpath);
			f = new Scanner(fin);
			f.useDelimiter("\n");
			while(f.hasNext()) {
				wd = f.next();
				
				
				x = new XMLString();
				tag = x.XMLtoTag(wd);
				
				for(int i=0; i<wd.length()-1; i++) {
					c = wd.charAt(i+1);
					if(wd.charAt(i) == '>') {
						if( !(Character.isLetter(c)) && !(Character.isDigit(c)) && !(x.isSpecialCharacter(c)) ) {
							k = 0;
							break;
						}
						else {
							k = 1;
							break;
						}
					}
				}
				
				if(tag != "") {
					if(k == 1) {
						System.out.print(tag + " : ");
						fout.write(tag + " : ");
					}
					else {
						System.out.print(tag);
						fout.write(tag);	
					}
				}
				content = x.XMLtoString(wd);
				System.out.println(content);
				
				fout.write(content);
				//Can use either for getting a newline
				//fout.write("\r\n");
				fout.write(System.lineSeparator());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(fname + ".xml File Not Found");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fin != null) {
					fin.close();
				}
					
				if(fout !=null) {
					fout.close();	
				}
			}
			catch(IOException e) {
				System.out.println("Unable to Close File" + e);
			}
		}
		
		
	}

}
