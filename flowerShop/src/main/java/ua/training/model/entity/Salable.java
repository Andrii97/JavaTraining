package ua.training.model.entity;

import java.time.LocalDate;

/**
 * Created by andrii on 18.11.16.
 */
public interface Salable {
    double getPrice();
    LocalDate getDateOfSupply();
}
