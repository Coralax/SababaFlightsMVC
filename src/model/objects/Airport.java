package model.objects;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    private String country, airportName;
    private List<String> terminals = new ArrayList<>();

    public Airport() {}

    public Airport(String country, String airportName, List<String> terminals) {
        this.country = country;
        this.airportName = airportName;
        this.terminals = terminals;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountry() {
        return this.country;
    }
    public String getAirportName() {
        return this.airportName;
    }
    public List<String> getTerminals() { return this.terminals; }


    public boolean addTerminal(String terminal) {
        if(!this.terminals.contains(terminal)) {
            this.terminals.add(terminal);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return
                " Country name: " + country + "\n" +
                " Airport name: " + airportName + "\n"+
                " Terminals: " + terminals ;
    }
}
