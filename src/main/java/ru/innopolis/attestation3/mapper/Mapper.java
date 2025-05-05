package ru.innopolis.attestation3.mapper;

import java.util.List;

public interface Mapper <E,D>{
    E toEntity(D dto);
    D toDto(E entity);
    List<E> toEntities(List<D> dtoList);
    List<D> toDtos(List<E> entityList);
}
