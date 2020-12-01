package com.exasol.adapter.sql;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.AdapterException;
import com.exasol.mocking.MockUtils;

class SqlPredicateBetweenTest {
    private SqlPredicateBetween sqlPredicateBetween;
    private SqlNode expression;
    private SqlNode betweenLeft;
    private SqlNode betweenRight;

    @BeforeEach
    void setUp() {
        this.expression = new SqlLiteralDouble(12.0);
        this.betweenLeft = new SqlLiteralDouble(11.0);
        this.betweenRight = new SqlLiteralDouble(13.0);
        this.sqlPredicateBetween = new SqlPredicateBetween(this.expression, this.betweenLeft, this.betweenRight);
    }

    @Test
    void testGetType() {
        assertThat(this.sqlPredicateBetween.getType(), equalTo(SqlNodeType.PREDICATE_BETWEEN));
    }

    @Test
    void testGetExpression() {
        assertThat(this.sqlPredicateBetween.getExpression(), equalTo(this.expression));
    }

    @Test
    void testGetBetweenLeft() {
        assertThat(this.sqlPredicateBetween.getBetweenLeft(), equalTo(this.betweenLeft));
    }

    @Test
    void testGetBetweenRight() {
        assertThat(this.sqlPredicateBetween.getBetweenRight(), equalTo(this.betweenRight));
    }

    @Test
    void testAccept() throws AdapterException {
        final SqlNodeVisitor<SqlPredicateBetween> visitor = MockUtils.mockSqlNodeVisitor();
        when(visitor.visit(this.sqlPredicateBetween)).thenReturn(this.sqlPredicateBetween);
        assertThat(this.sqlPredicateBetween.accept(visitor), equalTo(this.sqlPredicateBetween));
    }
}