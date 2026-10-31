package net.minecraft.resources;
public class ResourceLocation implements Comparable<ResourceLocation> {
    public ResourceLocation(String namespace, String path) {}
    public ResourceLocation(String full) {}
    public String getNamespace() { return null; }
    public String getPath() { return null; }
    @Override public int compareTo(ResourceLocation o) { return 0; }
    @Override public boolean equals(Object o) { return super.equals(o); }
    @Override public int hashCode() { return super.hashCode(); }
    @Override public String toString() { return super.toString(); }
}
