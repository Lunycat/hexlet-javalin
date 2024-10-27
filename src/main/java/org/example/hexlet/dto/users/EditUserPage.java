package org.example.hexlet.dto.users;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.User;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class EditUserPage {

    private User user;
    private Map<String, List<ValidationError<Object>>> errors;
}
