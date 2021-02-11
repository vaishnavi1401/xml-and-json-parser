import java.io.*;
import java.util.*;
public class Parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FileReader fin = null;
		FileWriter fout = null;
		XML x;
		Scanner f;
		String fname, file, text, wd = "", tag, content;
		int ch, k = 0;
		char c;
		System.out.println("Enter the File Name (without .xml)");
		fname = sc.next();
		file = "C:\\Users\\Desktop" + fname + ".xml";
		text = "C:\\Users\\Desktop" + fname + ".txt";
		System.out.println("XML FILE PARSED SUCCESSFULLY !");
		try {
			fin = new FileReader(file);
			fout = new FileWriter(text);
			f = new Scanner(fin);
			f.useDelimiter("\n");
			while(f.hasNext()) {
				wd = f.next();
				
				
				x = new XML();
				tag = x.XMLTag(wd);
				
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
				content = x.XMLContent(wd);
				System.out.println(content);
				
				fout.write(content);
				fout.write("\r\n");
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
					System.out.println(fname + ".txt FILE CREATED SUCCESSFULLY");
					fout.close();	
				}
			}
			catch(IOException e) {
				System.out.println("Unable to Close File" + e);
			}
		}
	}

}
