package com.exasol.adapter.sql;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.AdapterException;
import com.exasol.mocking.MockUtils;

class SqlLiteralTimestampUtcTest {
    private static final String VALUE = "2019-02-07 23:59:00";
    private SqlLiteralTimestampUtc sqlLiteralTimestampUtc;

    @BeforeEach
    void setUp() {
        this.sqlLiteralTimestampUtc = new SqlLiteralTimestampUtc(VALUE);
    }

    @Test
    void testGetValue() {
        assertThat(this.sqlLiteralTimestampUtc.getValue(), equalTo(VALUE));
    }

    @Test
    void testGetType() {
        assertThat(this.sqlLiteralTimestampUtc.getType(), equalTo(SqlNodeType.LITERAL_TIMESTAMPUTC));
    }

    @Test
    void testAccept() throws AdapterException {
        final SqlNodeVisitor<SqlLiteralTimestampUtc> visitor = MockUtils.mockSqlNodeVisitor();
        when(visitor.visit(this.sqlLiteralTimestampUtc)).thenReturn(this.sqlLiteralTimestampUtc);
        assertThat(this.sqlLiteralTimestampUtc.accept(visitor), equalTo(this.sqlLiteralTimestampUtc));
    }
}