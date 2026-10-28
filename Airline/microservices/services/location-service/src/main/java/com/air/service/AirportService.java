package com.air.service;

import com.air.payload.request.AirportRequest;
import com.air.payload.response.AirportResponse;

import java.util.List;

public interface AirportService {

    AirportResponse createAirport(AirportRequest request) throws Exception;

    AirportResponse updateAirport(Long id, AirportRequest request) throws Exception;

    void delteAirport(Long id) throws Exception;

    AirportResponse getAirportById(Long id) throws Exception;

    List<AirportResponse> getAllAirports();

    List<AirportResponse> getAirportByCityId(Long cityId);
}
