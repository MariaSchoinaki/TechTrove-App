package com.example.tecktrove.util;

import java.math.BigDecimal;
import java.util.Currency;



/**
 * The main purpose of this class is to provide
 * an easy and safe way to apply money transactions.
 * This class validates the currency of transactions
 * and does the basic math operations.
 */


public class Money {

    private BigDecimal amount;
    private Currency currency;

    /**
     * Constructor of Money
     *
     * @param amount        the amount of transaction
     * @param currency      the total customer charge as Money type
     *
     */
    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Gets the amount of transaction
     *
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Gets the Currency
     *
     * @return the Currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Returns the sum of two Money values of the same currency as
     * a new Object of the class Money.
     *
     * @param other the amount added.
     * @return the sum of the two amounts
     * @throws IllegalArgumentException if the amounts don't have the same currency
     */
    public Money plus(Money other) {
        checkForSameCurrencies(other);
        return new Money(amount.add(other.amount), currency);
    }


    /**
     * Returns the subtraction of two Money values of the same currency as
     * a new Object of the class Money.
     *
     * @param other the amount subtracted.
     * @return the subtract of the two amounts
     * @throws IllegalArgumentException if the amounts don't have the same currency
     */
    public Money minus(Money other) {
        checkForSameCurrencies(other);
        return new Money(amount.subtract(other.amount), currency);
    }

    /**
     * Multiplies the amount by some factor
     *
     * @param factor the factor
     * @return the Money Object as the result of the multiplication
     */
    public Money times(BigDecimal factor) {
        return new Money(amount.multiply(factor), currency);
    }

    /**
     * Multiplies the amount by some factor
     *
     * @param factor the factor
     * @return the Money Object as the result of the multiplication
     */
    public Money times(long factor) {
        return new Money(amount.multiply(BigDecimal.valueOf(factor)), currency);
    }


    /**
     * Divides the sum by some divisor
     *
     * @param divisor the divisor
     * @return The object with the result of the division
     */
    public Money divide(BigDecimal divisor) {
        return new Money(amount.divide(divisor), currency);
    }

    /**
     * Divides the sum by some divisor
     *
     * @param divisor the divisor
     * @return The object with the result of the division
     */
    public Money divide(long divisor) {
        return new Money(amount.divide(BigDecimal.valueOf(divisor)), currency);
    }

    /**
     * Checks if this object has the same currency with Money object other
     *
     * @param other the other object of type Money
     * @throws IllegalArgumentException if they don't have the same currency
     */
    private void checkForSameCurrencies(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Different Currencies");
        }
    }

    /**
     * Returns the amount of money in the euro currency unit.
     *
     * @param amount the amount
     * @return The object with the amount and currency unit euro
     */

    public static Money euros(BigDecimal amount) {
        return new Money(amount, Currency.getInstance("EUR"));
    }

    /**
     * Returns the amount of money in the euro currency unit.
     *
     * @param amount the amount
     * @return The object with the amount and currency unit euro
     */
    public static Money euros(long amount) {
        return euros(BigDecimal.valueOf(amount));
    }

    /**
     * Returns the amount of money in the dollar currency unit.
     *
     * @param amount the amount
     * @return The object with the amount and currency unit dollar
     */
    public static Money dollars(BigDecimal amount) {
        return new Money(amount, Currency.getInstance("USD"));
    }


    /**
     * Returns the amount of money in the dollar currency unit.
     *
     * @param amount the amount
     * @return The object with the amount and currency unit dollar
     */
    public static Money dollars(long amount) {
        return dollars(BigDecimal.valueOf(amount));
    }

    /**
     * Compare Money with another object.
     * If they have the same currency and amount,
     * they are the same
     *
     * @param other another object
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof Money)) {
            return false;
        }

        Money theMoney = (Money) other;
        if (currency == null) {
            return theMoney.currency == null
                    && amount == null && theMoney.amount == null;
        }

        if (!currency.equals(theMoney.currency)) {
            return false;
        }

        return amount == null ? theMoney.amount == null
                : (amount.compareTo(theMoney.amount) == 0);
    }

    /**
     * Get the hash Code based of the amount hash code
     *
     * @return te hash code as an integer
     */
    @Override
    public int hashCode() {
        return amount == null ? 0 : amount.hashCode();
    }

    /**
     * Returns Money Objects as string like "amount currency"
     *
     * @return the amount and the currency as string
     */
    @Override
    public String toString() {
        return amount.toString() + " " + currency.getSymbol();
    }
}
