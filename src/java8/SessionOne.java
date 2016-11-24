package java8;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.Comparator.comparingDouble;

public class SessionOne {
	 
    /**
     * Teniendo la clase Ad y la lista de anuncios completar.
     */
 
    public static List<String> getSpanishPhoneFromAds(){
    	List<Ad> sampleAdList = Ad.sampleAdList();
    	
        return sampleAdList.stream()
        		.filter(ad -> ad.publisherHasSpanishPhone())
        		.map(ad -> ad.getPublisherPhone())
        		.collect(Collectors.toList()); 
    }

	public static Map<User, Ad> cheapestAdByUser() {
		List<Ad> sampleAdList = Ad.sampleAdList();
		
		return sampleAdList.stream()
				.collect(groupingBy(Ad::getPublisher, collectingAndThen(minBy(comparingDouble(Ad::getPrice)), Optional::get)));
    }
 
	public static String aTextWithNumberOfAdsByUser(){
		List<Ad> sampleAdList = Ad.sampleAdList();
		
        return sampleAdList.stream()
        		.collect(groupingBy(Ad::getPublisher, counting()))
        		.entrySet().stream()
        		.map(entrySet -> String.format("El usuario %s tiene %i anuncios", entrySet.getKey().getPublisherName(), entrySet.getValue()))
        		.collect(joining("\n")); // El usuario {nombre} tiene {numero} anuncios \n
    }
}