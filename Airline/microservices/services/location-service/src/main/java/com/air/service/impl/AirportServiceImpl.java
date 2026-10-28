package com.air.service.impl;

import com.air.mapper.AirportMapper;
import com.air.model.Airport;
import com.air.payload.request.AirportRequest;
import com.air.payload.response.AirportResponse;
import com.air.repository.AirportRepository;
import com.air.repository.CityRepository;
import com.air.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;

    @Override
    public AirportResponse createAirport(AirportRequest request) throws Exception {

        if (airportRepository.findByIataCode(request.getIataCode()).isPresent()) {
            throw new Exception("Airport with given IATA code already exists.");
        }

        Airport airport = AirportMapper.toEntity(request);
        airport.setCity(cityRepository.findById(request.getCityId()).orElseThrow(() -> new Exception("City not found")));

        Airport result = airportRepository.save(airport);

        return AirportMapper.toResponse(result);
    }

    @Override
    public AirportResponse updateAirport(Long id, AirportRequest request) throws Exception {
        Airport airport = airportRepository.findById(id).orElseThrow(() -> new Exception("Airport does not exists with given id- " + id));

        if (request.getIataCode() != null && !airport.getIataCode().equals(request.getIataCode()) && airportRepository.findByIataCode(request.getIataCode()).isPresent()) {
            throw new Exception("Airport with the given IATA code already exists.");
        }

        AirportMapper.updateEntity(airport, request);
        return AirportMapper.toResponse(airportRepository.save(airport));
    }

    @Override
    public void delteAirport(Long id) throws Exception {
        Airport Airport = airportRepository.findById(id).orElseThrow(() -> new Exception("Airport does not exists with given id."));
        airportRepository.delete(Airport);
    }

    @Override
    public AirportResponse getAirportById(Long id) throws Exception {
        Airport Airport = airportRepository.findById(id).orElseThrow(() -> new Exception("Airport does not exists with given id."));
        return AirportMapper.toResponse(Airport);
    }

    @Override
    public List<AirportResponse> getAllAirports() {
        return airportRepository.findAll().stream().map(AirportMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<AirportResponse> getAirportByCityId(Long cityId) {
        return airportRepository.findByCityId(cityId).stream().map(AirportMapper::toResponse).collect(Collectors.toList());
    }
}
