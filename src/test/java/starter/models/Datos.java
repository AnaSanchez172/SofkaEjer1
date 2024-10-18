package starter.models;

public class Datos {
    private DatosUserLogin datosUserLogin;
    private DatosCompra datosCompra;
    private String mensajeEsperado;

    public DatosUserLogin getDatosUserLogin() {
        return datosUserLogin;
    }

    public void setDatosUserLogin(DatosUserLogin datosUserLogin) {
        this.datosUserLogin = datosUserLogin;
    }

    public DatosCompra getDatosCompra() {
        return datosCompra;
    }

    public void setDatosCompra(DatosCompra datosCompra) {
        this.datosCompra = datosCompra;
    }

    public String getMensajeEsperado() {
        return mensajeEsperado;
    }

    public void setMensajeEsperado(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
    }
}
