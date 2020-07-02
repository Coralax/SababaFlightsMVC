/*
 * 1. Make Singleton
 * 2. Can contain as many services as it needs
 */

package controller;

import controller.objects.Search;
import model.service.SearchService;

import java.io.IOException;

public class SearchController {

    private SearchService searchService = new SearchService();

    public void searchResults(Search search)  {
        //if (search.getDestination() == null || search.getDestination().trim().equals("")) {
       // }
       // if (search.getNumberOfPassengers()<1 || search.getNumberOfPassengers()>10)
          //  throw new IllegalArgumentException("Number of passengers must be between 1 to 10");

            searchService.validateSearch(search);
    }

}

