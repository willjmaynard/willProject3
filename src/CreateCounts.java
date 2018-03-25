

public class CreateCounts {
	
	public String[] counts = new String[4];
	
	public CreateCounts() {}
	
	public String create(Crypto c) {
		counts[0] = " \"fields=" + c.count + "\",";
		counts[1] = " \"loss/gain=" + loss(c) + "\",";
		counts[2] = " \"longest=" + hour24(c) + "\",";
		counts[3] = " \"length=" + longest(c) + "\",";
		return counts[0] + counts[1] + counts[2] + counts[3];
	}
	
	public String longest(Crypto c) {
		int length = 0;
		for(int i = 0; i < c.count-1; i++) {
			if(c.fields[i].value.replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", "").length() > length) {
				length = c.fields[i].value.replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", "").length();
			}
		}
		return ""+length;
	}
	
	public String hour24(Crypto c) {
		
		for(int i = 0; i < c.count; i++) {
			if(c.fields[i].name.contains("percent_change_24h")) {
				return c.fields[i].value.replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", "").toString();
			}
		}
		return null;
		
	}
	
	public String loss(Crypto c) {
		double usd=0;
		double day7=0;
		
		for(int i = 0; i < c.count; i++) {
			if(c.fields[i].name.contains("price_usd")) {
				usd = Double.parseDouble(c.fields[i].value.replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", ""));
			} else if(c.fields[i].name.contains("percent_change_7d")) {
				day7 = Double.parseDouble(c.fields[i].value.replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", ""));
			}
			
		}
		if (day7>0) {
			return Double.toString((usd + ((day7/100.0) * usd)));
		}else {
			return Double.toString((usd - ((day7/100.0) * usd))) ;
		}
		
	}
	
}
