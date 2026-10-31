package net.minecraftforge.common;
public class ForgeConfigSpec {
    public static class Builder {
        public Builder comment(String... lines) { return this; }
        public DoubleValue defineInRange(String path, double defaultValue, double min, double max) { return null; }
        public IntValue defineInRange(String path, int defaultValue, int min, int max) { return null; }
        public ForgeConfigSpec build() { return null; }
    }
    public static class ConfigValue<T> {
        public T get() { return null; }
    }
    public static class DoubleValue extends ConfigValue<Double> {}
    public static class IntValue extends ConfigValue<Integer> {}
}
