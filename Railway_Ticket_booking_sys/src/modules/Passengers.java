package modules;

import berth.Berth;

public class Passengers {
	
	    private int id;
	    private String name;
	    private Berth preferredBerth;
	    private Berth allocatedBerth;

	    public Passengers(int id, String name, Berth preferredBerth) {
	        this.id = id;
	        this.name = name;
	        this.preferredBerth = preferredBerth;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Berth getPreferredBerth() {
	        return preferredBerth;
	    }

	    public void setPreferredBerth(Berth preferredBerth) {
	        this.preferredBerth = preferredBerth;
	    }

	    public Berth getAllocatedBerth() {
	        return allocatedBerth;
	    }

	    public void setAllocatedBerth(Berth allocatedBerth) {
	        this.allocatedBerth = allocatedBerth;
	    }

}
