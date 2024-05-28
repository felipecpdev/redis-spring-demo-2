package org.felipecpdev.redisspringdemo2.repositories;

import org.felipecpdev.redisspringdemo2.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
