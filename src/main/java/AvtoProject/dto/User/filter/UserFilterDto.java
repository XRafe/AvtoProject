package AvtoProject.dto.User.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import AvtoProject.enums.UserField;

import java.util.Collection;

@Getter
public class UserFilterDto {

    private final UserField userField;

    private final Collection<String> values;

    public UserFilterDto(@JsonProperty("userField") UserField userField,
                         @JsonProperty("values") Collection<String> values) {
        this.userField = userField;
        this.values = values;
    }
}