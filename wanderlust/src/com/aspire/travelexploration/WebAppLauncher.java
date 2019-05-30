package com.aspire.travelexploration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class WebAppLauncher {

	public static void main(String[] args) {
		Flight flightObject=new Flight();
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the flightid: ");
		flightObject.setFlightId(scanner.nextInt());
		System.out.println("AirlineId: ");
		flightObject.setAirlineId(scanner.nextInt());
		System.out.println("Airlinename: ");
		flightObject.setAirLineName(scanner.next());
		flightObject.setAirlineLogo(null);
		System.out.println("From Location: ");
		flightObject.setFromLocation(scanner.next());
		System.out.println("To Location: ");
		flightObject.setToLocation(scanner.next());
		System.out.println("Departure Time: ");
		flightObject.setDepartureTime(scanner.next());
		System.out.println("Arrival Time: ");
		flightObject.setArrivalTime(scanner.next());
		System.out.println("Duration: ");
		flightObject.setDuration(scanner.next());
		System.out.println("Total Seats: ");
		flightObject.setTotalSeats(scanner.nextInt());
		System.out.println("baggage Allowance: ");
		flightObject.setBaggageAllowance(scanner.next());
		System.out.println("Taxes: ");
		flightObject.setTaxes(scanner.nextFloat());
		System.out.println("Class: [ECONOMY,BUSINESS,FIRSTCLASS,PREMIUMECONOMY]");
		flightObject.setFlightClass(FlightE.valueOf(scanner.next()));
		System.out.println("Stoppages: ");
		flightObject.setStoppages(scanner.nextInt());
		System.out.println("Enter Departure date: ");
		flightObject.setDepDate(Date.valueOf(LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt())));
		System.out.println("Enter the price of ticket: ");
		flightObject.setPrice(scanner.nextInt());
		System.out.println("Enter the available seats: ");
		flightObject.setAvailableSeats(scanner.nextInt());
		FlightDao flightDao=new FlightDao();
		System.out.println("Insert Flight  :");
		System.out.println(flightDao.insertFlight(flightObject));
		System.out.println("No.of filtered Objects"+flightDao.filterByPrice(flightObject).size());
		System.out.println("No.of retrieved Objects"+flightDao.searchFlight(flightObject).size());
		
		
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
		TicketDao querySqlTicket=new TicketDao();
		System.out.println("Insert Ticket");
		System.out.println(querySqlTicket.insertTicket(ticket));
		System.out.println("Cancelled ticket"+querySqlTicket.cancelTicket(ticket));
		System.out.println("Selected ticket Objects"+querySqlTicket.selectTicketByUser(ticket).size());
		
//		FlightDeals flightDeals=new FlightDeals();
//		flightDeals.setApplicableBanks("CitiBank cards only");
//		flightDeals.setBookingChannel("WebSite only");
//		flightDeals.setCouponCode("MMTHDFC");
//		flightDeals.setMinimumBookingAmount(7000);
//		flightDeals.setOfferDetails("flat 20% instant discount on international hotels. coupon code: MMTHDFC");
//		flightDeals.setTagLine("Make your next vacation an international one.");
//		flightDeals.setValidity("From 23th January to 27th January, 2019");
		FlightDealsDao flightDealsDao=new FlightDealsDao();
		System.out.println("Selected FlightDeals "+flightDealsDao.selectFlightDeals().size());
		
		TourPackage tourPackageObject=new TourPackage();
		tourPackageObject.setAgency_id(1002);
		tourPackageObject.setAgency_name("Travel Right");
		tourPackageObject.setAssistance_Person("Harrison Wells");
		tourPackageObject.setCountry("China");
		tourPackageObject.setDays(2);
		tourPackageObject.setHoliday_type("Family");
		tourPackageObject.setImg(null);
		tourPackageObject.setItinerary("Day 1:Arrival in Hong Kong | Half-Day Premium City Excursion "
				+ "Day2:Day at Leisure /Ocean Park Excursion (Optional) | Meal Included: Breakfast"
				+ "Day3:Day at Leisure /Disneyland Tour (Optional) | Meal Included: Breakfast");
		tourPackageObject.setNights(3);
		tourPackageObject.setPackage_type("Premium");
		tourPackageObject.setPeriod_of_Package("Winter");
		tourPackageObject.setPlace("Hong Kong");
		tourPackageObject.setPricing(68904);
		tourPackageObject.setTagline1("HONG KONG A complete Holiday Destination!");
		tourPackageObject.setTagline2("Come and Visit for a wholesome Experience!");
		TourPackagesDao querySqlTourPackage=new TourPackagesDao();
		System.out.println("Tour Package Insert "+querySqlTourPackage.insertPackage(tourPackageObject));
		System.out.println("Selected Tour Package by Country"+querySqlTourPackage.selectPackageByCountry(tourPackageObject).size());
		System.out.println("Selected Tour Package by PackageType"+querySqlTourPackage.selectPackageByPackageType(tourPackageObject).size());
		System.out.println("Selected Tour Package by Pricing"+querySqlTourPackage.selectPackageByPricing(tourPackageObject).size());
		
		Trip tripObject=new Trip();
		tripObject.setCountry("China");
		tripObject.setPlaceName("Beijing");
		tripObject.setPlaceType("tombs,temple");
		tripObject.setRating(4);
		tripObject.setReview("Chinese hotel with clean roms and friendly staff. Easy walk to underground in Beijing and therefore you do not need a car. If you like Chinese food there are several small fastfood like places to eat right outside the hotel. However the food is prima in the hotel and the Chinese breakfast first class :)");
		tripObject.setSpecialities("sprawling palace complex & museum,Iconic lakeside retreat for royalty");
		tripObject.setState("Beijing");
		tripObject.setTripId(4002);
		tripObject.setUserId(1);
		TripDao querySqlTrip=new TripDao();
		System.out.println("inserted Trip");
		querySqlTrip.insertTrip(tripObject);
		System.out.println("Selected Trip"+querySqlTrip.selectTrip(tripObject).size());
		scanner.close();
	}

}
