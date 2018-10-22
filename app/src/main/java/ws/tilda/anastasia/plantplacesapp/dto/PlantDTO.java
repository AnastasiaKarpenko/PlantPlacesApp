package ws.tilda.anastasia.plantplacesapp.dto;

public class PlantDTO {
    private int guid;
    private String genus;
    private String species;
    private String cultivar;
    private String common;
    private String type;
    private int size;
    private String fallColor;

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCultivar() {
        return cultivar;
    }

    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFallColor() {
        return fallColor;
    }

    public void setFallColor(String fallColor) {
        this.fallColor = fallColor;
    }

    @Override
    public String toString() {
        return genus + " " + species + " " + cultivar + " " + common + " ";
    }
}
