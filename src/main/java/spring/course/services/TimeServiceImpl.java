package spring.course.services;

import kong.unirest.Unirest;
import org.springframework.stereotype.Service;
import spring.course.model.TimeApiResponse;


@Service
public class TimeServiceImpl implements TimeService {

    public String getCurrentTime(String timeZone) {

        TimeApiResponse response = Unirest.get("http://worldtimeapi.org/api/timezone/" + timeZone)
                .asObject(TimeApiResponse.class)
                .getBody();

        return response.getUtc_datetime();
    }
}
