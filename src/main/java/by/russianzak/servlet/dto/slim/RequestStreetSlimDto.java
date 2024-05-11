package by.russianzak.servlet.dto.slim;

public class RequestStreetSlimDto {
    private String name;
    private Long postalCode;
    public RequestStreetSlimDto(String name, Long postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

}
