package main.java.cdi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilBusinessImpl implements UtilBusiness{

	@Override
	public  String convertInputStreamToString(InputStream input) throws IOException {
        if (input != null) {
            final char[] buffer = new char[1024];
            final Writer writer = new StringWriter();
            try {
                int n;
                final Reader reader = new BufferedReader(new InputStreamReader(input,"UTF-8"));
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                input.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }

	@Override
	public boolean hasLetter(String text) {
		 String patternString = ".*[^0-9].*";
		 Pattern pattern = Pattern.compile(patternString);
		 Matcher matcher = pattern.matcher(text);
		 return matcher.matches();
	}

}
