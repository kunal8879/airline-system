package com.air.service;

import com.air.payload.request.CityRequest;
import com.air.payload.response.CityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {

    CityResponse createCity(CityRequest request) throws Exception;
    CityResponse updateCity(Long id, CityRequest request) throws Exception;
    void delteCity(Long id) throws Exception;

    CityResponse getCityById(Long id) throws Exception;
    Page<CityResponse> getAllCity(Pageable pageable);

    Page<CityResponse> searchCities(String keyword, Pageable pageable);
    Page<CityResponse> getCitiesByCountryCode(String CountryCode, Pageable pageable);

    boolean cityExists(String cityCode);
}
