package Krabs.Amigos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

//@JsonIgnoreProperties({"address"})
public class Person {
    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String address;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("address") String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    } //comment

    public String getAddress() {
        return address;
    }
}
