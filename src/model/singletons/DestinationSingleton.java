package model.singletons;

import model.objects.Destination;

import java.util.Set;

public class DestinationSingleton extends Singleton<Destination> {


    private static DestinationSingleton destinationSingletonInstance = null;
    public Set<Destination> destinationSet;

    private DestinationSingleton() {
        super("src/data/destinations.json");
        destinationSet = this.read(Destination.class);
    }

    public static DestinationSingleton getInstance() {
        if (destinationSingletonInstance == null)
            destinationSingletonInstance = new DestinationSingleton();

        return destinationSingletonInstance;
    }

}

