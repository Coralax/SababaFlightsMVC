
import model.objects.Airport;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

    class AirportTests {
        @Test

        void addTerminal_NewTerminals_AddsSuccessfullyToList() {
            Airport ar1 = new Airport("Israel, TLV", "Ben-Gurion", Arrays.asList("T1", "T3"));
            ar1.addTerminal("T2");
            int count = ar1.getTerminals().size();
            assertEquals(2, count);
        }

        @Test
        void addTerminal_ExistingTerminal_NotAddingToList() {
            Airport ar1 = new Airport("New-York, JFK", "JFK", Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));
            ar1.addTerminal("T1");
            int count = ar1.getTerminals().size();
            assertEquals(1, count);
        }

    }
