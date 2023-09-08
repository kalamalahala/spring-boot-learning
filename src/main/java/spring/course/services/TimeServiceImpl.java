package spring.course.services;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;
import spring.course.config.TimeApiConfig;
import spring.course.model.TimeApiResponse;

import java.util.TimeZone;


@Service
public class TimeServiceImpl implements TimeService {

    private final TimeApiConfig config;

    public TimeServiceImpl(TimeApiConfig config) {
        this.config = config;
    }

    public String getCurrentTime(String timeZone) {
        String endpoint = this.config.getEndpoint();
        String localZone = this.config.getTimezone();
        String request = endpoint + localZone;

        HttpResponse<TimeApiResponse> response = Unirest.get(request)
                .asObject(TimeApiResponse.class);


        return response.getBody().getUtc_datetime();
    }

    public String getTimeZone() {
        return TimeZone.getDefault().getID();
    }

    public String getLocalTime() {
        String timeZone = getTimeZone();

        TimeApiResponse response = Unirest.get("http://worldtimeapi.org/api/timezone/" + timeZone)
                .asObject(TimeApiResponse.class)
                .getBody();

        return response.getUtc_datetime();
    }
}
