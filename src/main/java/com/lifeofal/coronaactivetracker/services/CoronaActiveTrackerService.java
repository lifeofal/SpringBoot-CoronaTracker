package com.lifeofal.coronaactivetracker.services;

import com.lifeofal.coronaactivetracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


@Service
public class CoronaActiveTrackerService {

    private static String RAW_GITHUB_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";

    private List<LocationStats> allStats = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "0 0 23,0 * * *", zone = "UTC")
    public void fetchCoronaData() throws IOException, InterruptedException {
        List<LocationStats> currentStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient(); //create client
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(RAW_GITHUB_URL)).build(); //request body from the URL


        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString()); //transforms the return of the URL into a String List
//        System.out.println(httpResponse.body());

        StringReader csvBodyReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build().parse(csvBodyReader);
        for (CSVRecord record : records) {

            LocationStats locationStat = new LocationStats();

            locationStat.setCountry(record.get("Country_Region"));
            locationStat.setState(record.get("Province_State"));
            locationStat.setCounty(record.get("Admin2"));


            locationStat.setLatestConfirmedCases(Integer.parseInt(record.get(record.size()-1))); //gets the latest addition to the CSV file

//            System.out.println(locationStat);
            currentStats.add(locationStat);


        }
        this.allStats = currentStats;


    }

    public List<LocationStats> getAllStats() {
        return allStats;
    }


    public List<String> getUsaStates(){
        HashSet<String> stateList = new HashSet<>();
        List<LocationStats> allStats = getAllStats();

        for (LocationStats obj:
                allStats) {
            stateList.add(obj.getState());
        }
        List<String> returnList = new ArrayList<>(stateList);
        Collections.sort(returnList);
        return returnList;
    }
}
