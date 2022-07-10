package rw.ac.rca.nat2022.anselme.server.services;

import rw.ac.rca.nat2022.anselme.server.models.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User save(User user);

    User getLoggedInUser();
}
