package com.example.dassi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.dassi.Converters.*;

@SpringBootApplication
public class DassiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DassiApplication.class, args);
	}

	@Bean
	public BusConverter getBusConverter() {
		return new BusConverter();
	}

	@Bean
	public StationLineConverter getStationLineConverter() {
		return new StationLineConverter();
	}

	@Bean
	public DriverConverter getDriverConverter() {
		return new DriverConverter();
	}

	@Bean
	public LineConverter getLineConverter() {
		return new LineConverter();
	}

	@Bean
	public StationConverter getStationConverter() {
		return new StationConverter();
	}

	@Bean
	public TravelConverter getTravelConverter() {
		return new TravelConverter();
	}
}
