package service;

public interface IConvierteDatos {

    <T> T ObtenerDatos(String json, Class<T> clase);

}
