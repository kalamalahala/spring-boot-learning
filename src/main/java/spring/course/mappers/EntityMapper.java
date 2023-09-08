package spring.course.mappers;

public interface EntityMapper<T, U> {
    U entityToModel(T entity);

    T modelToEntity(U model);
}
