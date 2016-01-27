package test;

import static org.mockito.Mockito.when;

import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherStatusResponse;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.assignment.dto.WeatherValueObject;
import com.assignment.factory.OpenWeatherMapSource;

@ContextConfiguration(locations = { "file:WebContent/WEB-INF/Assignment-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class OwnTest {
	@Mock
	private OwmClient owmClient;

	@InjectMocks 
	@Autowired
	private OpenWeatherMapSource openWeatherMapSource;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void sampleTest() throws Exception {
		
		String myResource1 = "{\"message\":\"\",\"cod\":\"200\",\"type\":\"base-country\",\"calctime\":\"\",\"units\":\"internal\",\"count\":1,\"list\":[{\"id\":0,\"coord\":{\"lat\":-33.867851,\"lon\":151.207321},\"name\":\"Sydney\",\"main\":{\"temp\":298.15,\"pressure\":1015,\"humidity\":61,\"temp_min\":298.15,\"temp_max\":298.15},\"dt\":1453865094,\"date\":\"2016-01-27 03:24:54\",\"wind\":{\"speed\":7.7,\"deg\":40},\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"sys\":{\"population\":0},\"url\":\"http://openweathermap.org/city/\"}]}";
		
		when(owmClient.currentWeatherAtCity("Melbourne", "AU")).thenReturn(new WeatherStatusResponse(new JSONObject(myResource1)));

		WeatherValueObject response = openWeatherMapSource.getWeatherData("Melbourne");
			
		Assert.assertEquals("Melbourne", response.getCity());
		
		Assert.assertEquals("24.999994'C", response.getTemperature());
		
		Assert.assertEquals("Wednesday 14:24 PM", response.getUpdatedTime());
		
		Assert.assertEquals("overcast clouds", response.getWeather());
		
		Assert.assertEquals("27.719997 km/h", response.getWind());
	}
}
