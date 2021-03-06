package com.exasol.adapter.sql;

/**
 * Specifies the type of a SelectList.
 */
public enum SqlSelectListType {
    /**
     * The user requests all available columns, i.e. SELECT * FROM ...
     */
    SELECT_STAR,
    /**
     * We just need one arbitrary value for each row. Example: If user runs COUNT (*) and COUNT cannot be pushed down,
     * we need to return any value for each row (e.g. constant TRUE) and then EXASOL can do the COUNT.
     */
    ANY_VALUE,
    /**
     * The user has to specify the desired elements.
     */
    REGULAR
}
