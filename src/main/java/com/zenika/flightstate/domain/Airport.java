package com.zenika.flightstate.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Airport.
 */
public class Airport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String iata;

    private Float lon;

    private Float lat;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIata() {
        return iata;
    }

    public Airport iata(String iata) {
        this.iata = iata;
        return this;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Float getLon() {
        return lon;
    }

    public Airport lon(Float lon) {
        this.lon = lon;
        return this;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public Airport lat(Float lat) {
        this.lat = lat;
        return this;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public Airport name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Airport airport = (Airport) o;
        if (airport.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, airport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Airport{" +
            "id=" + id +
            ", iata='" + iata + "'" +
            ", lon='" + lon + "'" +
            ", lat='" + lat + "'" +
            ", name='" + name + "'" +
            '}';
    }
}
