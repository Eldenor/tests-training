package com.sda.tests.weater;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherService {
    //https://openweathermap.org/forecast5
    private final String API_KEY = "9ff01c87b3cc2ab6cd884c1c81f03c92";
    private final String URL_ROOT = "http://api.openweathermap.org/data/2.5/forecast";


    public List<Wheater> getWeatherData(String cityName) {
        try {
            HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get(URL_ROOT)
                    .queryString("q", cityName)
                    .queryString("appid", API_KEY)
                    .asJson();
            List<Wheater> result = new ArrayList<>();
            JSONArray jsonArrayResponse = jsonNodeHttpResponse.getBody().getObject().getJSONArray("list");
            for (int i = 0; i < jsonArrayResponse.length(); i++) {
                result.add(convertToObject(jsonArrayResponse.getJSONObject(i)));
            }
            return result;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Double> getTemperatureList(String city) {
        return getWeatherData(city).stream().map(Wheater::getTemperature).collect(Collectors.toList());
    }

    public Double rainForecastSum(String city) {
        return getWeatherData(city).stream().map(Wheater::getRainVolume).mapToDouble(rain -> rain).sum();
    }

    public Long getFirstMeasurementDate(String city) {
        return getWeatherData(city).get(0).getTimestamp();
    }

    private Wheater convertToObject(JSONObject jsonNode) {
        try {
            return new Wheater(
                    jsonNode.getLong("dt"),
                    jsonNode.getJSONObject("main").getDouble("temp"),
                    jsonNode.getJSONObject("wind").getDouble("speed"),
                    jsonNode.getJSONObject("clouds").getInt("all"),
                    jsonNode.getJSONObject("rain").getDouble("3h")
            );
        } catch (JSONException e) {
            e.printStackTrace();
            return new Wheater();
        }
    }

}
