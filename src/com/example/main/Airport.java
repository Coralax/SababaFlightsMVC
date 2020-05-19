package com.example.main;
import java.util.List;

public class Airport {
    private String address, name;
    private List<String> terminals;

    Airport(String address, String name, List<String> terminals) {
        this.address = address;
        this.name = name;
        this.terminals = terminals;
    }

    public String getAddress() {
        return this.address;
    }
    public String getName() {
        return this.name;
    }
    public List<String> getTerminals() {
        return this.terminals;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTerminals(List<String> terminals) {
        this.terminals = terminals;
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
