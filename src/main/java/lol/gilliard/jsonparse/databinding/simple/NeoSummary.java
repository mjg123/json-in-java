package lol.gilliard.jsonparse.databinding.simple;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.time.LocalDate;

class NeoSummary {

    public static String neoSummaryJsonString = "{" +
        " \"id\": \"54016476\"," +
        " \"name\": \"(2020 GR1)\"," +
        " \"close_approach_date\": \"2020-04-12\"" +
        "}";


    public static class NeoSummaryDetails {
        public String id;   // these all need to be public so that Jackson/Gson can find them
        public String name; // you could use setters instead, as long as the names match the JSON

        // These annotations could also be applied to setters, or to constructor parameters
        @JsonProperty("close_approach_date")    // this one for Jackson
        @SerializedName("close_approach_date")  // this one for Gson
        public LocalDate closeApproachDate;

        // I added this method to make the output nice. Jackson and Gson don't need it.
        @Override
        public String toString() {
            return "NeoSummaryDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", closeApproach=" + closeApproachDate +
                '}';
        }

    }


    public static void main(String[] args) throws IOException {
        jacksonDataBinding();
        gsonDataBinding();
    }

    private static void jacksonDataBinding() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

        NeoSummaryDetails neoSummaryDetails = objectMapper
            .readValue(neoSummaryJsonString, NeoSummaryDetails.class);

        System.out.println("Jackson made:\n  " + neoSummaryDetails);
    }

    private static void gsonDataBinding() {
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new GsonLocalDateAdapter())
            .create();

        NeoSummaryDetails neoSummaryDetails = gson
            .fromJson(neoSummaryJsonString, NeoSummaryDetails.class);

        System.out.println("Gson made:\n  " + neoSummaryDetails);
    }

}