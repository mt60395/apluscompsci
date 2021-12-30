class SiteName implements ComparableSite<SiteName>
{
	//add instance variables
    private String site;
    private String category;

	//add a constructor
    public SiteName(String full) {
        site = full.split("\\.")[0];
        category = full.split("\\.")[1];
    }

	//add a compareTo
    public int compareTo(SiteName other) {
        String[] split = other.toString().split("\\.");
        String otherSite = split[0];
        String otherCategory = split[1];
        int c = category.compareTo(otherCategory);
        if (c == 0) {
            return site.compareTo(otherSite);
        }
        return c;
    }

	//add a toString
    public String toString() {
        return String.format("%s.%s", site, category);
    }
}
