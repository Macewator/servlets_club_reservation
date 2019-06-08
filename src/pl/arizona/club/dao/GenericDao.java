package pl.arizona.club.dao;

public interface GenericDao <R,T> {
    void create(T t);
    T read(R r);
    void updateAll(T t);
    void delete(R r);

}
