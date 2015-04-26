
import java.io.File;
import java.io.PrintWriter;

public class WikipediaFileExtractor {

	private StringBuilder fileNames;
	
	public static void main(String[] args) {

		WikipediaFileExtractor obj = new WikipediaFileExtractor();
		
		File file = new File("wiki-small");
		obj.fileNames = new StringBuilder();

        File[] files = file.listFiles();
        obj.extractedFileNames(files);
		
		try {
	    	File extractedFileNames = new File("fileNames.out");
			extractedFileNames.createNewFile();
			PrintWriter out = new PrintWriter(extractedFileNames);
			out.print(obj.fileNames);
			out.flush();
			out.close();
		}
		catch(Exception exception) {
			System.out.println("Exception in main");
		}        

	}
	
	private void extractedFileNames(File[] directory) {
		
		for(int i = 0; i < directory.length; i++) {
			
			if(directory[i].isFile()) {
				fileNames.append(directory[i].toString());
			    fileNames.append("\n");
			}
			else {
				File[] temp = directory[i].listFiles();
				extractedFileNames(temp);
			}
			
		}
		
	}

}
