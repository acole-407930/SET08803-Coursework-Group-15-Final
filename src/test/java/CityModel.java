import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.napier.sem.model.City;

class CityModel {

    @Test
    void testCityProperties() {

        City city = new City(1000, "Mumbai", "NM", "India", "Maharashtra", 10500000);

        assertEquals(1000, city.getId());
        assertEquals("Mumbai", city.getName());
        assertEquals("NM", city.getCountryCode());
        assertEquals("India", city.getCountryName());
        assertEquals("Maharashtra", city.getDistrict());
        assertEquals(10500000, city.getPopulation());
    }

    @Test
    void testCityToString() {
        City city = new City(9000, "Seoul", "NM", "South Korea", "Seoul", 9981619);
        String result = city.toString();
        assertTrue(result.contains("Seoul"));
        assertTrue(result.contains("9981619"));
    }
}