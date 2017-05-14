package com.zenika.flightstate.domain;


import java.io.Serializable;
import java.util.Objects;

/**
 * A Flight.
 */
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer year;

    private Integer month;

    private Integer dayOfMonth;

    private Integer dayOfWeek;

    private Integer depTime;

    private String flightNum;

    private Airport origin;

    private Airport dest;

    private Carrier uniqueCarrier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public Flight year(Integer year) {
        this.year = year;
        return this;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public Flight month(Integer month) {
        this.month = month;
        return this;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public Flight dayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public Flight dayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDepTime() {
        return depTime;
    }

    public Flight depTime(Integer depTime) {
        this.depTime = depTime;
        return this;
    }

    public void setDepTime(Integer depTime) {
        this.depTime = depTime;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public Flight flightNum(String flightNum) {
        this.flightNum = flightNum;
        return this;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Flight origin(Airport airport) {
        this.origin = airport;
        return this;
    }

    public void setOrigin(Airport airport) {
        this.origin = airport;
    }

    public Airport getDest() {
        return dest;
    }

    public Flight dest(Airport airport) {
        this.dest = airport;
        return this;
    }

    public void setDest(Airport airport) {
        this.dest = airport;
    }

    public Carrier getUniqueCarrier() {
        return uniqueCarrier;
    }

    public Flight uniqueCarrier(Carrier carrier) {
        this.uniqueCarrier = carrier;
        return this;
    }

    public void setUniqueCarrier(Carrier carrier) {
        this.uniqueCarrier = carrier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flight flight = (Flight) o;
        if (flight.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Flight{" +
            "id=" + id +
            ", year='" + year + "'" +
            ", month='" + month + "'" +
            ", dayOfMonth='" + dayOfMonth + "'" +
            ", dayOfWeek='" + dayOfWeek + "'" +
            ", depTime='" + depTime + "'" +
            ", flightNum='" + flightNum + "'" +
            '}';
    }
}
