package common;

import java.io.File;
import java.io.FileFilter;

public class LuceneFileFilter implements FileFilter {

	@Override
	   public boolean accept(File pathname) {
	      return pathname.getName().toLowerCase().endsWith(".json");
		//return true; // :)
	}
}
