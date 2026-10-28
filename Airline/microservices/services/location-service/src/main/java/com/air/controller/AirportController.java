package com.air.controller;


import com.air.payload.request.AirportRequest;
import com.air.payload.response.AirportResponse;
import com.air.payload.response.ApiResponse;
import com.air.service.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    @PostMapping
    public ResponseEntity<AirportResponse> saveAirport(@Valid @RequestBody AirportRequest request) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(airportService.createAirport(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> updateAirport(@PathVariable Long id, @Valid @RequestBody AirportRequest request) throws Exception {
        return ResponseEntity.ok(airportService.updateAirport(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAirport(@PathVariable Long id) throws Exception {
        airportService.delteAirport(id);
        return ResponseEntity.ok(new ApiResponse("Airport deleted successfully"));
    }

    @GetMapping
    public ResponseEntity<List<AirportResponse>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> getAirportById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(airportService.getAirportById(id));
    }

    @GetMapping("/exists/{cityId}")
    public ResponseEntity<List<AirportResponse>> getAirportByCityId(@PathVariable Long cityId) {
        return ResponseEntity.ok(airportService.getAirportByCityId(cityId));
    }
}
