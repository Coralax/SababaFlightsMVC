
import model.objects.Airport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class AirportTests {
        @Test

        void addTerminal_NewTerminals_AddsSuccessfullyToList() {
            Airport ar1 = new Airport("Sababa Road 100", "Israel", "T1");
            ar1.addTerminal("T2");
            int count = ar1.getTerminals().size();
            assertEquals(2, count);
        }

        @Test
        void addTerminal_ExistingTerminal_NotAddingToList() {
            Airport ar1 = new Airport("Sababa Road 100", "Israel", "T1");
            ar1.addTerminal("T1");
            int count = ar1.getTerminals().size();
            assertEquals(1, count);
        }

    }
