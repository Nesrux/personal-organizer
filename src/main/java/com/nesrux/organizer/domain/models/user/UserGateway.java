package com.nesrux.organizer.domain.models.user;

import java.util.List;

public interface UserGateway {

    public User getUserById(final String id);

    public void deleteUserById(final String id);

    public List<User> listUsers();

}
