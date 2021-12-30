import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class SiteNameRunner
{
	public static void main ( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("sitename.dat"));

		int size = file.nextInt();
		file.nextLine();
		SiteName[] siteNames = new SiteName[size];
		for (int i = 0; i < size; i++) {
		    SiteName s = new SiteName(file.nextLine());
			siteNames[i] = s;
		}
		Arrays.sort(siteNames, new Comparator<SiteName>() {
			@Override
			public int compare(SiteName site, SiteName t1) {
				return site.compareTo(t1);
			}
		});
		for (SiteName p: siteNames) {
			out.println(p);
		}
	}
}
