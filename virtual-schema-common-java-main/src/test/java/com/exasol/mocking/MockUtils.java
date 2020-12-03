package com.exasol.mocking;

import org.mockito.Mockito;

import com.exasol.adapter.sql.SqlNodeVisitor;

/**
 * Utility class
 * This class contains static helper methods to improve mocking convenience.
 */
public final class MockUtils {

    // Private constructor to prevent instantiation
    private MockUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Create a mock for an {@link SqlNodeVisitor}.
     * <p>
     * The {@link SqlNodeVisitor} needs to be parameterized with the type it is visiting. Since we do not have this
     * option when mocking the class, this helper method makes sure we need to suppress the "unchecked type conversion"
     * warning in only one place.
     *
     * @param <T> Generic type visited by the {@link SqlNodeVisitor}
     * @return mocked visitor
     */
    @SuppressWarnings("unchecked")
    public static <T> SqlNodeVisitor<T> mockSqlNodeVisitor() {
        return Mockito.mock(SqlNodeVisitor.class);
    }
}