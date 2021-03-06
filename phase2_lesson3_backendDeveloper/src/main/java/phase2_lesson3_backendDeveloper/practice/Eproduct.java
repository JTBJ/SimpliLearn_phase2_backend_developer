package phase2_lesson3_backendDeveloper.practice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Eproduct {

	private long id;
	private String name;
	private BigDecimal price;
	private Date dateAdded;
	private List<Color> colors;
	private Collection<ScreenSize> screenSizes;
	private Set<OS> os;
	private Map<?, ?> finance;
	
	public Eproduct() {
	}

	public Eproduct(String name, BigDecimal price, Date dateAdded, List<Color> colors,
			Collection<ScreenSize> screenSizes, Set<OS> os, Map<?, ?> finance) {
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
		this.colors = colors;
		this.screenSizes = screenSizes;
		this.os = os;
		this.finance = finance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public Collection<ScreenSize> getScreenSizes() {
		return screenSizes;
	}

	public void setScreenSizes(Collection<ScreenSize> screenSizes) {
		this.screenSizes = screenSizes;
	}

	public Set<OS> getOs() {
		return os;
	}

	public void setOs(Set<OS> os) {
		this.os = os;
	}

	public Map<?, ?> getFinance() {
		return finance;
	}

	public void setFinance(Map<?, ?> finance) {
		this.finance = finance;
	}

	@Override
	public String toString() {
		return "Eproduct [id=" + id + ", name=" + name + ", price=" + price + ", dateAdded=" + dateAdded + ", colors="
				+ colors + ", screenSizes=" + screenSizes + ", os=" + os + ", finance=" + finance + "]";
	}
	
}
