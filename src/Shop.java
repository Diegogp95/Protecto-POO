public class Shop {

    // atributos
    private final int id;
    private static int nextId = 0;
    private int viewId;
    private String normaRecepcion = null;
    private String normaDominio = null;
    private String arrendatario = null;
    private String shopName = null;
    private String precioArriendo = null;
    private String montoGarantia = null;
    private String fechaInicio = null;
    private String fechaTermino = null;
    private String giroLocal = null;
    private String normaGiro = null;
    private String fechaTransferencia = null;
    private String normaTransferencia = null;
    private String fechaConsumoLuz = null;
    private String normaLuz = null;
    private String numeroClienteLuz = null;
    private String fechaConsumoAgua = null;
    private String normaAgua = null;
    private String numeroClienteAgua = null;
    private String fechaConsumoGas = null;
    private String normaGas = null;
    private String numeroClienteGas = null;


    // metodos
    // constructor
    public Shop(String name, int id) {
        shopName = name;
        viewId = id;
    }

    {
        id = nextId++;
    }

    // Setter -----------------------------------------
    //recepcion final
    public void setNormaRecepcion(String entrada) {
        normaRecepcion = entrada;
    }

    //certificado de dominio vigente
    public void setNormaDominio(String entrada) {
        normaDominio = entrada;
    }

    //contrato
    public void setArrendatario(String entrada) {
        arrendatario = entrada;
    }

    public void setNombreLocal(String entrada) {
        shopName = entrada;
    }

    public void setPrecioArriendo(String entrada) {
        precioArriendo = entrada;
    }

    public void setMontoGarantia(String entrada) {
        montoGarantia = entrada;
    }

    public void setFechaInicio(String entrada) {
        fechaInicio = entrada;
    }

    public void setFechaTermino(String entrada) {
        fechaTermino = entrada;
    }

    //giro
    public void setGiroloLocal(String entrada) {
        giroLocal = entrada;
    }

    public void setNormaGiro(String entrada) {
        normaGiro = entrada;
    }

    //transferencia de arriendo
    public void setFechaTransferencia(String entrada) {
        fechaTransferencia = entrada;
    }

    public void setNormaTransferencia(String entrada) {
        normaTransferencia = entrada;
    }

    //pago luz
    public void setFechaConsumoLuz(String entrada) {
        fechaConsumoLuz = entrada;
    }

    public void setNormaLuz(String entrada) {
        normaLuz = entrada;
    }

    public void setNumeroClienteLuz(String entrada) {
        numeroClienteLuz = entrada;
    }

    //pago agua
    public void setFechaConsumoAgua(String entrada) {
        fechaConsumoAgua = entrada;
    }

    public void setNormaAgua(String entrada) {
        normaAgua = entrada;
    }

    public void setNumeroClienteAgua(String entrada) {
        numeroClienteAgua = entrada;
    }

    //pago gas
    public void setFechaConsumoGas(String entrada) {
        fechaConsumoGas = entrada;
    }

    public void setNormaGas(String entrada) {
        normaGas = entrada;
    }

    public void setNumeroClienteGas(String entrada) {
        numeroClienteGas = entrada;
    }

    // Getters---------------------------------------------
    public int getId() {
        return id;
    }

    //recepcion final
    public String getNormaRecepcion() {
        return normaRecepcion;
    }

    //certificado de dominio vigente
    public String getNormaDominio() {
        return normaDominio;
    }

    //contrato
    public String getArrendatario() {
        return arrendatario;
    }

    public String getNombreLocal() {
        return shopName;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getViewId() {
        return viewId;
    }

    public String getShopName() {
        return shopName;
    }

    public String getPrecioArriendo() {
        return precioArriendo;
    }

    public String getMontoGarantia() {
        return montoGarantia;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public String getGiroLocal() {
        return giroLocal;
    }

    public String getNormaGiro() {
        return normaGiro;
    }

    public String getFechaTransferencia() {
        return fechaTransferencia;
    }

    public String getNormaTransferencia() {
        return normaTransferencia;
    }

    public String getFechaConsumoLuz() {
        return fechaConsumoLuz;
    }

    public String getNormaLuz() {
        return normaLuz;
    }

    public String getNumeroClienteLuz() {
        return numeroClienteLuz;
    }

    public String getFechaConsumoAgua() {
        return fechaConsumoAgua;
    }

    public String getNormaAgua() {
        return normaAgua;
    }

    public String getNumeroClienteAgua() {
        return numeroClienteAgua;
    }

    public String getFechaConsumoGas() {
        return fechaConsumoGas;
    }

    public String getNormaGas() {
        return normaGas;
    }

    public String getNumeroClienteGas() {
        return numeroClienteGas;
    }

    public static void resetId(){
        nextId = 0;
        return;
    }

    public String toString() {
        return ("" + "\t" + this.viewId + "\t" + this.shopName + "\t" + this.normaRecepcion +
                "\t" + this.normaDominio + "\t" + this.arrendatario + "\t" + this.precioArriendo + "\t" +
                this.montoGarantia + "\t" + this.fechaInicio + "\t" + this.fechaTermino + "\t" + this.giroLocal +
                "\t" + this.normaGiro + "\t" + this.fechaTransferencia + "\t" + this.normaTransferencia + "\t" +
                this.fechaConsumoLuz + "\t" + this.normaLuz + "\t" + this.numeroClienteLuz + "\t" + this.fechaConsumoAgua
                + "\t" + this.normaAgua + "\t" + this.numeroClienteAgua + "\t" + this.fechaConsumoGas + "\t" +
                this.normaGas + "\t" + this.numeroClienteGas);
    }
}

