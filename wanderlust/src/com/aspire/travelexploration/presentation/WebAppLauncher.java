package com.aspire.travelexploration.presentation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.aspire.travelexploration.daoimpl.FlightDAO;
import com.aspire.travelexploration.daoimpl.FlightDealsDAO;
import com.aspire.travelexploration.daoimpl.TicketDAO;
import com.aspire.travelexploration.daoimpl.TourPackagesDAO;
import com.aspire.travelexploration.daoimpl.TripDAO;
import com.aspire.travelexploration.entity.Flight;
import com.aspire.travelexploration.entity.FlightDeal;
import com.aspire.travelexploration.entity.Ticket;
import com.aspire.travelexploration.entity.TourPackage;
import com.aspire.travelexploration.entity.Trip;
import com.aspire.travelexploration.enums.FlightE;
import com.aspire.travelexploration.enums.Status;

public class WebAppLauncher {

		public static void main(String[] args) {
			List<Exception> exceptions=new ArrayList<Exception>();
			try {
			Flight flight=new Flight();
			Scanner scanner=new Scanner(System.in);
			System.out.println("enter the flightid: [2000+]");
			flight.setFlightId(scanner.nextInt());
			System.out.println("AirlineId: [1100+]");
			flight.setAirlineId(scanner.nextInt());
			System.out.println("Airlinename: [Indigo,Lufthansa]");
			flight.setAirLineName(scanner.next());
			flight.setAirlineLogo(null);
			System.out.println("From Location: [MAA]");
			flight.setFromLocation(scanner.next());
			System.out.println("To Location: [SIN]");
			flight.setToLocation(scanner.next());
			System.out.println("Departure Time: [17:00:00]");
			flight.setDepartureTime(scanner.next());
			System.out.println("Arrival Time: [22:00:00]");
			flight.setArrivalTime(scanner.next());
			System.out.println("Duration: [05:30]");
			flight.setDuration(scanner.next());
			System.out.println("Total Seats: [43]");
			flight.setTotalSeats(scanner.nextInt());
			System.out.println("baggage Allowance: [8 kgs as single bag]");
			flight.setBaggageAllowance(scanner.nextLine());
			System.out.println("Taxes: [7.6]");
			flight.setTaxes(scanner.nextFloat());
			System.out.println("Class: [ECONOMY,BUSINESS,FIRSTCLASS,PREMIUMECONOMY]");
			flight.setFlightClass(FlightE.valueOf(scanner.next()));
			System.out.println("Stoppages: [0]");
			flight.setStoppages(scanner.nextInt());
			System.out.println("Enter Departure date: [2019/02/24]");
			flight.setDepDate(Date.valueOf(scanner.next()));
			System.out.println("Enter the price of ticket: [13000]");
			flight.setPrice(scanner.nextInt());
			System.out.println("Enter the available seats: [41]");
			flight.setAvailableSeats(scanner.nextInt());
			FlightDAO flightDao=new FlightDAO();
			System.out.println("Insert Flight  :");
			System.out.println(flightDao.addDetails(flight));
			System.out.println("No.of filtered Objects"+flightDao.filterByPrice(flight).size());
			System.out.println("No.of retrieved Objects"+flightDao.selectDetails(flight).size());
			
			
			
			Ticket ticket=new Ticket();
			ticket.setUserId(1);
			ticket.setTicketId(1202);
			ticket.setStatus(Status.valueOf("CONFIRMED"));
			ticket.setPassengerName("Regina");
			ticket.setFlightId(2002);
			ticket.setFlightClass(FlightE.valueOf("FIRSTCLASS"));
			ticket.setDepTime("21:00:00");
			ticket.setDepDate(Date.valueOf(LocalDate.of(2019,02,21)));
			ticket.setDateOfBooking(Date.valueOf(LocalDate.of(2019,02,12)));
			TicketDAO ticketDao=new TicketDAO();
			System.out.println("Insert Ticket");
//			System.out.println(ticketDao.insertTicket(ticket));
			System.out.println("Cancelled ticket"+ticketDao.cancelTicket(ticket));
			System.out.println("Selected ticket Objects"+ticketDao.selectTicketByUser(ticket).size());
			
			FlightDeal flightDeal=new FlightDeal();
			flightDeal.setApplicableBanks("CitiBank cards only");
			flightDeal.setBookingChannel("WebSite only");
			flightDeal.setCouponCode("MMTHDFC");
			flightDeal.setMinimumBookingAmount(7000);
			flightDeal.setOfferDetails("flat 20% instant discount on international hotels. coupon code: MMTHDFC");
			flightDeal.setTagLine("Make your next vacation an international one.");
			flightDeal.setValidity("From 23th January to 27th January, 2019");
			FlightDealsDAO flightDealsDao=new FlightDealsDAO();
			System.out.println("inserting FlightDeals "+ flightDealsDao.addDetails(flightDeal) );
			System.out.println("Selected FlightDeals "+flightDealsDao.selectDetails(flightDeal).size());
			
			TourPackage tourPackage=new TourPackage();
			tourPackage.setPackage_id(1002);
			System.out.println("Enter the agency name : [Travel Right]");
			tourPackage.setAgency_name(scanner.nextLine());
			System.out.println("Enter the assitance person's name : [Harrison Wells]");
			tourPackage.setAssistance_Person(scanner.nextLine());
			System.out.println("Enter the country : [China]");
			tourPackage.setCountry(scanner.next());
			System.out.println("Enter the number of days: [2]");
			tourPackage.setDays(scanner.nextInt());
			System.out.println("Enter the number of nights : [3]");
			tourPackage.setNights(scanner.nextInt());
			System.out.println("Select the holiday type : [Family,Friends]");
			tourPackage.setHoliday_type(scanner.next());
			tourPackage.setImg(null);
			tourPackage.setItinerary(scanner.nextLine());
			System.out.println("Enter the itinerary details : [Day 1:Arrival in Hong Kong | Half-Day Premium City Excursion "
					+ "Day2:Day at Leisure /Ocean Park Excursion (Optional) | Meal Included: Breakfast"
					+ "Day3:Day at Leisure /Disneyland Tour (Optional) | Meal Included: Breakfast)]");
			System.out.println("select the type of the package : [Premium,Standard]");
			tourPackage.setPackage_type(scanner.next());
			System.out.println("Enter the Period at which the package has been offered : [allyear or winter]");
			tourPackage.setPeriod_of_Package(scanner.next());
			System.out.println("Enter the place : [Hong kong]");
			tourPackage.setPlace(scanner.next());
			System.out.println("Enter the price of the package : [68904]");
			tourPackage.setPricing(scanner.nextInt());
			System.out.println("Enter the taglines 1: [HONG KONG A complete Holiday Destination!]");
			tourPackage.setTagline1(scanner.nextLine());
			System.out.println("2 : [Come and Visit for a wholesome Experience!]");
			tourPackage.setTagline2(scanner.nextLine());
			TourPackagesDAO tourPackageDao=new TourPackagesDAO();
			System.out.println("Tour Package Insert "+tourPackageDao.addDetails(tourPackage));
			System.out.println("Selected Tour Package by Country"+tourPackageDao.selectPackageByCountry(tourPackage).size());
			System.out.println("Selected Tour Package by PackageType"+tourPackageDao.selectPackageByPackageType(tourPackage).size());
			System.out.println("Selected Tour Package by Pricing"+tourPackageDao.selectPackageByPricing(tourPackage).size());
			
			Trip trip=new Trip();
			System.out.println("Enter the Country you've been to : [China]");
			trip.setCountry(scanner.next());
			System.out.println("Enter the place you've been to : [Beijing]");
			trip.setPlaceName(scanner.next());
			System.out.println("Select the place you've been to : [tombs,temple]");
			trip.setPlaceType(scanner.next());
			System.out.println("Enter the rating : [4]");
			trip.setRating(scanner.nextInt());
			System.out.println("Enter your Review : [Chinese hotel with clean roms and friendly staff. Easy walk to underground in Beijing and therefore you do not need a car. If you like Chinese food there are several small fastfood like places to eat right outside the hotel. However the food is prima in the hotel and the Chinese breakfast first class:)]"); 
			trip.setReview(scanner.next());
			System.out.println("Enter the specialities about the place : sprawling palace complex & museum,Iconic lakeside retreat for royalty");
			trip.setSpecialities(scanner.next());
			System.out.println("Enter the state : [Beijing]");		
			trip.setState(scanner.next());
			trip.setTripId(4002);		
			trip.setUserId(1);
			TripDAO tripDao=new TripDAO();
			System.out.println("inserting Trip");
			tripDao.addDetails(trip);
			System.out.println("Selected Trip"+tripDao.selectDetails(trip).size());
			scanner.close();
			}	catch(InputMismatchException e) {
				exceptions.add(e);
			}	catch(NullPointerException e) {
				exceptions.add(e);
			}	catch(Exception e) {
				exceptions.add(e);
			}
			for(Exception exception:exceptions) {
				System.out.println(exception);
			}
		}
		

}
