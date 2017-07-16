//You are looking for a place to park your car on a suburban street. You can park at any position that meets the following requirements:
//
//1.	It is not directly in front of a private driveway.
//2.	It is not directly in front of a bus stop.
//3.	It is not 5 meters before a bus stop.
//4.	It is not 10 meters before a bus stop.
//5.	It is not directly in front of a side-street.
//6.	It is not 5 meters before a side-street.
//7.	It is not 5 meters after a side-street.
//The street will be represented as a , where each character describes a section of the street 5 meters in length. So the first character describes 
//the first 5 meters of the street, the second character describes the next 5 meters and so on. street will use 'D' for driveway, 'B' for bus stop, 
//'S' for side-street and '-' for all other sections of the street. A position is directly in front of an object if it has the same index as the object 
//in street. A position is before an object if its index is lower than the index of the object in street. Finally, a position is after an object if 
//its index is higher than the index of the object in street.
//
//Given the street return the total number of possible parking spaces on that street.


public class StreetParking {
	
	public static void main(String[] args){
		
		String street = "SSD-B---BD-DDSB-----S-S--------S-B----BSB-S--B-S-D";
		int answer = freeParks(street);
		System.out.println(answer);
		
		
	}
	
	public static int freeParks(String street){
		int available = 0;

		char[] a = street.toCharArray();

		for (int i = 0; i < a.length; i++) {

			if ((i != 0) && a[i] == 'B' && (a[i - 1] != 'B' && a[i - 1] != 'S' && a[i - 1] != 'D')) {
				a[i-1] = 'T';
			}

			if ((i != 0 && i != 1) && a[i] == 'B' && (a[i - 2] != 'B' && a[i - 2] != 'S' && a[i - 2] != 'D')) {
				a[i-2] = 'T';
			}

			if ((i != 0) && a[i] == 'S' && (a[i - 1] != 'B' && a[i - 1] != 'S' && a[i - 1] != 'D')) {
				a[i-1] = 'T';
			}

			if ((i != (a.length -1)) && a[i] == 'S' && (a[i + 1] != 'B' && a[i + 1] != 'S' && a[i + 1] != 'D')) {
				a[i+1]= 'T';
			}
		}
		
		
		
		for (int i = 0; i < a.length; i++) {

			if (a[i] != 'B' && a[i] != 'S' && a[i] != 'D' && a[i] != 'T') {
				available++;
			}
		}

		return available;
	}

}
