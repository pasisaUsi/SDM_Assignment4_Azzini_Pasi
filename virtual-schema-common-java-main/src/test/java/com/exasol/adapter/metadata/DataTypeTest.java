package com.exasol.adapter.metadata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.exasol.adapter.metadata.datatype.*;
import com.exasol.adapter.metadata.datatype.DoubleType;

class DataTypeTest {
    @Test
    void createDecimal() {
        final DataType dataType = new DecimalType(10, 2);
        assertAll(() -> assertThat(dataType.getPrecision(), equalTo(10)),
                () -> assertThat(dataType.getScale(), equalTo(2)),
                () -> assertThat(dataType.toString(), equalTo("DECIMAL(10, 2)")));
    }

    @Test
    void createDouble() {
        final DataType dataType = new DoubleType();
        assertThat(dataType.toString(), equalTo("DOUBLE"));
    }

    @Test
    void createVarChar() {
        final DataType dataType = new VarCharType(100, ExaCharset.UTF8);
        assertAll(() -> assertThat(dataType.getCharset(), equalTo(ExaCharset.UTF8)),
                () -> assertThat(dataType.getSize(), equalTo(100)),
                () -> assertThat(dataType.toString(), equalTo("VARCHAR(100) UTF8")));
    }

    @Test
    void createChar() {
        final DataType dataType = new CharType(101, ExaCharset.UTF8);
        assertAll(() -> assertThat(dataType.getCharset(), equalTo(ExaCharset.UTF8)),
                () -> assertThat(dataType.getSize(), equalTo(101)),
                () -> assertThat(dataType.toString(), equalTo("CHAR(101) UTF8")));
    }

    @Test
    void createTimestampWithLocalTimezone() {
        final DataType dataType = new TimeStampType(true);
        assertAll(() -> assertTrue(dataType.isWithLocalTimezone()),
                () -> assertThat(dataType.toString(), equalTo("TIMESTAMP WITH LOCAL TIME ZONE")));
    }

    @Test
    void createTimestampWithoutLocalTimezone() {
        final DataType dataType = new TimeStampType(false);
        assertAll(() -> assertFalse(dataType.isWithLocalTimezone()),
                () -> assertThat(dataType.toString(), equalTo("TIMESTAMP")));
    }

    @Test
    void createBool() {
        final DataType dataType = new BoolType();
        assertThat(dataType.toString(), equalTo("BOOLEAN"));
    }

    @Test
    void createUnsupported() {
        final DataType dataType = new UnsupportedType();
        assertThat(dataType.toString(), equalTo("UNSUPPORTED"));
    }

    @Test
    void createDate() {
        final DataType dataType = new DateType();
        assertThat(dataType.toString(), equalTo("DATE"));
    }

    @Test
    void createGeometry() {
        final DataType dataType = new GeometryType(4);
        assertAll(() -> assertThat(dataType.getGeometrySrid(), equalTo(4)),
                () -> assertThat(dataType.toString(), equalTo("GEOMETRY(4)")));
    }

    @Test
    void createIntervalDaySecond() {
        final DataType dataType = new IntervalDaySecondType(10, 2);
        assertAll(() -> assertThat(dataType.getPrecision(), equalTo(10)),
                () -> assertThat(dataType.getIntervalFraction(), equalTo(2)),
                () -> assertThat(dataType.toString(), equalTo("INTERVAL DAY (10) TO SECOND (2)")));
    }

    @Test
    void createIntervalYearMonth() {
        final DataType dataType = new IntervalYearMonthType(10);
        assertAll(() -> assertThat(dataType.getPrecision(), equalTo(10)),
                () -> assertThat(dataType.toString(), equalTo("INTERVAL YEAR (10) TO MONTH")));
    }

    @Test
    void testCreateMaximumSizeVarChar() {
        final DataType dataType = new CharType(ExaCharset.ASCII);
        assertAll(() -> assertThat(dataType.getExaDataType(), equalTo(ExaDataType.VARCHAR)),
                () -> assertThat(dataType.getSize(), equalTo(DataType.MAX_EXASOL_VARCHAR_SIZE)),
                () -> assertThat(dataType.getCharset(), equalTo(ExaCharset.ASCII)));
    }

    @Test
    void testCreateMaximumSizeChar() {
        final DataType dataType = new CharType(ExaCharset.ASCII);
        assertAll(() -> assertThat(dataType.getExaDataType(), equalTo(ExaDataType.CHAR)),
                () -> assertThat(dataType.getSize(), equalTo(DataType.MAX_EXASOL_CHAR_SIZE)),
                () -> assertThat(dataType.getCharset(), equalTo(ExaCharset.ASCII)));
    }

    @Test
    void createHashtype() {
        final DataType dataType = DataType.createHashtype(16);
        assertAll(() -> assertThat(dataType.getByteSize(), equalTo(16)),
                () -> assertThat(dataType.toString(), equalTo("HASHTYPE(16 byte)")));
    }

    @Test
    void testIsSupportedDate() {
        assertThat(new DateType().isSupported(), equalTo(true));
    }

    @Test
    void testIsSupportedForUnsupporteTypeFalse() {
        assertThat(new UnsupportedType().isSupported(), equalTo(false));
    }
}