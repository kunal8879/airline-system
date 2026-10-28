package com.air.mapper;

import com.air.model.Airport;
import com.air.payload.request.AirportRequest;
import com.air.payload.response.AirportResponse;

public class AirportMapper {

    public static Airport toEntity(AirportRequest request) {
        if (request == null) return null;

        return Airport.builder()
                .iataCode(request.getIataCode())
                .name(request.getName())
//                .timeZone(request.getTimeZone())
                .address(request.getAddress())
                .geoCode(request.getGeoCode())
                .build();
    }

    public static AirportResponse toResponse(Airport airport) {
        if (airport == null) return null;

        return AirportResponse.builder()
                .id(airport.getId())
                .iataCode(airport.getIataCode())
                .name(airport.getName())
                .detailedName(airport.getDetailedName())
//                .timeZone(airport.getTimeZone())
                .address(airport.getAddress())
                .city(CityMapper.toResponse(airport.getCity()))
                .geoCode(airport.getGeoCode())
                .build();
    }

    public static void updateEntity(Airport airport, AirportRequest request) {
        if (request.getName() != null) {
            airport.setName(request.getName().trim());
        }
        if (request.getIataCode() != null) {
            airport.setIataCode(request.getIataCode().trim());
        }
        if (request.getName() != null) {
            airport.setName(request.getName().trim());
        }
        if (request.getAddress() != null) {
            airport.setAddress(request.getAddress());
        }
        if (request.getGeoCode() != null) {
            airport.setGeoCode(request.getGeoCode());
        }
    }
}
