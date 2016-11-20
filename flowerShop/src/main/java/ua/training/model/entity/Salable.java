package ua.training.model.entity;

import java.time.LocalDate;

/**
 * This interface describes salable object common interface.
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public interface Salable {
    /**
     * Get price of goods
     * @return The price of goods
     */
    double getPrice();

    /**
     * Get date of supply of goods
     * @return The date of supply of goods
     */
    LocalDate getDateOfSupply();
}
