package myjavaproject;

public class Data {

	private String country;
	private String platform;

	public Data(String country, String platform) {
		this.country = country;
		this.platform = platform;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getplatform() {
		return platform;
	}

	public void setplatform(String platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return String.format("%s       %s", country, platform);
	}
}
