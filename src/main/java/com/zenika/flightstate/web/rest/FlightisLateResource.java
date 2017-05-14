package com.zenika.flightstate.web.rest;

import com.zenika.flightstate.domain.FlightPrediction;
import com.zenika.flightstate.domain.FlightView;
import com.zenika.flightstate.service.FlightislateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by geraud on 28/04/17.
 */
@RestController
@RequestMapping("/api")
public class FlightisLateResource {
    private final FlightislateService service;

    public FlightisLateResource(FlightislateService service) {
        this.service = service;
    }

    @PostMapping("/flight")
    public FlightPrediction islate(@RequestBody FlightView flight) {
        return service.predictFlight(flight);
    }
}
