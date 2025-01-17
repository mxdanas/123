package service;

import modules.Passengers;
import berth.Berth;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;
public class BookingService {

	    private int availableSeats = 3;
	    private int waitingList = 5;
	    private int upper = 1, middle = 1, lower = 1;

	    private List<Passengers> bookedDetails = new ArrayList<>();
	    private List<Passengers> waitingListDetails = new ArrayList<>();

	    public void allocateBerth(Passengers passenger) {
	        switch (passenger.getPreferredBerth()) {
	            case UPPER:
	                if (upper > 0) {
	                    passenger.setAllocatedBerth(Berth.UPPER);
	                    upper--;
	                    System.out.println("Upper Berth allocated");
	                } else if (middle > 0 || lower > 0) {
	                    if (middle > 0) {
	                        passenger.setAllocatedBerth(Berth.MIDDLE);
	                        middle--;
	                        System.out.println("Middle Berth allocated");
	                    } else if (lower > 0) {
	                        passenger.setAllocatedBerth(Berth.LOWER);
	                        lower--;
	                        System.out.println("Lower Berth allocated");
	                    }
	                }
	                break;
	            case MIDDLE:
	                if (middle > 0) {
	                    passenger.setAllocatedBerth(Berth.MIDDLE);
	                    middle--;
	                    System.out.println("Middle Berth allocated");
	                } else if (upper > 0 || lower > 0) {
	                    if (upper > 0) {
	                        passenger.setAllocatedBerth(Berth.UPPER);
	                        upper--;
	                        System.out.println("Upper Berth allocated");
	                    } else if (lower > 0) {
	                        passenger.setAllocatedBerth(Berth.LOWER);
	                        lower--;
	                        System.out.println("Lower Berth allocated");
	                    }
	                }
	                break;
	            case LOWER:
	                if (lower > 0) {
	                    passenger.setAllocatedBerth(Berth.LOWER);
	                    lower--;
	                    System.out.println("Lower Berth allocated");
	                } else if (upper > 0 || middle > 0) {
	                    if (middle > 0) {
	                        passenger.setAllocatedBerth(Berth.MIDDLE);
	                        middle--;
	                        System.out.println("Middle Berth allocated");
	                    } else if (upper > 0) {
	                        passenger.setAllocatedBerth(Berth.UPPER);
	                        upper--;
	                        System.out.println("Upper Berth allocated");
	                    }
	                }
	                break;
	        }
	    }

	    public void bookTicket(Passengers passenger) {
	        if (availableSeats < 1) {
	            if (waitingList > 0) {
	                waitingListDetails.add(passenger);
	                waitingList--;
	                System.out.println("No Berths Available, you are in the Waiting List!!!");
	            } else {
	                System.out.println("Regret, Waiting List is full.");
	            }
	        } else {
	            allocateBerth(passenger);
	            bookedDetails.add(passenger);
	            System.out.println("Successfully Booked!!");
	            availableSeats--;
	        }
	    }

	    public void cancelTicket(int id) {
	        Passengers currentPassenger = bookedDetails.stream()
	                .filter(e -> e.getId() == id)
	                .findFirst()
	                .orElse(null);

	        if (currentPassenger != null) {
	            if (currentPassenger.getAllocatedBerth() == Berth.UPPER) {
	                upper++;
	            } else if (currentPassenger.getAllocatedBerth() == Berth.MIDDLE) {
	                middle++;
	            } else if (currentPassenger.getAllocatedBerth() == Berth.LOWER) {
	                lower++;
	            }

	            bookedDetails.remove(currentPassenger);
	            System.out.println("Ticket Cancelled!");

	            if (!waitingListDetails.isEmpty()) {
	                Passengers nextPassenger = waitingListDetails.get(0);
	                bookedDetails.add(nextPassenger);
	                allocateBerth(nextPassenger);
	                waitingListDetails.remove(0);
	                waitingList++;
	            } else {
	                availableSeats++;
	            }
	        } else {
	            System.out.println("You are not in the booked or waiting list for cancellation.");
	        }
	    }

	    public void printTicket(int id) {
	        if (waitingListDetails.stream().anyMatch(e -> e.getId() == id)) {
	            System.out.println("Status: You are in the Waiting list");
	            return;
	        }

	        long count = bookedDetails.stream().filter(e -> e.getId() == id).count();
	        if (count > 0) {
	            System.out.println("You are in booked details");
	        } else {
	            System.out.println("You are not in any list");
	        }
	    }

}
