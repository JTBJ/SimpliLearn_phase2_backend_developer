package phase2_lesson3_backendDeveloper.practice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="items")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "pName")
	private String pName;
	
	@Column(name = "pPrice")
	private double pPrice;
	
	@Column(name = "date_added")
	@UpdateTimestamp
	private Date date_added;

	public Items() {
	}

	public Items(String pName, double pPrice) {
		this.pName = pName;
		this.pPrice = pPrice;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	@Override
	public String toString() {
		return "Items [product_id=" + product_id + ", pName=" + pName + ", pPrice=" + pPrice + ", date_added="
				+ date_added + "]";
	}
	
}
