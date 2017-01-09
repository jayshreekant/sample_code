package generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil 
{
	public String getPropValue(String fname,String key) 
	{
		Properties prop = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream(fname);
		
		if(is!=null)
		{
			try {
				prop.load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				throw new FileNotFoundException("Property file ->" + fname+"Not found in the classpath");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String val = prop.getProperty(key);		
		return val;		
	}

}
