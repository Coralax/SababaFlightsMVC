package model.objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Airport implements Serializable {

    private String address, name;
    private List<String> terminals = new ArrayList<>();

    public Airport(String address, String name, String terminal) {
        this.address = address;
        this.name = name;
        this.terminals.add(terminal);
    }

    public String getAddress() {
        return this.address;
    }
    public String getName() {
        return this.name;
    }
    public List<String> getTerminals() { return this.terminals; }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean addTerminal(String terminal) {
        if(!this.terminals.contains(terminal)) {
            this.terminals.add(terminal);
            return true;
        } else {
            return false;
        }
    }

}
