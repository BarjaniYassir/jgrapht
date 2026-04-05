package org.jgrapht.nio;

public class DefaultAttributeFactory {

    /**
     * The null attribute.
     */
    public final factory<?> NULL = new factory<>(null, AttributeType.NULL);

    public factory<Boolean> createBoolean(Boolean value) {
        return new factory<>(value, AttributeType.BOOLEAN);
    }

    public factory<Integer> createInteger(Integer value) {
        return new factory<>(value, AttributeType.INT);
    }

    public factory<Long> createLong(Long value) {
        return new factory<>(value, AttributeType.LONG);
    }

    public factory<Float> createFloat(Float value) {
        return new factory<>(value, AttributeType.FLOAT);
    }

    public factory<Double> createDouble(Double value) {
        return new factory<>(value, AttributeType.DOUBLE);
    }

    public factory<String> createString(String value) {
        return new factory<>(value, AttributeType.STRING);
    }
}
