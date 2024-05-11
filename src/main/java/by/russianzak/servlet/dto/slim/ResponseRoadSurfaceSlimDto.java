package by.russianzak.servlet.dto.slim;

public class ResponseRoadSurfaceSlimDto {
    private Long id;

    private String type;
    private String description;
    private double frictionCoefficient;
    public ResponseRoadSurfaceSlimDto(Long id, String type, String description, double frictionCoefficient) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.frictionCoefficient = frictionCoefficient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFrictionCoefficient() {
        return frictionCoefficient;
    }

    public void setFrictionCoefficient(double frictionCoefficient) {
        this.frictionCoefficient = frictionCoefficient;
    }

}
