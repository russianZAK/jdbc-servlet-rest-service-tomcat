package by.russianzak.servlet.dto.slim;

public class ResponseStreetSlimDto {
    private Long id;
    private String name;
    private Long postalCode;

    public ResponseStreetSlimDto(Long id, String name, Long postalCode) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
