package model.objects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Destination {

    public List<String> listOfDestinations =new ArrayList<>();

    public Destination(){}

    public Destination(List<String> listOfDestinations) {
        this.listOfDestinations=listOfDestinations;
    }

    public List<String> getListOfDestinations() {
        return listOfDestinations;
    }

    public void setListOfDestinations(List<String> listOfDestinations) {
        this.listOfDestinations = listOfDestinations;
    }

    @Override
    public String toString() {
        return "Destinations are: " + "\n"+
                 listOfDestinations;
    }
}



