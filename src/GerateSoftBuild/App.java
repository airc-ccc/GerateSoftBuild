package GerateSoftBuild;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class App {

  private static String app_path = "/Users/pengtao/Works/3cloo_api/app";

	public static void main(String[] args) {
		/**Tools.msg(app_path, 1);
        File appPath = new File(app_path); 
		HashMap<Integer, String> fileList = Tools.scan(appPath);		
		for (int i : fileList.keySet()) {
			String filePath = fileList.get(i);
			Scanner codeScanner = Tools.readCode(filePath);
			while(codeScanner.hasNextLine()) {
				String line = codeScanner.nextLine();
				Tools.msg(line, 0);
				break;
			}
			break;
		}**/

		Tools.putCode();

		Tools.msg("fuck yes.", 0);
	}
}
