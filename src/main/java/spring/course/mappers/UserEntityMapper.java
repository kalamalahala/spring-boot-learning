package spring.course.mappers;

import org.springframework.stereotype.Component;
import spring.course.data.UserEntity;
import spring.course.model.UserModel;

@Component
public class UserEntityMapper implements EntityMapper<UserEntity, UserModel>{

    @Override
    public UserModel entityToModel(UserEntity entity) {
        return new UserModel(
                entity.getUsername(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPassword()
        );
    }

    @Override
    public UserEntity modelToEntity(UserModel model) {

        return new UserEntity(
                model.getUsername(),
                model.getFirstName(),
                model.getLastName(),
                model.getEmail(),
                model.getPassword()
        );
    }
}
