package game;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {
	static ResourceBundle strings;
	public static String getString(String keyword)
	{
		
		//If not previous set, use default locale(da, DK)
		if(strings==null)
		{
			setLocale(new Locale("da", "DK"));
		}
		return strings.getString(keyword);
	}
	public static void setLocale(Locale l)
	{	
		strings = ResourceBundle.getBundle("MessageBundle", l);
	}
	//Avoids creating objects of this class
	private Translator()
	{
		
	}
}
