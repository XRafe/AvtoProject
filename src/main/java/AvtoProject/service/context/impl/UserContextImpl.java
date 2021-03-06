package AvtoProject.service.context.impl;

import lombok.Getter;
import lombok.Setter;
import AvtoProject.service.context.UserContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class UserContextImpl implements UserContext {

    @Getter
    @Setter
    private String login = null;
}