package java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ad {
    private final Integer id;
    private final Typology typology;
    private final Double price;
    private final Boolean active;
    private final User publisher;
 
    public Ad(Integer id, Typology typology, Double price, User publisher) {
        this.id = id;
        this.typology = typology;
        this.price = price;
        this.publisher = publisher;
        this. active = true;
    }
 
    private Ad(Ad ad, Boolean isActive) {
        this.id = ad.getId();
        this.typology = ad.getTypology();
        this.price = ad.getPrice();
        this.publisher = ad.getPublisher();
        this.active = isActive;
    }
 
    public Integer getId() {
        return id;
    }
 
    public Typology getTypology() {
        return typology;
    }
 
    public Double getPrice() {
        return price;
    }
 
    public Boolean isActive() {
        return active;
    }
 
    public User getPublisher() {
        return publisher;
    }
 
    public Ad deactivate() {
        return new Ad(this, false);
    }
 
    public enum Typology {
        House, Garage, Office
    }

	public boolean publisherHasSpanishPhone() {
		return this.publisher.hasSpanishPhone();
	}
	
	private static Ad randomAd(){
		return new Ad(randomId(), randomTypology(), randomPrice(), randomPublisher());
	}
	
	public static List<Ad> sampleAdList(){
		return Stream.generate(() -> Ad.randomAd()).limit(100).collect(Collectors.toList());
	}
	 
    private static Integer randomId() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Typology randomTypology() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Double randomPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	private static User randomPublisher() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPublisherPhone() {
		return this.publisher.getPhone();
	}
 
}