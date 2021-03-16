package GerateSoftBuild;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class Tools {

	public static final String legalExt = ".php";
	
	public static final String saveCodePath = "/Users/pengtao/eclipse-workspace/GerateSoftBuild/output/php_source_code.docx";


	/**
	 * 扫描目录
	 */
    public static HashMap<Integer, String> scan(File appPath) {
		File[] muList = appPath.listFiles();
		Integer key = 0;
		HashMap<Integer, String> result = new HashMap<>();
		for (File f : muList) {
			if (f.isDirectory()) {
				return scan(f);
			} else {
				if (isLegal(f)) {
					result.put(key, f.getAbsolutePath());
					key++;
				}
			}
		}
		return result;
    }


	private static boolean isLegal(File file) {
		String name = file.getName();
		int lastIndexOf = name.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return false;
		}
		String ext = name.substring(lastIndexOf);
		return legalExt.equals(ext);
	}



	public static Scanner readCode(String filePath) {
		File codeFile = new File(filePath);
		Scanner codeScanner = null;
		try {
		    codeScanner = new Scanner(codeFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return codeScanner;
	}


	public static void putCode () {
		try {
			WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
	
			MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
	
			mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
	
			mainDocumentPart.addParagraphOfText("Welcome To Baeldung");

			wordPackage.save(new File(saveCodePath));
		} catch (Docx4JException e) {
			e.printStackTrace();
		}
	}



	/**
	 * 日志输出
	 */
    public static void msg(String var, int action) {
        switch(action) {
            case 1:
                System.out.println("Scaning App File......: "+var); 
                break;
            case 2:
                System.out.println("File Path...: "+var); 
                break;
			case 3:
                System.out.println("File Line: "+var); 
                break;
            default:
                System.out.println("Log: "+var); 
        };
    }	
}
