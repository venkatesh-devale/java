import java.util.*;

public class Main {
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Theatre theatre = new Theatre("INOX", 8, 12);
		theatre.getSeats();

		List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.getSeats());
		seatCopy.get(1).reserve();
		if(theatre.reserveSeat("D12"))
			System.out.println("Please pay for D12");
		else
			System.out.println("Seat already reserved");
		
		if(theatre.reserveSeat("B13"))
			System.out.println("Please pay for B13");
		else
			System.out.println("Seat already reserved");

		if(theatre.reserveSeat("D12"))
			System.out.println("Please pay for D12");
		else
			System.out.println("Seat already reserved");

		List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
		Collections.reverse(reverseSeats);
		printList(reverseSeats);


		List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
		priceSeats.add(theatre.new Seat("B00", 13.00));
		priceSeats.add(theatre.new Seat("A00", 13.00));
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);
		printList(priceSeats);

		Collections.reverse(seatCopy);
		Collections.shuffle(seatCopy);
		System.out.println("Printing seatCopy:");
		printList(seatCopy);
		System.out.println("Printing theatre.seats:");
		//printList(theatre.seats);
		System.out.println("MIN Seat:" + Collections.min(seatCopy).getSeatNum());
		System.out.println("MAX Seat:" + Collections.max(seatCopy).getSeatNum());


		sortList(seatCopy);
		System.out.println("Printing again after sorting:");
		printList(seatCopy);

		//List<Theatre.Seat> newList = new ArrayList<>(theatre.getSeats().size());
		//Collections.copy(newList, theatre.seats); // Need to check more on Collections.copy()

	}

	public static void sortList(List<? extends Theatre.Seat> list) {
		for(int i = 0; i < list.size()-1; i++) {
			for( int j = i + 1; j < list.size(); j++) {
				if(list.get(i).compareTo(list.get(j)) > 0) {
					Collections.swap(list, i, j);
				}
			}
		}
	}


	public static void printList(List<Theatre.Seat> list) {
		for(Theatre.Seat seat : list) {
			System.out.println(" " + seat.getSeatNum() + " $" + seat.getPrice());
		}
		System.out.println();
		System.out.println("========================");
	}
}