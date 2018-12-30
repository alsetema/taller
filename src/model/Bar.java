package model;

public class Bar {
    private String colour;
    private String series;
    private double length;
    private double thickness;
    private String name;

    public Bar(String colour, String series, double length, double thickness, String name) {
        this.colour = colour; //this will set the colour from the constructor to the class
        this.length = length;
        this.series = series;
        this.thickness = thickness;
        this.name = name;
    }

    //empty constructor
    public Bar() { }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return this.colour;
    }

    public String getSeries() {
        return this.series;
    }

    public double getLength() {
        return this.length;
    }

    public double getThickness() {
        return this.thickness;
    }

    public String getName() {
        return this.name;
    }
}

